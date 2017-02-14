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
		<div class="banner banner_bg3">
			<div class="nav_bg">
				<ul class="navigation">
					<li class="selected"><a href="news1.html">行业新闻</a></li>
					<li><a href="news1.html">企业新闻</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="newsdetail_box">
					<h1 class="title3">
						天雅地毯年中销售会议召开
						<span class="news_time">2014年07月18日 14:54</span>
					</h1>
					<div class="news_details">
						<p class="news_pic"><img src="resource/website/img/newsdetail.png"/></p>
						<p>2014年7月12-13日，天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上，分析目前公司及各分公司存在的问题并制订解决办法而适时召开的重要会议。来自公司总部的总裁王晓波、总经理孙义锋、副总经理蔡力及各分公司经理、副经理和工厂中层以上领导干部共同出席了此次会议。</p>
						<p>会上公司的管理层、各分公司负责人就公司生产、销售、设计等各方面存在的问题进行广泛深入的交流和探讨，平时难得一聚的各区域销售经理纷纷畅所欲言、集思广益，并就各自的销售经验、营销举措、销售政策等提出了很多宝贵的建议。</p>
						<p>会议主要是从实际问题出发，不追究责任的去挖掘生产与销售方面的不足之处，遇到问题及时沟通解决，从问题根本出发彻底解决，杜绝只停留于处理表面；强化市场概念，以市场为导向，实时掌握市场与客户需求，积极寻找方法满足市场的不同需求，提高完善思想意识，诚信为首，传播正能量。公司提倡爱岗敬业，维护和谐的工作关系，多鼓励少批评，多奖励少罚款，多沟通协调，解决根本问题，不能以罚代管。对于重大问题要集体决定，严格按照规章制度办事，不断完善不足之处，做到无愧于地毯引领者的称号，力求大家共同努力把天雅带入更高、更好的发展道路。</p>
						<p>会后，与会人员共同游览了素有小寨沟美誉的云台山，在大自然中尽情放松身心，无负担沟通交流，进一步加强了生产销售之间的沟通，同时，也为迎接下半年销售旺季奠定了良好的基础。</p>
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
			$(window).on("load",function(){
				//判断是否有图片
				$(".newslist_left img").each(function(){
				var img=$(this).attr("src");
				if (img=="") {
					$(this).parent(".newslist_left").hide();
					$(this).parent(".newslist_left").next(".newslist_right").css("width","100%");
				}
				});
			});
		});
	</script>
</html>
