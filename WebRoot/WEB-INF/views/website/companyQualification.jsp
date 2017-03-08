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
		<link rel="stylesheet" type="text/css" href="resource/website/css/jquery.fs.boxer.css"/>
		<script src="resource/website/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/website/js/jquery.fs.boxer.min.js" type="text/javascript" charset="utf-8"></script>
	    <script src="resource/website/js/lightbox.js" type="text/javascript" charset="utf-8"></script>
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
			<img alt="" src="downFileResult.do?urlPath=${configValue }" class="banner_img">
			<div class="nav_bg">
				<ul class="navigation">
					<c:forEach items="${introductionList }" var="introduce">
						<li><a href="aboutContent.do?id=${introduce.id }">${introduce.introduceName }</a></li>
					</c:forEach>
					<li class="selected"><a href="companyQualification.do">企业资质</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="qualification_box">
		        	<div class="controls-pre controls"></div>
		        	<div class="carousel-box">
		        		<div class="carousel" id="q_carousel">
		        			<c:forEach items="${list }" var="cq" varStatus="status">
		        				<c:choose>
		        					<c:when test="${status.index % 6 eq 0 }">
		        						<a href="javascript:;" <c:if test="${status.index eq 0 }">class="currenthx"</c:if>>
			                   			<div class="j_box">
			                   				<div title="${cq.descName}" rel="gallery" class="boxer" href="downFileResult.do?urlPath=${cq.systemPictureInfo.urlPath }">
			                   					<img src="downFileResult.do?urlPath=${cq.systemPictureInfo.urlPath }" width="300" height="200" alt="" />
			                   					<p>${cq.descName}</p>
			                   				</div>
		        					</c:when>
		        					<c:otherwise>
		        						<c:choose>
		        							<c:when test="${status.count % 6 eq 0 || status.count eq list.size()}">
				        								<div title="${cq.descName}" rel="gallery" class="boxer" href="downFileResult.do?urlPath=${cq.systemPictureInfo.urlPath }">
						                   					<img src="downFileResult.do?urlPath=${cq.systemPictureInfo.urlPath }" width="300" height="200" alt="" />
						                   					<p>${cq.descName}</p>
						                   				</div>
						                   			</div>
						                   		</a>
		        							</c:when>
		        							<c:otherwise>
		        								<div title="${cq.descName}" rel="gallery" class="boxer" href="downFileResult.do?urlPath=${cq.systemPictureInfo.urlPath }">
				                   					<img src="downFileResult.do?urlPath=${cq.systemPictureInfo.urlPath }" width="300" height="200" alt="" />
				                   					<p>${cq.descName}</p>
				                   				</div>				                   				
		        							</c:otherwise>
		        						</c:choose>
		        					</c:otherwise>
		        				</c:choose>
		        			</c:forEach>		        				                   	
		           		</div>
		        	</div>
		            <div class="controls-next controls"></div>
		            <div class="clearfix"></div>
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
	<script src="resource/website/js/owl.carousel.js" type="text/javascript" charset="utf-8"></script>
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
		 	
		   	//资质上一张切换
		    $(".qualification_box .controls-pre").click(function(e){ 
		    		q_owl.trigger('owl.prev');
		    });
			
		    //资质下一张切换
		    $(".qualification_box .controls-next").click(function(e){ 
		    		q_owl.trigger('owl.next');
		
		    });
		});
	</script>
</html>
