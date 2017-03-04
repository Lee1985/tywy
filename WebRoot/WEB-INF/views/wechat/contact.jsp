<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="format-detection" content="email=no" />
		<link rel="stylesheet" type="text/css" href="css/wechat/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/style.css"/>
		<title>联系我们</title>
	</head>
	<body class="gray_bg">
		<!--main-->
		<main class="contact_bg">
			<!--<div class="banner"><img src="images/wechat/contact_banner.png" alt="" /></div>-->
			<div class="contact_box">
				<div class="address_box">
					<h2>${companyValue }</h2>
					<ul>
						<li>地址：${addressValue }</li>
						<li>网址：<a href="${websiteValue }" target="_blank"></a>${websiteValue }</li>
					</ul>
				</div>
				<div class="address_box">
					<h2></h2>
					<ul>
						<li>${contentValue }</li>
					</ul>
				</div>
				<div class="online_box">
					<div class="icon_box"><img src="images/wechat/icon_client.png" alt="" /></div>
					<div class="online_text">在线客服</div>
				</div>
			</div>
		</main>
		<!--main-->
		<!--footer-->
		<footer>
			<div class="footer">
				<a href="javaScript:void(0)" onclick="toWechatWebsite()"><span class="gray"></span>官网</a>
				<a href="javaScript:void(0)" onclick="toWelcomeIndex()"><span class="gray"></span>电子图册</a>
				<a href="javaScript:void(0)" onclick="toWechatContact()"><span class="gray"></span>联系我们</a>
			</div>
		</footer>
		<!--footer-->
	</body>
	<script src="js/wechat/rem.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {
			$("#footer a").click(function() {
				$(this).addClass("gray").siblings().removeClass("gray");
			})
		});
		
		function toWechatContact() {
			window.location.href="./toWechatContact.do";
		}
		function toWechatWebsite() {
			window.location.href="./toWechatWebsite.do";
		}
		function toWelcomeIndex() {
			window.location.href="./welcomeIndex.do";
		}
	</script>
</html>
