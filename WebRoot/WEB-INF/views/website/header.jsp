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
		<li><a href="index.html">首页</a></li>
		<li href="" class="select_menu">
			<a href="">关于</a>
			<div class="second_menu">
				<a href="companyProfile.html"><span>企业简介</span></a>
				<a href="companyQualification.html"><span>企业资质</span></a>
				<a href="#"><span>企业荣誉</span></a>
			</div>
		</li>
		<li><a href="news1.html">新闻</a></li>
		<li><a href="brand.html">品牌</a></li>
		<li><a href="designList.html">天雅设计</a></li>
		<li><a href="classicCase.html">经典案例</a></li>
		<li><a href="map.html">天雅销售</a></li>
	</ul>
	<div class="search_box"><input type="search" placeholder="站内搜索" /><span></span></div>
</div>
