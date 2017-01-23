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
		<!--header-->
		<!--<header>
			<h1 class="title"><a href="javascript:history.go(-1);" class="back">返回</a>联系我们<a href="javasript:;" class="more"></a></h1>
		</header>-->
		<!--header-->
		<!--main-->
		<main class="contact_bg">
			<!--<div class="banner"><img src="images/wechat/contact_banner.png" alt="" /></div>-->
			<div class="contact_box">
				<div class="address_box">
					<h2>吉林省天雅万印毯业科技有限公司</h2>
					<ul>
						<li>地址：中国吉林省东丰县药业大街98号</li>
						<li>销售服务热线：<a href="tel:0437-6227733">0437-6227733</a></li>
						<li>邮箱：<a href="mailto:tianyanq2@126.com">tianyanq2@126.com</a></li>
						<li>网址：<a href="http://www.tycarpet.com" target="_blank"></a>http://www.tycarpet.com</li>
					</ul>
				</div>
				<div class="address_box">
					<h2>天津天雅万印毯业科技有限公司</h2>
					<ul>
						<li>地址：中国天津东丽区荒草坨北地毯仓库</li>
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
