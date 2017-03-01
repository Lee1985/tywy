<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
		<script src="resource/website/js/jquery.fs.boxer.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/website/js/lightbox.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/website/js/owl.carousel.js" type="text/javascript" charset="utf-8"></script>
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
		<div class="banner">
			<img alt="" src="downFileResult.do?urlPath=${imageConfigUrl }" class="banner_img">
			<div class="nav_bg">
				<ul class="navigation">
					<li><a href="designList.do">设计图册</a></li>
					<li class="selected"><a href="team.do">设计团队</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="team_box">${configContent }</div>
				<div class="person_box">
					<h2 class="title team_title">TEAM<span>MEM BERS</span></h2>
					<c:if test="${!empty designMemberList }">
						<div class="big_box"><img src="downFileResult.do?urlPath=${(fn:length(designMemberList))>0?designMemberList[0].systemPictureInfo.urlPath:''}" alt="" /></div>
					</c:if>	
					<ul>
						<c:forEach items="${designMemberList }" var="member" varStatus="status">
							<li class="smallimg${status.count }  <c:if test="${status.count eq 1 }">selected</c:if>"><img src="downFileResult.do?urlPath=${member.systemPictureInfo.urlPath }" alt="" /></li>
							<!-- <li class="smallimg2"><img src="resource/website/img/smallimg1.png" alt="" /></li>
							<li class="smallimg3"><img src="resource/website/img/smallimg2.png" alt="" /></li>
							<li class="smallimg4"><img src="resource/website/img/smallimg3.png" alt="" /></li>
							<li class="smallimg5"><img src="resource/website/img/smallimg4.png" alt="" /></li>
							<li class="smallimg6"><img src="resource/website/img/smallimg5.png" alt="" /></li>
							<li class="smallimg7"><img src="resource/website/img/smallimg6.png" alt="" /></li> -->
						</c:forEach>						
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
			$(".person_box ul li").on("click",function(){
				var indexs=$(this).index();
				$(this).addClass("selected").siblings().removeClass("selected");
				$(".big_box img").attr("src",$(this).find('img').attr('src'));
			});
	});
	</script>
</html>
