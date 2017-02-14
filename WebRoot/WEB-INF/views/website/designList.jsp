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
					<li class="selected"><a href="designList.do">设计图册</a></li>
					<li><a href="team.do">设计团队</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="carpets_box">
					<div class="design_box">
						<div class="gray_bg"></div>
						<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer design_left" href="resource/website/img/lightbox1.png"><img src="resource/website/img/design1.png"/></a>
						<div class="design_title">设计图册</div>
						<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer design_right" href="resource/website/lightbox11.png"><img src="resource/website/img/design2.png"/></a>
					</div>
					<div class="carpets_text">
						<p>天雅知道，色彩，设计决定了整个外观和空间的感觉。为了确保我们的设计看起来更精湛，天雅使用的打印其技术是世界上最先进的数码印花技术。这完美的数码印刷技术能够将精心设计的图案和细节完美的呈现。</p>
						<p> 公司设有设计研发中心，具有最大、最专业的设计团队，并与意大利顶级设计公司长期深度合作，拥有多项图案设计专利，不断推出国际最新趋势的印花地毯设计。</p>
					</div>
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
		var  q_owl = $("#q_carousel");
            q_owl.owlCarousel({
	   	    items: 1,
	        navigation: false,    
	        autoPlay: false,
	        stopOnHover: true,
	        pagination : false,
	        slideSpeed:500,
	        rewindNav:false
    });
 
   	//上一张切换
    $(".qualification_box .controls-pre").click(function(e){ 
    		q_owl.trigger('owl.prev');

    });

    //下一张切换
    $(".qualification_box .controls-next").click(function(e){ 
    		q_owl.trigger('owl.next');

    });
	});
	</script>
</html>
