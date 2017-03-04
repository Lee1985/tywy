<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html class="fullscreen">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="format-detection" content="email=no" />
		<link rel="stylesheet" type="text/css" href="css/wechat/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/style.css"/>
		<title>欢迎页面</title>
	</head>
	<body class="fullscreen">
		<div class="welcome_box"><img src="images/wechat/welcome.png" alt="" /></div>
		<a href="javaScript:void(0)" onclick="toIndex()" class="btn">欢迎使用电子图册</a>
	</body>
	<script src="js/wechat/rem.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function toIndex() {
			var userid="${userid}";
			if (userid!=null&&userid!="") {
			} else {
				userid="o_rsSv19Shjb9U71kWm8QmWdfh_E";
			}
			window.location.href="./welcomeIndex.do?userid=" + userid;
		}
	</script>	
</html>
