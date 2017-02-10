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

<title>网站首页经典案例</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>
<!-- <script type="text/javascript" src="js/uploadPreview.js"></script> -->

<script type="text/javascript">
	$(function() {
	  $('#addBtn').click(function(){
		  doAdd(function(){
			  $('#imgShow').attr('src','');
			  $('#addImg').show();
			  $('#imgShow').hide();
			  $('#status').combobox('select', 1);
		  });
	  });
	  
	  $('#editBtn').click(function(){
		  doEdit(function(row){
			  $('#addImg').hide();
			  $('#imgShow').attr('src','downFileResult.do?urlPath=' + row.systemPictureInfo.urlPath);
			  $('#imgShow').show();
			  $('#operType').val('');
		  });
	  });
	  
	  $('#deleteBtn').click(function(){
		  doDelete('system/websiteHomepageCaseTAjaxDelete.do');
	  });
	  
	  $('#lockOpenBtn').click(function(){
		  doUpdateStatus('system/websiteHomepageCaseTAjaxUpdate.do',1);
	  });
	  
	  $('#lockBtn').click(function(){
		  doUpdateStatus('system/websiteHomepageCaseTAjaxUpdate.do',0);
	  });
	  
	});
	
	function formatImg(value, row) {
		if(row.systemPictureInfo){
			var url = 'downFileResult.do?urlPath=' + row.systemPictureInfo.urlPath;
			return "<img src="+ url +" style=\"height:90px;width:160px;background-color:#434343\"/>";	
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
			data-options="url:'system/websiteHomepageCaseTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th width="15%" data-options="field:'urlPath',align:'left',sortable:true,formatter:formatImg">图片</th>
					<th width="15%" data-options="field:'caseName',align:'center',sortable:true">名称</th>
					<th width="15%" data-options="field:'engText',align:'center',sortable:true">英文名称</th>
					<th width="5%" data-options="field:'orderList',align:'center',sortable:true">排序</th>
					<th width="5%" data-options="field:'status',align:'center',sortable:true,formatter:formatStatus">状态</th>
					<th width="15%" data-options="field:'createDateStr',align:'center',sortable:true">创建时间</th>
				</tr>
			</thead>
		</table>
		<div id="dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post" action="system/websiteHomepageCaseTAjaxSave.do">
				<div class="fitem">
					<div style="float: left;margin-top: 25px;"><font color="red">*</font>图片:</div>
					<div id="showImage" class="showImage" style="width:160px;height:90px;border:1px solid;margin-left:70px;cursor:pointer;text-align:center;" >
						<!-- <img id="imgShow" class="imgShow" src="images/add.png" style="width:50px;height:50px;"/> -->
						<img id="addImg" class="addImg" src="images/add.png" style="width:50px;height:50px;padding-top: 20px;"/>
						<img id="imgShow" class="imgShow" src="" style="display:none;width:100%;height:100%;"/>
					</div>
					<div style="width:160px;margin-left:70px;text-align:center;" >建议比例(16:9)</div>
					<input type="file" id="up_img" name="uploadFile" style="display: none;"/>
					<input type="hidden" id="idLabel" name="id" />
					<input type="hidden" id="imgUuidLabel" name="imgUuid">
					<input type="hidden" id="operType" name="operType">
				</div>
				<div class="fitem">
					<label><font color="red">*</font>名称:</label>
					<input id="brandNameLabel" name="caseName" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>
				</div>
				<div class="fitem">
					<label><font color="red">*</font>英文名称:</label>
					<input id="engTextLabel" name="engText" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>
				</div>
				<div class="fitem">
					<label>链接地址:</label>
					<input id="targetUrlLabel" name="targetUrl" style="width: 200px" class="easyui-textbox" data-options="validType:'length[1,100]'"/>
				</div>
				<div class="fitem">
					<label>状态:</label>
					<select id="status" name="status" class="easyui-combobox" style="width:100px;" data-options="panelHeight:'auto',editable:false">
						<option value="1" selected="selected">启用</option>
						<option value="0">禁用</option>
					</select>
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
		  var stream = singleCommonUpload('website_homepage_case',function(file){
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
