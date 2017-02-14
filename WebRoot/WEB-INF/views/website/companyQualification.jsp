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
		<div class="banner banner_bg1">
			<div class="nav_bg">
				<ul class="navigation">
					<li><a href="companyProfile.html">企业介绍</a></li>
					<li class="selected"><a href="companyQualification.html">企业资质</a></li>
					<li><a href="javascript:;">企业文化</a></li>
					<li><a href="javascript:;">企业工艺</a></li>
					<li><a href="javascript:;">企业品质</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="qualification_box">
		        	<div class="controls-pre controls"></div>
		        	<div class="carousel-box">
		        		<div class="carousel" id="q_carousel">
		                   	<a href="javascript:;" class="currenthx">
		                   		<div class="j_box">
		                   				<div>
		                   					<img src="resource/website/img/zz1.png" alt="" />
		                   					<p>饭店协会会员单位</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz3.png" alt="" />
		                   					<p>AAA级信用企业</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz3.png" alt="" />
		                   					<p>吉林省著名商标</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz4.png" alt="" />
		                   					<p>新西兰羊毛认证标志</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz5.png" alt="" />
		                   					<p>全国质量检测稳定合格产品</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz6.png" alt="" />
		                   					<p>全国质量检测稳定合格产品</p>
		                   				</div>
		                   		</div>
		                   	</a>
		                    <a href="javascript:;">
		                    	<div class="j_box">
		                   				<div>
		                   					<img src="resource/website/img/zz1.png" alt="" />
		                   					<p>饭店协会会员单位</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz3.png" alt="" />
		                   					<p>AAA级信用企业</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz3.png" alt="" />
		                   					<p>吉林省著名商标</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz4.png" alt="" />
		                   					<p>新西兰羊毛认证标志</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz5.png" alt="" />
		                   					<p>全国质量检测稳定合格产品</p>
		                   				</div>
		                   				<div>
		                   					<img src="resource/website/img/zz6.png" alt="" />
		                   					<p>全国质量检测稳定合格产品</p>
		                   				</div>
		                   		</div>
		                    </a>
		           		</div>
		        	</div>
		            <div class="controls-next controls"></div>
		            <div class="clearfix"></div>
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
	<script src="js/owl.carousel.js" type="text/javascript" charset="utf-8"></script>
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
		 
		   	//资质上一张切换
		    $(".qualification_box .controls-pre").click(function(e){ 
		    		q_owl.trigger('owl.prev');
		    });
		
		    //资质下一张切换
		    $(".qualification_box .controls-next").click(function(e){ 
		    		q_owl.trigger('owl.next');
		
		    });
		});
	</script>
</html>
