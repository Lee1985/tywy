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
	<div class="easyui-panel" title="基本信息" style="width:100%;height:300px;padding:10px;" data-options="iconCls:'icon-filter',closable:false,tools:'#two'">
		<div class="fitem">
			<div style="float: left;margin-top: 25px;">导航图片:</div>
			<div id="showImage" class="showImage" style="width:160px;height:90px;border:1px solid;margin-left:70px;cursor:pointer;text-align:center;" >
				<img id="imgShow" class="imgShow" src="downFileResult.do?urlPath=${imageConfigInfo.configValue }" style="width:100%;height:100%;"/>
			</div>
		</div>
		<div class="fitem">
			页面描述:${configInfo.configValue }
		</div>  
	</div>
   	<div id="two">
   	   <a href="javascript:void(0)" class="icon-add" onclick="javascript:doAdd()" title="添加轮播图"></a>
       <a href="javascript:void(0)" class="icon-edit" onclick="javascript:doEdit()" title="编辑"></a>
   	</div>
</body>
</html>
