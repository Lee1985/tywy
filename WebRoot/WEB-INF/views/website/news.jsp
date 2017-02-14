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
				<div class="newslist_box">
					<ul>
						<li>
							<a href="newsDetail.do">
							<div class="newslist_left">
								<img src="resource/website/img/newlist1.png" alt="" />
							</div>
								<div class="newslist_right">
									<h2 class="title4">天雅地毯年中销售会议召开</h2>
									<p class="newslist_time">2014年07月18日 14:54</p>
									<div class="newslist_detail">天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上，分析天雅地毯2014年度年中销售会议在河南云台山银河花园酒店隆重召开。此次会议是在总结上半年销售情况的基础上，分析</div>
								</div>
						  </a>
						</li>
						<li>
							<a href="newsDetail1.html">
							<div class="newslist_left">
								<img src="resource/website/img/newlist2.png" alt="" />
							</div>
								<div class="newslist_right">
									<h2 class="title4">我公司被推举为地毯协会副会长单位</h2>
									<p class="newslist_time">2014年07月18日 14:54</p>
									<div class="newslist_detail">近日，中国工艺美术协会地毯专业委员会2013年会在江苏无锡召开，天雅地毯凭借在地毯行业的杰出表现和有目共睹的综</div>
								</div>
							</a>
						</li>
						<li>
							<a href="newsDetail1.html">
							<div class="newslist_left">
								<img src="" alt="" />
							</div>
								<div class="newslist_right">
									<h2 class="title4">天雅地毯成功参展第十六届中国国际地面材料及铺装技术展览会</h2>
									<p class="newslist_time">2014年07月18日 14:54</p>
									<div class="newslist_detail">第十三届中国国际地面材料及铺装技术展览会在上海新国际博览中心隆重开幕。</div>
								</div>
							</a>
						</li>
						<li>
							<a href="newsDetail1.html">
							<div class="newslist_left">
								<img src="resource/website/img/newlist3.png" alt="" />
							</div>
								<div class="newslist_right">
									<h2 class="title4">天雅地毯成功参展第十六届中国国际地面材料及铺装技术展览会</h2>
									<p class="newslist_time">2014年07月18日 14:54</p>
									<div class="newslist_detail">第十三届中国国际地面材料及铺装技术展览会在上海新国际博览中心隆重开幕。</div>
								</div>
							</a>
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
