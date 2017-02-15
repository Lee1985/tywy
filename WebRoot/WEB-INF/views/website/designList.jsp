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
		<!--function css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/style.css"/>
		<!--function css-->
		<!--owl css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/owl.carousel.css"/>
		<link rel="stylesheet" type="text/css" href="resource/website/css/owl.theme.css"/>
		<!--owl css-->
		<!--lightbox css-->
		<link rel="stylesheet" type="text/css" href="css/jquery.fs.boxer.css"/>
		<!--lightbox css-->
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
		<div class="banner banner_bg7">
			<div class="nav_bg">
				<ul class="navigation">
					<li class="selected"><a href="designList.do">设计图册</a></li>
					<li><a href="team.do">设计团队</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="carpets_box">
					<div class="design_box">
						<c:forEach items="${list}" var="picture" varStatus="status">
							<c:choose>
								<c:when test="${status.count eq 1 }">
									<div class="gray_bg"></div>
									<a title="${picture.designName }" rel="gallery" class="boxer design_left" href="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"><img src="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"/></a>									
								</c:when>
								<c:when test="${status.count eq 2 }">
									<div class="design_title">设计图册</div>
									<a title="${picture.designName }" rel="gallery" class="boxer design_right" href="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"><img src="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"/></a>		
								</c:when>
								<c:otherwise>
									<a style="display: none;" title="${picture.designName }" rel="gallery" class="boxer design_right" href="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"><img src="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"/></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
													
					</div>
					<div class="carpets_text">
						${configInfo.configValue }
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
	<script type="text/javascript">
		$(function(){
			var  q_owl = $("#q_carousel");
	            q_owl.owlCarousel({
		   	    items: 1,
		        navigation: false,    
		        autoPlay: false,
		        stopOnHover: true,
		        pagination : false,
		        slideSpeed:500,
		        rewindNav:false
	    	});
	 		
		   	//上一张切换
		    $(".qualification_box .controls-pre").click(function(e){ 
		    		q_owl.trigger('owl.prev');
		
		    });
	
		    //下一张切换
		    $(".qualification_box .controls-next").click(function(e){ 
		    		q_owl.trigger('owl.next');
		
		    });	
		});
	</script>
</html>
