<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="resource/website/js/common.js" type="text/javascript" charset="utf-8"></script>
<div id="header" class="clearfix">
	<h1 class="logo"><img src="resource/website/img/logo.png"/></h1>
	<ul class="nav clearfix">
		<li><a href="index.do">首页</a></li>
		<li href="" class="select_menu">
			<a href="">关于</a>
			<div class="second_menu">
				<a href="companyProfile.do"><span>企业简介</span></a>
				<a href="companyQualification.do"><span>企业资质</span></a>
				<a href="#"><span>企业荣誉</span></a>
			</div>
		</li>
		<li><a href="news.do">新闻</a></li>
		<li><a href="brand.do">品牌</a></li>
		<li><a href="designList.do">天雅设计</a></li>
		<li><a href="classicCase.do">经典案例</a></li>
		<li><a href="map.do">天雅销售</a></li>
	</ul>
	<div class="search_box"><input type="search" placeholder="站内搜索" /><span></span></div>
</div>
