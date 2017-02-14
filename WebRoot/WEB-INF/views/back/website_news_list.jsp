<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新闻动态列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>
<script type="text/javascript" src="js/system/keditor.js"></script>
<script>
	var basePath = "<%=basePath%>";
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('#contentHtml', {
			width : '750px',
			height:'300px',
			cssPath : '../js/kingeditor/plugins/code/prettify.css',
			//uploadJson : 'jsp/upload_json.jsp',
			uploadJson : basePath + 'keUpload.do?model=website_news_content',
			fileManagerJson : 'jsp/file_manager_json.jsp',
			allowFileManager : true,
			items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
        'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
        'anchor', 'link', 'unlink', 'media'],
			afterChange : function() {
				this.sync();// 这个是必须的,如果你要覆盖afterChange事件的话,请记得最好把这句加上.
			},
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['fm'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['fm'].submit();
				});
			}
		});
		prettyPrint();
	});
	
</script>

<script type="text/javascript">
	$(function() {
	  $('#addBtn').click(function(){
		  doAdd(function(){
			  $('#imgShow').attr('src','');
			  $('#addImg').show();
			  $('#imgShow').hide();
			  $('#status').combobox('select', 1);
			  $('#categoryIdLabel').combobox({
			    url:'system/comboCategoryByCode.do?code=news',
			    valueField:'id',
			    textField:'name',
			    onLoadSuccess:function(){
					var data = $('#categoryIdLabel').combobox('getData');
					if(data!=''){
						var id = data[0].id;
						$('#categoryIdLabel').combobox('select',id);
					}
				}
			  });			  
			  editor.html('');
		  });
	  });
	  
	  $('#editBtn').click(function(){
		  $('#categoryIdLabel').combobox({
		    url:'system/comboCategoryByCode.do?code=news',
		    valueField:'id',
		    textField:'name'
		  });
		  doEdit(function(row){
			  $('#addImg').hide();			  
			  $('#imgShow').attr('src','downFileResult.do?urlPath=' + row.systemPictureInfo.urlPath);
			  $('#imgShow').show();
			  editor.html(row.content);
		  });
	  });
	  
	  $('#deleteBtn').click(function(){
		  doDelete('system/websiteNewsTAjaxDelete.do');
	  });
	  
	  $('#lockOpenBtn').click(function(){
		  doUpdateStatus('system/websiteNewsTAjaxUpdate.do',1);
	  });
	  
	  $('#lockBtn').click(function(){
		  doUpdateStatus('system/websiteNewsTAjaxUpdate.do',0);
	  });
	  
	});
	
	function formatImg(value, row) {
		if(row.systemPictureInfo){
			var url = 'downFileResult.do?urlPath=' + row.systemPictureInfo.urlPath;
			return "<img src="+ url +" style=\"height:100px;width:100px;background-color:#434343\"/>";	
		}		
	}
	
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
	}
</script>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}

div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	text-align: left;
	padding: 2px;
}
</style>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 5px;
}

.ftitle {
	font-size: 12px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 65px;
}

