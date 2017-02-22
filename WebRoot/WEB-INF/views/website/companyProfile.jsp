<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		    <jsp:include page="header.jsp" flush="true"/>
		</header>
		<!--header end-->
	<!--banner-->
		<div class="banner">
			<img alt="" src="downFileResult.do?urlPath=${introduction.systemPictureInfo.urlPath }" class="banner_img">
			<div class="nav_bg">
				<ul class="navigation">
					<c:forEach items="${introductionList }" var="introduce">
						<li <c:if test="${introduce.id eq introduction.id}">class="selected"</c:if>><a href="aboutContent.do?id=${introduce.id }">${introduce.introduceName }</a></li>
					</c:forEach>
					<li><a href="companyQualification.do">企业资质</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="company_profile">
					<h1 class="title2">${introduction.introduceName }</h1>
					<div class="c_detail">
						${introduction.description }
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
