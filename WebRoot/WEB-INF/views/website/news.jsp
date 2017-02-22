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
		    <!-- <script type="text/javascript">
			 $("header").load("header.do");
		    </script> -->
		    <jsp:include page="header.jsp" flush="true"/>
		</header>
		<!--header end-->
		<!--banner-->
		<div class="banner">
			<img alt="" src="downFileResult.do?urlPath=${categoryInfo.systemPictureInfo.urlPath }" class="banner_img">
			<div class="nav_bg">
				<ul class="navigation">
					<c:forEach items="${categoryList}" var="category" varStatus="status">
						<li <c:if test="${categoryId eq  category.id}">class="selected"</c:if>><a href="news.do?categoryId=${category.id }">${category.categoryName }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="newslist_box">
					<ul>
						<c:forEach items="${newsList }" var="news">
							<li>
								<a href="newsDetail.do?id=${news.id }">
								<div class="newslist_left">
									<img src="downFileResult.do?urlPath=${news.systemPictureInfo.urlPath}" alt="" />
								</div>
									<div class="newslist_right">
										<h2 class="title4">${news.title }</h2>
										<p class="newslist_time">${news.createDateStr }</p>
										<div class="newslist_detail">${news.content }</div>
									</div>
							  </a>
							</li>
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
