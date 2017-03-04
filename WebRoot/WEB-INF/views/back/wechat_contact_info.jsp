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

<title>联系我们管理</title>

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
		  window.location.href = baseUrl + "system/wechatContactEdit.do";
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
	height: 30px;
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
	<div class="easyui-panel" title="联系我们" 
		style="width:100%;height:300px;padding:10px;" 
		data-options="iconCls:'icon-filter',closable:false,tools:'#two'">
		<div class="fitem">
			<label>公司名称:</label>${companyValue }
		</div>
		<div class="fitem">
			<label>公司地址:</label>${addressValue }
		</div>
		<div class="fitem">
			<label>公司网址:</label>${websiteValue }
		</div>
		<div class="fitem">
			<label>描述:</label>${contentValue }
		</div>  
	</div>
   	<div id="two">
       <a href="javascript:void(0)" class="icon-edit" 
       		onclick="javascript:doEdit()" title="编辑"></a>
   	</div>
</body>
</html>
