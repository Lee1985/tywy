<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta id="viewport" name="viewport" content="width=1200">
		<!--reset css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/common.css"/>
		<!--reset css-->
		<!--轮播图 css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/jquery.bxslider.css"/>
		<!--轮播图 css-->
		<!--function css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/style.css"/>
		<!--function css-->
		<script src="resource/website/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/website/js/jquery.fs.boxer.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/website/js/lightbox.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/website/js/owl.carousel.js" type="text/javascript" charset="utf-8"></script>
		<title>天雅地毯</title>
	</head>
	<body>
		<!--header start-->
		<header>
		    <!-- <script type="text/javascript">
			 $("header").load("header.do");
		    </script> -->
		    <jsp:include page="header.jsp" flush="true"/>
		</header>
		<!--header end-->
		<div class="banner banner_bg2">
			<div class="nav_bg">
				<ul class="navigation">
					<li><a href="map.do">销售网络</a></li>
					<li class="selected"><a href="contact.do">联系我们</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="contact_box">
					<h2 class="title">联系我们<span>Contact us</span></h2>
					<div class="contact_text">天雅地毯用优质的服务作为连接广大客户朋友供求之间的全新情感纽带，树立天雅地毯的品牌形象。企业的进步离不开倾听客户的宝贵意见，在使用我们产品过程中如有任何意见或建议，欢迎来电、来函或E-mail给我公司，我们将不胜感激，我们会不断改进和完善。请随时保持与我们的联系，我们竭诚为您服务！</div>
				    <ul class="contact_method clearfix">
				    	<li>
				    		<img src="resource/website/img/icon_00.png" alt="" />
				    		<p class="c_name">在线客服</p>
				    		<p class="c_time">每天8:30-17:00</p>
				    	</li>
				    	<li>
				    		<img src="resource/website/img/icon_10.png" alt="" />
				    		<p class="c_name">电话:0437-6227733</p>
				    		<p class="c_time">每天8:30-17:00</p>
				    	</li>
				    	<li class="contact">
				    		<img src="resource/website/img/icon_20.png" alt="" />
				    		<p class="c_name">在线留言</p>
				    		<p class="c_time">写下您的问题</p>
				    	</li>
				    </ul>
				</div>
			</div>
		</main>
		<!--main-->
		<!--footer-->
		<footer>
		    <jsp:include page="footer.jsp" flush="true"/>
		</footer>
		<!--footer-->
		<!--悬浮层-->
		<slide>
		    <jsp:include page="floated.jsp" flush="true"/>
		</slide>
		<!--悬浮层-->
		<!--弹出层-->
		<div class="mask1">
			<div class="poup_box1">
				<h1 class="title">留言</h1>
				<form class="select_box">
					<!--联系方式-->
					<div class="form_box">
						<div class="form_title">联系姓名</div>
						<div class="form_detail">
							<input type="text" id="name" placeholder="姓名" />
						</div>
					</div>
					<!--联系方式-->
					<!--联系地址-->
					<div class="form_box">
						<div class="form_title">联系方式</div>
						<div class="form_detail">
							<input type="text" id="tel" placeholder="手机号" />
						</div>
					</div>
					<!--联系地址-->
					<!--留言框-->
					<div class="form_box">
						<div class="form_title">留言內容</div>
						<div class="form_detail">
							<textarea name="" rows="" cols=""></textarea>
						</div>
					</div>
					<!--留言框-->
					<div class="submit">提交</div>
				</form>
			</div>
		</div>
		<!--弹出层-->
	</body>
	<script type="text/javascript">
		$(function(){
			//鼠标经过联系方式box
			$(".contact_method li").hover(function(){
				var indexs=$(this).index();
				$(this).find("img").attr("src","resource/website/img/icon_"+indexs+"1.png");
				$(this).find(".c_name").addClass("hover");
				$(this).find(".c_time").addClass("hover");
			},function(){
				var indexs=$(this).index();
				$(this).find("img").attr("src","resource/website/img/icon_"+indexs+"0.png");
				$(this).find(".c_name").removeClass("hover");
				$(this).find(".c_time").removeClass("hover");
			});
			//彈出層
			var h=$(window).height();
			$(window).on("load resize",function(){
				$(".mask1").height(h);
			});
			$(".contact").on("click",function(){
				$(".mask1").show();
				$("html,body").css("overflow","hidden");
			});
			$(".submit").on("click",function(){
				$(".mask1").hide();
				$("html,body").css("overflow","auto");
			});
			//彈出層
		});
	</script>
</html>