.fitem input {
	width: 280px;
}
</style>
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'system/websiteNewsTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th data-options="field:'urlPath',align:'left',sortable:true,formatter:formatImg" style="width: 10%;">预览图</th>
					<th data-options="field:'title',align:'center',sortable:true" style="width: 20%;">新闻标题</th>
					<th data-options="field:'categoryName',align:'center',sortable:true" style="width: 20%;">类别</th>
					<th data-options="field:'status',align:'center',sortable:true,formatter:formatStatus" style="width: 10%;">状态</th>
					<th data-options="field:'createDateStr',align:'center',sortable:true" style="width: 20%;">上传时间</th>
				</tr>
			</thead>
		</table>
		<div id="dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:100%;height:100%;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post" action="system/websiteNewsTAjaxSave.do">
				<div class="fitem">
					<div style="float: left;margin-top: 25px;"><font color="red">*</font>预览图:</div>
					<div id="showImage" class="showImage" style="width:100px;height:100px;border:1px solid;margin-left:70px;cursor:pointer;text-align:center;" >
						<!-- <img id="imgShow" class="imgShow" src="images/add.png" style="width:50px;height:50px;"/> -->
						<img id="addImg" class="addImg" src="images/add.png" style="width:50px;height:50px;padding-top: 25px;"/>
						<img id="imgShow" class="imgShow" src="" style="display:none;width:100%;height:100%;"/>
					</div>
					<div style="width:100px;margin-left:70px;text-align:center;" >建议尺寸(200*200)</div>
					<!-- <img id="imgShow" class="imgShow" style="margin-left: 40px;cursor:pointer;background-color:#434343" src="images/add.png" /> -->
					<input type="file" id="up_img" name="uploadFile" style="display: none;"/>
					<input type="hidden" id="idLabel" name="id" />
					<input type="hidden" id="imgUuidLabel" name="imgUuid">
					<input type="hidden" id="operType" name="operType">
				</div>
				<div class="fitem">
					<label><font color="red">*</font>新闻标题:</label>
					<input id="titleLabel" name="title" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,100]'"/>
				</div>
				<div class="fitem">
					<label>新闻类别:</label>
					<select id="categoryIdLabel" name="catagoryId" class="easyui-combobox" style="width:100px;" 
						data-options="panelHeight:'auto',editable:false">
					</select>
				</div>
				<div class="fitem">
					<label>状态:</label>
					<select id="status" name="status" class="easyui-combobox" style="width:100px;" 
						data-options="panelHeight:'auto',editable:false"
						>
						<option value="1" selected="selected">启用</option>
						<option value="0">禁用</option>
					</select>
				</div>
				
				<div class="fitem">
					<label>内容:</label> <textarea id="contentHtml" name="content"></textarea>
				</div>
			</form>
		</div>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="addBtn">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="editBtn">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="deleteBtn">删除</a>	
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true" id="lockOpenBtn">启用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lockBtn">禁用</a>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="uploadAndSave()" style="width:90px">确定</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		</div>
	</div>
	<script type="text/javascript" src="js/stream/js/stream-v1.js"></script>
	<script type="text/javascript" src="js/stream/js/stream-upload-util.js"></script>
	<script type="text/javascript">
	 	  var index;
		  var stream = singleCommonUpload('website_news',function(file){
		      var inputs = ''; 
			  for(var prop in file){
				  var value = file[prop];
				  if(prop == 'id'){
					  continue;
				  }
				  if($('input[name="' + prop + '"]').size() <= 0){
					  inputs += '<input type="hidden" id="'+prop+'" name="'+prop+'" value="'+value+'" />';
				  }else{
					  $('input[name="' + prop + '"]').remove();
					  inputs += '<input type="hidden" id="'+prop+'" name="'+prop+'" value="'+value+'" />';
				  }
			  }  
			  $('#fm').append(inputs);
			  save();	
		});
		
		function uploadAndSave(){
			var operType = $('#operType').val();
			if(operType == ''){
				//不上传图片,直接进行操作
				if(!validation()){
					return false;
				}
				save();
				return false;	
			}
			if(!validation()){
				return false;
			}
			stream.upload();
		}
		
		function save(){
		  $('#fm').form('submit', {
		    dataType: 'json',
		    success: function(result) {
		      var result = eval('(' + result + ')');
		      console.log(result);
		      layer.close(index);
		      if (result.success) {
		        $('#dlg').dialog('close'); // close the dialog
		        $('#dg').datagrid('reload'); // reload the menu data
		      } else {
		        $.messager.alert('错误信息', result.msg, 'error');
		        return false;
		      }
		    }
		  });
		}
		
		function validation(){
			var src = $('#imgShow').attr('src');
			if (src == '') {
		        $.messager.alert('错误信息', '请上传图片!', 'error');
		        return false;
		    }
			var rr = $('#fm').form('enableValidation').form('validate');
		    if (rr) {
		    	index = layer.load('操作中...请等待！', 0);
		    } else {
		        return false;
		    }
		    return true;
		}
	</script>
</body>
</html>
