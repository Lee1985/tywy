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

<title>默认信息编辑</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
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
	width: 60px;
}

.fitem input {
	width: 200px;
}
</style>
<script type="text/javascript">
	function doEdit() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '修改');
			$('#fm').form('load', row);
		}
	}
	function formatType(value, row) {    
	    if (value == 1) {
			return "首次关注";
		} else if (value == 2) {
			return "联系我们";
		} else {
			return "搜索图片";
		}
	}
	function save() {
		var index;
		$('#fm').form('submit', {
			onSubmit : function() {
				var rr = $(this).form('enableValidation').form('validate');
				if (rr) {
					index = layer.load('操作中...请等待！', 0);
				} else {
					return false;
				}
			},
			dataType : 'json',
			success : function(result) {
				var result = eval('(' + result + ')');
				layer.close(index);
				if (result.success) {
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
				} else {
					$.messager.show({
						title : '提示',
						msg : result.msg
					});
				}
			}
		});
	}
</script>
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'wechatPubReplyTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar'">
			<thead>
				<tr>
					<th data-options="field:'content',width:200,align:'center',sortable:true">内容</th>
					<th data-options="field:'type',width:150,align:'center',sortable:true,formatter:formatType">位置</th>
					<th data-options="field:'createDate',width:125,align:'center',sortable:true">创建时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<div>
				<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="iconCls:'icon-edit',plain:true" onclick="doEdit()">修改</a>
			</div>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;height:320px;padding:10px 20px;top:50px" closed="true" 
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post"
				action="wechatPubReplyTAjaxSave.do" data-options="novalidate:true" 
				enctype="multipart/form-data">
				<input type="hidden" id="id" name="id">
				<div class="fitem">
					<label>位置 :</label> <select class="easyui-combobox" id="type"
						name="type" style="width:100px;"
						data-options="panelHeight:'auto',disabled:true,editable:false">
						<option value="1">首次关注</option>
						<option value="2">联系我们</option>
						<option value="3">搜索图片</option>
					</select>
				</div>
				<div class="fitem">
					<label>内容 :</label> <input id="content" name="content"
						class="easyui-textbox" style="height:100px;width: 200"
						data-options="prompt:'内容',multiline:true,required:false,validType:'length[0,2000]'">
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				data-options="iconCls:'icon-ok'" onclick="save()" style="width:90px">确定</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		</div>
</body>
</html>
