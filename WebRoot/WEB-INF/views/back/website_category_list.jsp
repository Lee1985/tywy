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

<title>类别管理</title>

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
			  $('#status').combobox('select', 1);
			  $('#codeLabel').val('${code}');
		  });
	  });
	  
	  $('#editBtn').click(function(){
		  doEdit();
	  });
	  
	  $('#deleteBtn').click(function(){
		  doDelete('system/websiteCategoryTAjaxDelete.do');
	  });
	  
	  $('#lockOpenBtn').click(function(){
		  doUpdateStatus('system/websiteCategoryTAjaxUpdate.do',1);
	  });
	  
	  $('#lockBtn').click(function(){
		  doUpdateStatus('system/websiteCategoryTAjaxUpdate.do',0);
	  });
	  
	});
	
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
	}
	
	function searchData(){
		$('#dg').datagrid('load', {
			name : $('#nameInput').val()
		});
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
			data-options="url:'system/websiteCategoryTAjaxPage.do?code=${code }', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th data-options="field:'name',width:160,align:'left',sortable:true">类别</th>					
					<th data-options="field:'status',width:150,align:'center',sortable:true,formatter:formatStatus">状态</th>
					<th data-options="field:'orderList',width:200,align:'center',sortable:true">排序</th>
					<th data-options="field:'createDateStr',width:200,align:'center',sortable:true">上传时间</th>
				</tr>
			</thead>
		</table>
		<div id="dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post" action="system/websiteCategoryTAjaxSave.do">
				<div class="fitem">
					<label><font color="red">*</font>类别名称:</label>
					<input id="name" name="name" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>
					<input type="hidden" id="idLabel" name="id" />
					<input type="hidden" id="codeLabel" name="code" value="${code}"/>
				</div>
				<div class="fitem">
                      <label>排序:</label>
                      <input id="orderListLabel" name="orderList" style="width: 200px" class="easyui-numberbox" data-options="min:1"/>
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
			<div>
				类别名称: <input id="nameInput" class="easyui-textbox"
					style="width:180px"> <a href="javascript:void(0)"
					onclick="searchData()" class="easyui-linkbutton"
					iconCls="icon-search">搜索</a>
			</div>	
			<div>				
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="addBtn">添加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="editBtn">编辑</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="deleteBtn">删除</a>	
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true" id="lockOpenBtn">启用</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lockBtn">禁用</a>
			</div>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">确定</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
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
