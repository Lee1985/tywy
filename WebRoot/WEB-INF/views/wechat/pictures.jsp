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
		<link rel="stylesheet" type="text/css" href="css/wechat/jquery.bxslider.css"/>
		<title>电子图册</title>
	</head>
	<body class="gray_bg">
		<!--main-->
		<main>
			<div class="banner">
				<!--焦点图-->
				<div class="js-box">
					<div class="slider">
						<div class="slide"><img src="images/wechat/js0.png"></div>
						<div class="slide"><img src="images/wechat/js1.png"></div>
						<div class="slide"><img src="images/wechat/js0.png"></div>
				    </div>
				    <div class="js_word">
				    	<p class="chinese">天雅地毯  印花地毯引领者</p>
				    	<p class="english">TIANYA CARPETS  CARPET PRINGTING LEADER</p>
				    </div>
				    <a class="sc_btn" href="javaScript:void(0)" onclick="toCollection()"></a>
				</div>
				<!--焦点图-->
			</div>
			<div class="picture_box">
				<a href="javaScript:void(0)" onclick="toZone()">
					<img src="images/wechat/icon_kf.png" alt="客房区域" />
					<p>客房区域</p>
				</a>
				<a href="javaScript:void(0)" onclick="toZone()">
					<img src="images/wechat/icon_zl.png" alt="走廊区域" />
					<p>走廊区域</p>
				</a>
				<a href="javaScript:void(0)" onclick="toZone()">
					<img src="images/wechat/icon_yh.png" alt="宴会区域" />
					<p>宴会区域</p>
				</a>
				<a href="javaScript:void(0)" onclick="toZone()">
					<img src="images/wechat/icon_cb.png" alt="餐包区域" />
					<p>餐包区域</p>
				</a>
				<a href="javaScript:void(0)" onclick="toZone()">
					<img src="images/wechat/icon_yl.png" alt="娱乐区域" />
					<p>娱乐区域</p>
				</a>
				<a href="javaScript:void(0)" onclick="toZone()">
					<img src="images/wechat/icon_bg.png" alt="办公区域" />
					<p>办公区域</p>
				</a>
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
	<script src="js/wechat/jquery.bxslider.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			$("#footer a").click(function() {
				$(this).addClass("gray").siblings().removeClass("gray");
			})
			// 焦点图
			$('.slider').bxSlider({
				auto: true,
				pager: true,
				slideWidth: 1500,
				slideMargin: 0,
				minSlides: 1,
				maxSlides: 1,
				pause: 3000,
			});
		    $(window).on("load resize",function(){
		    	var hei=$(".picture_box").height();
		    	var hei1=$(".banner").height();
		    	var hei2=$(".footer").height();
		    	$("main").height(hei+hei1+hei2-10);
		    });
		});
	</script>
	<script type="text/javascript">
		function toZone() {
			window.location.href="./toDiffArea.do";
		}
		function toWechatContact() {
			window.location.href="./toWechatContact.do";
		}
		function toWechatWebsite() {
			window.location.href="./toWechatWebsite.do";
		}
		function toWelcomeIndex() {
			window.location.href="./welcomeIndex.do";
		}
		function toCollection() {
			window.location.href="./toCollection.do";
		}
	</script>	
</html>
