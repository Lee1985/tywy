<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>网站留言管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>

<script type="text/javascript">
	function searchData() {
		$('#dg').datagrid('load', {
			name : Trim($('#name').val()),
			mobile : Trim($('#mobile').val())
		});
	}
	function Trim(str){ 
		return str.replace(/(^\s*)|(\s*$)/g, ""); 
	}
</script>
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'websiteMessageTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar'">
			<thead>
				<tr>
					<th data-options="field:'name',width:150,align:'center',sortable:true">姓名</th>
					<th data-options="field:'mobile',width:60,align:'center',sortable:true">联系方式</th>
					<th data-options="field:'content',width:200,align:'center',sortable:true">留言内容</th>
					<th data-options="field:'createDate',width:125,align:'center',sortable:true">留言时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<div>
				姓名: <input id="name" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp; 
				联系方式: <input id="mobile" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp; 
				 <a href="javaScript:void()" onclick="searchData()" class="easyui-linkbutton" plain="true"
				 	data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>
