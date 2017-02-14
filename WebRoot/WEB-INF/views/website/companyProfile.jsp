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
					<li class="selected"><a href="companyProfile.html">企业介绍</a></li>
					<li><a href="companyQualification.html">企业资质</a></li>
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
				<div class="company_profile">
					<h1 class="title2">企业介绍</h1>
					<div class="c_detail">
						<p> 吉林省天雅万印地毯科技有限公司专业从事于印花地毯的科技研发、生产和销售，是国内著名的地毯解决方案提供商。历经十余年的发展，天雅地毯目前已经在天津和吉林拥有两座现代化工厂和遍布全国各大中城市的22 家销售分公司，以及国内外数千家不同级别的经销商，形成了系统化、全方位的营销服务网络。目前,天雅已形成亚洲规模最大的、以印花地毯为主导，以阿克明地毯、拼块地毯、簇绒地毯及家居地毯为辅的全产业链地毯生产企业，年销量超过1200 万平米。</p>
					    <p>作为印花地毯行业的引领者，“真诚服务”的理念融进了天雅人的血液，贯彻执行到生产经营中的各个环节，从美学设计、科技研发， 到生产制造与物流配送,这种理念带给用户的直观感受，体现在更贴近用户环境的设计艺术、更安全环保的健康保障、更舒适耐磨的产品品质，以及更短的交货时间。</p>
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
</html>
