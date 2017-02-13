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
		<!--轮播图-->
		<div class="js-box">
			 <div class="slider">
			      <div class="slide"><img src="resource/website/img/banner.png"></div>
			      <div class="slide"><img src="resource/website/img/banner1.png"></div>
			      <div class="slide"><img src="resource/website/img/img01.png"></div>
			      <div class="slide"><img src="resource/website/img/banner1.png"></div>
            </div>
		</div>
		<!--轮播图-->
		<!--公司简介-->
		<div class="company_box">
			<h2 class="title">公司简介<span>Company profile</span></h2>
			<div class="company_detail">吉林省天雅万印地毯科技有限公司专业从事于印花地毯的科技研发、生产和销售，是国内著名的地毯解决方案提供商。历经十余年的发展，天雅地毯目前已经在天津和吉林拥有两座现代化工厂和遍布全国各大中城市的22 家销售分公司，以及国内外数千家不同级别的经销商，形成了系统化、全方位的营销服务网络。</div>
			<a href="companyProfile.html" class="more">MORE</a>
		</div>
		<!--公司简介-->
		<!--品牌推广-->
		<div class="brand_box box">
			<div class="brand_left"></div>
			<div class="brand_right">
				<h2 class="title0 brand_title">品牌推广<span>BRANDING</span></h2>
				<div class="brand_detail box_detail">品牌传递着情感，而情感是品牌的催化剂。<br />
为提升天雅地毯的品牌影响力，公司与央视建立战略合作伙伴关系，长期在综合频道、新闻频道进行品牌宣传推广！</div>
			</div>
		</div>
		<!--品牌推广-->
		<!--印花地毯-->
		<div class="printed_box box">
			<div class="printed_left"></div>
			<div class="printed_right">
				<h2 class="title0 printed_title">印花地毯<span>PRINTED CARPET</span></h2>
				<div class="printed_detail box_detail">品牌传递着情感，而情感是品牌的催化剂。<br />
为提升天雅地毯的品牌影响力，公司与央视建立战略合作伙伴关系，长期在综合频道、新闻频道进行品牌宣传推广！</div>
			</div>
		</div>
		<!--印花地毯-->
		<!--3D地毯-->
		<div class="carpet_box box">
			<div class="brand_left carpet_left"></div>
			<div class="brand_right">
				<h2 class="title0 carpet_title">3D地毯<span>3D CARPET</span></h2>
				<div class="carpet_detail box_detail">品牌传递着情感，而情感是品牌的催化剂。<br />
为提升天雅地毯的品牌影响力，公司与央视建立战略合作伙伴关系，长期在综合频道、新闻频道进行品牌宣传推广！</div>
			</div>
		</div>
		<!--3D地毯-->
		<!--经典案例-->
		<div class="company_box">
			<h2 class="title">经典案例<span>Project profile</span></h2>
			<div class="company_detail">吉林省天雅万印地毯科技有限公司专业从事于印花地毯的科技研发、生产和销售，是国内著名的地毯解决方案提供商。历经十余年的发展，天雅地毯目前已经在天津和吉林拥有两座现代化工厂和遍布全国各大中城市的22 家销售分公司，以及国内外数千家不同级别的经销商，形成了系统化、全方位的营销服务网络。</div>
			<a href="classicCase.html" class="more">MORE</a>
		</div>
		<!--经典案例-->
		<!--案例展示-->
		<!--案例展示-->
		<div class="case_box">
			<div class="bigpic"><img src="" alt="" /></div>
			<div class="mask">
				<div class="case_title"><img src=""/></div>
				<a href="" class="more1">MORE</a>
			</div>
			<ul class="smallpic">
				<li class="selected">
					<img src=""/>
					<span></span>
				</li>
				<li>
					<img src=""/>
					<span></span>
				</li>
				<li>
					<img src=""/>
					<span></span>
				</li>
			</ul>
		</div>
		<!--新闻动态-->
		<div class="company_box">
			<h2 class="title">新闻动态<span>News information</span></h2>
			<div class="clearfix">
			<div class="news_detail news_left">
				<p class="news_time">2014-07-18</p>
				<h2 class="title1">天雅地毯年中销售会议召开</h2>
				<div class="news_text">2014年7月12-13日，天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上2014年7月12-13日，天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上</div>
			</div>
			<div class="news_detail news_right">
				<p class="news_time">2014-07-18</p>
				<h2 class="title1">天雅地毯年中销售会议召开</h2>
				<div class="news_text">2014年7月12-13日，天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上2014年7月12-13日，天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上</div>
			</div>
			</div>
			<a href="news1.html" class="more">MORE</a>
		</div>
		<!--新闻动态-->
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
	<!--<script src="js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>-->
	<!--<script src="js/common.js" type="text/javascript" charset="utf-8"></script>-->
	<script src="resource/website/js/jquery.bxslider.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			//轮播图
			 $('.slider').bxSlider({
						auto: true,
			            slideWidth: 1920, 
			            slideMargin: 0,
			            minSlides: 1,
			            maxSlides: 1,
			            slideMargin: 2,
			            captions: true,
			            
			          });
			//案例展示
			var w=$(window).width();
			$(".case_box").height(w/2.2);
			$(".box").height(w*0.67/1.8);
			$(".js-box").height(w/1.96);
			var arr=[["resource/website/img/tabimg1.png","resource/website/img/tabSmall1.png","客房展示","resource/website/img/tabtitle.png"],["resource/website/img/tabimg2.png","resource/website/img/tabSmall2.png","宴会展示","resource/website/img/tabtitle2.png"],["resource/website/img/tabimg3.png","resource/website/img/tabSmall3.png","客房展示","resource/website/img/tabtitle.png"]];
			var arr1=["news1.html","news.html","news0.html"];
			$(".bigpic img").attr("src",arr[0][0]);
			$(".case_title img").attr("src",arr[0][3]);
			$(".smallpic li").eq(0).find("img").attr("src",arr[0][1]);
			$(".smallpic li").eq(0).find("span").text(arr[0][2]);
			$(".smallpic li").eq(1).find("img").attr("src",arr[1][1]);
			$(".smallpic li").eq(1).find("span").text(arr[1][2]);
			$(".smallpic li").eq(2).find("img").attr("src",arr[2][1]);
			$(".smallpic li").eq(2).find("span").text(arr[2][2]);
			$(".more1").attr("href",arr1[0]);
			$(".smallpic li").on("click",function(){
				var indexs=$(this).index();
				$(this).addClass("selected").siblings().removeClass("selected");
				$(".bigpic img").attr("src",arr[indexs][0]);
				$(".case_title img").attr("src",arr[indexs][3]);
				$(".more1").attr("href",arr1[indexs]);
			});
		});
	</script>
</html>
