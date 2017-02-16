<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>微信专区照片管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>

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

	$(function(){
		$('#deleteBtn').click(function(){
			doDelete('system/wechatAlbumListTAjaxDelete.do');
		});
	});
	
	function formatImg(value, row) {
		var url = 'downFileResult.do?urlPath=' + row.systemPictureInfo.urlPath;
		return "<img src="+ url +" style=\"height:100px;width:100px;\"/>";
	}
	
	function doBack(value,row){
		location.href = "system/wechatElectronicAlbumTList.do";
	}
	
	function doEdit() {
		location.href = "system/wechatAlbumListCollection.do?albumId=${albumId}";
	}
	
	function searchData() {
		$('#dg').datagrid('load', {
			serialNumber : jQuery.trim($('#_serialNumber').val())
		});
	}
</script>
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'system/wechatAlbumListTAjaxPage.do?parentid=${albumId}', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar'">
			<thead>
				<tr>
					<th width="10%" data-options="field:'urlPath',align:'center',sortable:true,formatter:formatImg">照片</th>
					<th width="10%" data-options="field:'serialNumber',align:'center',sortable:true">照片编号</th>
					<th width="20%" data-options="field:'description',align:'center',sortable:true">照片描述</th>
					<th width="15%" data-options="field:'updateDateStr',align:'center',sortable:true">更新时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<div>
				照片编号: <input id="_serialNumber" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp;				 
				 <a href="javascript:void(0)" onclick="searchData()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			</div>
			<div style="margin-bottom:5px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true" onclick="doBack()">返回</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doEdit()">编辑相册</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" id="deleteBtn" data-options="iconCls:'icon-remove',plain:true">删除</a>
			</div>
		</div>
	</div>
</body>
</html>
