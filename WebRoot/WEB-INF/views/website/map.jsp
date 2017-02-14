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
		<div class="banner banner_bg4">
			<div class="nav_bg">
				<ul class="navigation">
					<li class="selected"><a href="map.do">销售网络</a></li>
					<li><a href="contact.do">联系我们</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main1">
				<div class="map_box">
					<div class="map_text">天雅就在您身边，我们的产品销往全国各地，其中有北京、上海、广州、西安、成都、哈尔滨、长春、
沈阳、郑州、石家庄、济南、南京、无锡、杭州、厦门等地，还远销欧美、亚太等多个国家。我们在大中城市有办事处和经销商在第一时间为您提供细致、周到的服务。请与我们联系，天雅全体员工真诚!</div>
					<div class="map_container"><img src="resource/website/img/map.png"/></div>
				</div>
				<!--网点-->
				<div class="map_sitemap">
					<ul class="sitemap_name clearfix">
						<li>总部</li>
						<li class="selected">华北地区</li>
						<li>东北地区</li>
						<li>华东地区</li>
						<li>华南地区</li>
						<li>华中地区</li>
						<li>西北地区</li>
						<li>西南地区</li>
					</ul>
					<div class="sitemap_detail">
						<ul class="clearfix">
							<li>
								<p class="company_name"> 石家庄分公司</p>
								<p class="company_list">负责人：薛英武</p>
								<p class="company_list">手机号：18903211127    18602268625</p>
								<p class="company_list">邮箱：tydttjb@126.com</p>
							</li>
							<li>
								<p class="company_name">太原分公司</p>
								<p class="company_list">负责人：王子鸣</p>
								<p class="company_list">手机号：13840181668</p>
								<p class="company_list">邮箱：tyxinbeijing@126.com</p>
							</li>
							<li>
								<p class="company_name">天津分公司</p>
								<p class="company_list">负责人：薛英武</p>
								<p class="company_list">手机号：18903211127    18602268625</p>
								<p class="company_list">地址：天津市东丽区津滨大道东方花卉院内130号</p>
								<p class="company_list">邮箱：tydttjb@126.com</p>
								<p class="company_list">传真：022-24379855</p>
							</li>
							<li>
								<p class="company_name">天津分公司</p>
								<p class="company_list">负责人：薛英武</p>
								<p class="company_list">手机号：18903211127    18602268625</p>
								<p class="company_list">地址：天津市东丽区津滨大道东方花卉院内130号</p>
								<p class="company_list">邮箱：tydttjb@126.com</p>
								<p class="company_list">传真：022-24379855</p>
							</li>
						</ul>
					</div>
				</div>
				<!--网点-->
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
			//网点分布地址点击
			$(".sitemap_name li").on("click",function(){
				$(this).addClass("selected").siblings().removeClass("selected");
				$.ajax({
					url: '',
					type: 'GET',
					dataType: 'json',
					data: {param1: 'value1'},
					success:function(){
						
					},
					error:function() {
						/* Act on the event */
					}
				});
			});
		});
	</script>
</html>
