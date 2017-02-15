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

<title>经典案例</title>

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
			uploadJson : basePath + 'keUpload.do?model=website_case_content',
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
					document.forms['descFm'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['descFm'].submit();
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
			  $('#status').combobox('select', 1);
		  });
	  });
	  
	  $('#editBtn').click(function(){
		  doEdit();
	  });
	  
	  $('#editDescBtn').click(function(){
		  $('#descDlg').dialog('open').dialog('setTitle', '编辑描述内容');
	  });
	  
	  $('#deleteBtn').click(function(){
		  doDelete('system/websiteCaseTAjaxDelete.do');
	  });
	  
	  $('#lockOpenBtn').click(function(){
		  doUpdateStatus('system/websiteCaseTAjaxUpdate.do',1);
	  });
	  
	  $('#lockBtn').click(function(){
		  doUpdateStatus('system/websiteCaseTAjaxUpdate.do',0);
	  });
	  
	});
	
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
	}
	
	function formatOptions(value, row){
		return '<a href="system/websiteCaseAlbumTList.do?caseId=' + row.id +'">维护轮播图</a>'
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
			data-options="url:'system/websiteCaseTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';
	          	}   
	     	}">
			<thead>
				<tr>
					<th data-options="field:'caseName',width:160,align:'center',sortable:true" style="width: 20%;">案例名称</th>
					<th data-options="field:'status',width:150,align:'center',sortable:true,formatter:formatStatus" style="width: 10%;">状态</th>
					<th data-options="field:'createDateStr',width:200,align:'center',sortable:true" style="width: 20%;">上传时间</th>
					<th data-options="field:'options',width:200,align:'center',sortable:true,formatter:formatOptions" style="width: 20%;">操作</th>
				</tr>
			</thead>
		</table>
		<div id="dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post" action="system/websiteCaseTAjaxSave.do">
				<div class="fitem">
					<label><font color="red">*</font>案例名称:</label>
					<input id="caseNameLabel" name="caseName" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,25]'"/>
					<input type="hidden" id="idLabel" name="id" />
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
			</form>
		</div>
		<div id="descDlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:850px;height:500px;padding:10px 20px" closed="true"
			buttons="#descDlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="descFm" name="descFm" method="post" action="system/configInfoAjaxSave.do">
				<div class="fitem">
					<label>内容:</label> <textarea id="contentHtml" name="configValue">${configInfo.configValue}</textarea>
					<input type="hidden" id="idLabel" name="id" value="${configInfo.id }"/>
					<input type="hidden" id="configKeyLabel" name="configKey" value="website_case_content"/>
				</div>
			</form>
		</div>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="addBtn">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="editBtn">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="editDescBtn">编辑案例描述</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="deleteBtn">删除</a>	
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true" id="lockOpenBtn">启用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lockBtn">禁用</a>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="save()" style="width:90px">确定</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		</div>
		<div id="descDlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveDesc()" style="width:90px">确定</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#descDlg').dialog('close')" style="width:90px">取消</a>
		</div>
	</div>
	<script type="text/javascript">
	var index;		
	function save(){
	  $('#fm').form('submit', {
		onSubmit: function() {
		      if(!validation()){
		    	 return false;
		      }
		    },  
	    dataType: 'json',
	    success: function(result) {
	      var result = eval('(' + result + ')');
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
	
	function saveDesc(){
		$('#descFm').form('submit', {
			onSubmit: function() {
				var rr = $('#descFm').form('enableValidation').form('validate');
			    if (rr) {
			    	index = layer.load('操作中...请等待！', 0);
			    } else {
			        return false;
			    }
			},  
		    dataType: 'json',
		    success: function(result) {
		      var result = eval('(' + result + ')');
		      layer.close(index);
		      if (result.success) {
		        $('#descDlg').dialog('close'); // close the dialog
		        $('#dg').datagrid('reload'); // reload the menu data
		      } else {
		        $.messager.alert('错误信息', result.msg, 'error');
		        return false;
		      }
		    }
		  });
	}
	
	function validation(){
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
