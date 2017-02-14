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
		<div class="banner banner_bg6">
			<div class="nav_bg">
				<ul class="navigation">
					<li class="selected"><a href="brand.html">宣传推广</a></li>
					<li><a href="yinhuaCarpet.html">印花地毯</a></li>
					<li><a href="">3D地毯</a></li>
					<li><a href="">家居地毯</a></li>
					<li><a href="">阿克明地毯</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="carpets_box">
					<div class="carpets_text">
						<p>东省以392.1亿元名列第一，与之形成极大反差的是赴港澳地区旅游团不足3成，大量酒店半价销售，大部分零售商店关门歇业。连平时的旅游黄金地北上广的旅游消费增幅也不足1%。近年来度假休闲式旅游增长已经超过消费式旅游。一线城市的关注度同比有所下降，居民旅游目的地选择越来越多元化，更多的二三线城市和地区成为大家度假休闲、特别是城市居民远离压力和都市喧嚣的新选择。随着居民可支配收入的逐步增长以及人们消费观念的变化，二、三线城市旅游业的关注度正在明显提升。而健康减压之旅成为大多数旅游者的选择，70、80后将成未来十年旅游市场的消费主体，旅游业将持续稳定发展。新的“旅游综合体”应运而生。</p>
						<p> “旅游综合体”是由“休闲综合体”和“度假综合体”构成的，它们均是依托于一定的旅游资源与土地基础，以旅游休闲为导向，进行土地综合开发而形成的一种将功能聚合、土地集约整合在一起的“聚集体”，其中最典型的代表就是深圳华侨城和西安曲江。从旅游发展的角度来看，“旅游综合体”必将会产生三大作用;一是推动区域旅游从“观光时代走向休闲时代”，二是推动区域旅游从“景区时代走向旅游目的地时代”，第三就是推动旅游开发从“单一产品时代走向综合体时代”。 从地产开发的角度来说，“旅游综合体”为大地产开发特别是旅游休闲地产的开发是提供了一种新的模式;按照“旅游综合体”的特色模式进行旅游休闲导向的土地综合开发，实现地产开发与综合旅游休闲发展的完美融合，将
面对如此巨大商机，我们应大胆进取，努力开拓出适合华德发展的必由之路。</p>
					</div>
				</div>
				<div class="carpets_pic">
					<h2 class="title">天雅品牌推广<span>Brand promotion </span></h2>
					<div class="qualification_box">
		        	<div class="controls-pre controls"></div>
		        	<div class="carousel-box">
		        	<div class="carousel carpets_img" id="q_carousel">
	                        <!--四个一组-->
	                        <ul class="owl-item">
	                            <li>
	                                <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox11.png"><img src="resource/website/img/pic1.png"/></a>
	                            </li>
	                            <li>
	                                 <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox1.png"><img src="resource/website/img/pic2.png"/></a>
	                            </li>
	                            <li>
	                                 <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox11.png"><img src="resource/website/img/pic3.png"/></a>
	                            </li>
	                            <li>
	                                <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox1.png"><img src="resource/website/img/pic4.png"/></a>
	                           </li>
	                        </ul>
	                        <!--四个一组-->
	                        <ul class="owl-item">
	                            <li>
	                                <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox11.png"><img src="resource/website/img/pic1.png"/></a>
	                            </li>
	                            <li>
	                                 <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox1.png"><img src="resource/website/img/pic2.png"/></a>
	                            </li>
	                            <li>
	                                 <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox11.png"><img src="resource/website/img/pic3.png"/></a>
	                            </li>
	                            <li>
	                                <a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="img/lightbox1.png"><img src="resource/website/img/pic4.png"/></a>
	                           </li>
	                        </ul>
	                    </div>
		        	</div>
		            <div class="controls-next controls"></div>
		            <div class="clearfix"></div>
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
	<script src="resource/website/js/owl.carousel.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/website/js/jquery.fs.boxer.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/website/js/lightbox.js" type="text/javascript" charset="utf-8"></script>
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
