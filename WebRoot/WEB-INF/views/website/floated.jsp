<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="resource/website/js/floated.js" type="text/javascript" charset="utf-8"></script>
<div class="floated">
	<ul class="items">
		<li><div class="wx_box wx"><img src="resource/website/img/weinxin1.png" alt="" /></div></li>
		<li id="qqLi"><div class="wx_box client"><img src="resource/website/img/online.png" alt="" /></div></li>
		<li><div class="wx_box tels"><img src="resource/website/img/tele.png" alt="" /></li>
	</ul>
</div>