<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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

<title>天雅设计管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
</script>
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>


<script type="text/javascript">
	function doEdit() {
		  window.location.href = baseUrl + "system/websiteDesignEdit.do";
	}
	
	function doAdd() {
		  window.location.href = baseUrl + "system/websiteDesignAblum.do";
	}
	
</script>
</head>

<body>
	<div class="easyui-panel" title="内容介绍" style="width:100%;height:300px;padding:10px;" data-options="iconCls:'icon-filter',closable:false,tools:'#two'">
		${configInfo.configValue }
	</div>
   	<div id="two">
   	   <a href="javascript:void(0)" class="icon-add" onclick="javascript:doAdd()" title="添加轮播图"></a>
       <a href="javascript:void(0)" class="icon-edit" onclick="javascript:doEdit()" title="编辑"></a>
   	</div>
</body>
</html>
