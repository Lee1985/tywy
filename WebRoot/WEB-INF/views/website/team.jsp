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
	<!--banner-->
		<div class="banner banner_bg7">
			<div class="nav_bg">
				<ul class="navigation">
					<li><a href="designList.html">设计图册</a></li>
					<li class="selected"><a href="team.html">设计团队</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="team_box">
					<p>天雅知道，色彩，设计决定了整个外观和空间的感觉。为了确保我们的设计看起来更精湛，天雅使用的打印其技术是世界上最先进的数码印花技术。这完美的数码印刷技术能够将精心设计的图案和细节完美的呈现。</p>
					<p>公司设有设计研发中心，具有最大、最专业的设计团队，并与意大利顶级设计公司长期深度合作，拥有多项图案设计专利，不断推出国际最新趋势的印花地毯设计。</p>
				</div>
				<div class="person_box">
					<h2 class="title team_title">TEAM<span>MEM BERS</span></h2>
					<div class="big_box"><img src="resource/website/img/biglimg0.png" alt="" /></div>
					<ul>
						<li class="smallimg1 selected"><img src="resource/website/img/smallimg0.png" alt="" /></li>
						<li class="smallimg2"><img src="resource/website/img/smallimg1.png" alt="" /></li>
						<li class="smallimg3"><img src="resource/website/img/smallimg2.png" alt="" /></li>
						<li class="smallimg4"><img src="resource/website/img/smallimg3.png" alt="" /></li>
						<li class="smallimg5"><img src="resource/website/img/smallimg4.png" alt="" /></li>
						<li class="smallimg6"><img src="resource/website/img/smallimg5.png" alt="" /></li>
						<li class="smallimg7"><img src="resource/website/img/smallimg6.png" alt="" /></li>
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
	</body>
	<script type="text/javascript">
		$(function(){
			$(".person_box ul li").on("click",function(){
				var indexs=$(this).index();
				$(this).addClass("selected").siblings().removeClass("selected");
				$(".big_box img").attr("src","resource/website/img/biglimg"+indexs+".png");
			});
	});
	</script>
</html>
