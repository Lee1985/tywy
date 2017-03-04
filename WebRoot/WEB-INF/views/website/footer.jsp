<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="resource/website/js/header.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/website/js/footer.js" type="text/javascript" charset="utf-8"></script>
<div class="sitemap clearfix">
	<ul id="aboutFooter"><h3>关于天雅</h3></ul>
	<ul id="newsFooter"><h3>新闻动态</h3></ul>
	<ul id="brandFooter"><h3>天雅品牌</h3></ul>
	<ul>
	<h3>天雅设计</h3>
		<li><a href="designList.do">设计图册</a></li>
		<li><a href="team.do">设计团队</a></li>
	</ul>
	<ul id="caseFooter"><h3>经典案例</h3></ul>
	<ul>
	<h3>天雅销售</h3>
		<li><a href="map.do">销售网络</a></li>
		<li><a href="contact.do">联系我们</a></li>
	</ul>
	<div class="code_box">
		<img src="resource/website/img/weinxin.jpg" alt="微信二维码" width="200" height="200"/>
		<p>微信公众号</p>
	</div>
</div>	
<div class="address">
	<div class="address_title"><span class="selected">吉林</span><span>江苏</span></div>
	<div class="address_detail">
		<h3 class="address_name">吉林省天雅万印毯业科技有限公司</h3>
		<ul>
			<li>地址：中国吉林省东丰县药业大街98号</li>
			<li>邮箱：<a href="mailto:tianyanq2@126.com">tianyanq2@126.com</a></li>
			<li>网址：<a href="http://www.tycarpet.com">http://www.tycarpet.com</a></li>
		</ul>
	</div>
	<div class="address_detail address2">
		<h3 class="address_name">江苏天雅万印毯业科技有限公司</h3>
		<ul>
			<li>地址：中国江苏东丽区荒草坨北地毯仓库</li>
			<li>邮箱：<a href="mailto:tianyanq2@126.com">tianyanq2@126.com</a></li>
			<li>网址：<a href="http://www.tycarpet.com">http://www.tycarpet.com</a></li>
		</ul>
	</div>
</div>
<div class="copyright">Copyright © 2009-2016 吉林省天雅万印毯业科技有限公司版权所有 All Rights Reserved.</div>
