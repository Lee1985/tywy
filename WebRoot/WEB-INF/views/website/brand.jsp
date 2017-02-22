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
		<link rel="stylesheet" type="text/css" href="resource/website/css/jquery.fs.boxer.css"/>
		<!--lightbox css-->
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
		<div class="banner banner_bg6">
			<div class="nav_bg">
				<ul class="navigation">
					<c:forEach items="${brandList }" var="brandMenu">
						<li <c:if test="${brandMenu.id eq brand.id }">class="selected"</c:if>><a href="brand.do?id=${brandMenu.id }">${brandMenu.brandName }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="carpets_box">
					<div class="carpets_text">
						${brand.content }
					</div>
				</div>
				<div class="carpets_pic">
					<h2 class="title">${brand.brandName }<span>${brand.engText }</span></h2>
					<div class="qualification_box">
		        	<div class="controls-pre controls"></div>
		        	<div class="carousel-box">
		        	<div class="carousel carpets_img" id="q_carousel">
		        	
		        			<c:forEach items="${list}" var="pic" varStatus="status">
		        				<c:choose>
		        					<c:when test="${status.index % 4 eq 0 }">
		        						<ul class="owl-item">
				                            <li>
				                                <div title="${pic.imageName }" rel="gallery" class="boxer">
				                                	<img src="downFileResult.do?urlPath=${pic.systemPictureInfo.urlPath }"/>
				                                </div>
				                            </li>
		        					</c:when>
		        					<c:otherwise>
		        						<c:choose>
		        							<c:when test="${status.count % 4 eq 0 || status.count eq list.size()}">
					        					   <li>
						                                <div title="${pic.imageName }" rel="gallery" class="boxer">
						                                	<img src="downFileResult.do?urlPath=${pic.systemPictureInfo.urlPath }"/>
						                                </div>
						                           </li>
						                        </ul>
		        							</c:when>
		        							<c:otherwise>
		        								<li>
					                                <div title="${pic.imageName }" rel="gallery" class="boxer">
					                                	<img src="downFileResult.do?urlPath=${pic.systemPictureInfo.urlPath }"/>
					                                </div>
					                            </li>				                   				
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
	<script src="resource/website/js/jquery.fs.boxer.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/website/js/lightbox.js" type="text/javascript" charset="utf-8"></script>
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
