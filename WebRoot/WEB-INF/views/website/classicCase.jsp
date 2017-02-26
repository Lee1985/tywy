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
		<!--分页器 css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/pagination.css"/>
		<!--分页器 css-->
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
		<div class="banner banner_bg8">
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="carpets_box">
					<div class="carpets_text">
						${configInfo.configValue }
					</div>
				</div>
				<div class="carpets_pic case">
					<div class="qualification_box">
		        	<div class="controls-pre1 controls1 disabled"></div>
		        	<div class="carousel-box">
		        		<div class="carousel case_img" id="d_carousel">		        			
		        			<c:forEach items="${caseList }" var="caseInfo">
		        				<a id="${caseInfo.id }" href="classicCase.do?caseId=${caseInfo.id}&page=1#${caseInfo.id }" <c:if test="${caseId eq caseInfo.id }">class="selected"</c:if>>${caseInfo.caseName }</a>
		        			</c:forEach>
	                    </div>
		        	</div>
		            <div class="controls-next1 controls1"></div>
		            <div class="clearfix"></div>
		        </div>
				</div>
				<div class="case_list clearfix">
					<c:forEach items="${list }" var="picture">
						<div title="${picture.imageName}" rel="gallery" class="boxer" href="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }">
							<img src="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }" alt="" />
							<p class="case_name">${picture.imageName}</p>
							<p class="case_number">${picture.serialNumber}</p>
						</div>
					</c:forEach>
				</div>
				<section id="page_container" class="page-container">
					<div class="list-view-page">
						<div class="wrapper">
							<div id="Pagination" class="pagination">
								<%-- <a href="classicCase.do?caseId=${caseId}&page=1">首页</a>
								<a href="classicCase.do?caseId=${caseId}&page=${page-1}">上一页</a>
								<c:forEach var="p" begin="1" end="${pages}" step="1">
									<c:choose>
										<c:when test="${p eq page}">
											<span class="current">${p}</span>			
										</c:when>
										<c:otherwise>
											<a href="classicCase.do?caseId=${caseId}&page=${p}">${p}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<a href="classicCase.do?caseId=${caseId}&page=${page+1}" class="next">下一页</a>
								<a href="classicCase.do?caseId=${caseId}&page=${pages}" class="next">尾页</a> --%>
							</div>
						</div>
					</div>
             </section>
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
	<script src="resource/website/js/jquery.pagination.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
		var  q_owl = $("#d_carousel");
            q_owl.owlCarousel({
	   	    items: 6,
	        navigation: false,    
	        autoPlay: false,
	        stopOnHover: true,
	        pagination : false,
	        slideSpeed:500,
	        rewindNav:false
    });
    //判断浏览器版本
    function myBrowser(){
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isOpera = userAgent.indexOf("Opera") > -1;
    if (isOpera) {
        return "Opera"
    }; //判断是否Opera浏览器
    if (userAgent.indexOf("Firefox") > -1) {
        return "FF";
    } //判断是否Firefox浏览器
    if (userAgent.indexOf("Chrome") > -1){
  return "Chrome";
 }
    if (userAgent.indexOf("Safari") > -1) {
        return "Safari";
    } //判断是否Safari浏览器
    if (window.navigator.userAgent.indexOf('compatible') != -1) {
        if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
        return "IE";
    }; //判断是否IE浏览器
        return('360兼容模式');
     }
    if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
        return('360极速模式');
     }
}

 
   var mb = myBrowser();
   	//上一张切换
    $(".qualification_box .controls-pre1").click(function(e){ 
            if ("IE" == mb) {
    	    var a=parseFloat($(".owl-wrapper").css("left"));
            }else{
            var a=parseFloat($(".owl-wrapper").css("transform").substring(7).split(",")[4]);
            }
    		q_owl.trigger('owl.prev');
            if (a>=-140) {
            	$(".qualification_box .controls-pre1").addClass("disabled");
            }
            if (a<=-420) {
	    			$(".qualification_box .controls-next1").removeClass("disabled");
	    		}
    });

    //下一张切换
    $(".qualification_box .controls-next1").click(function(e){
    	    if ("IE" == mb) {
    	    var a=parseFloat($(".owl-wrapper").css("left"));
            }else{
            var a=parseFloat($(".owl-wrapper").css("transform").substring(7).split(",")[4]);
            }
    		q_owl.trigger('owl.next');
    		if (a<=0) {
    			$(".qualification_box .controls-pre1").removeClass("disabled");
    		}
	    		if (a<=-420) {
	    			$(".qualification_box .controls-next1").addClass("disabled");
	    		}

    });
    //判断户型轮播是否显示左右切换按钮
   	if(showHxCarouselControls()){ 
   		$(".qualification_box .controls-next1").removeClass("disabled");
   	}else{
   		$(".qualification_box .controls-next1").addClass("disabled");
   		 $(".qualification_box .controls1").unbind("click");
   	}
    //判断是否能显示户型的轮播的左右切换按钮，超过7个菜显示
   function showHxCarouselControls(){ 
   	 var length = $("#d_carousel a").length;
   	 if(length > 6){ 
   	 	return true;
   	 }else{ 
   	 	return false;
   	 }

   }
   $(".owl-item a").on("click",function(){
				$(this).addClass("selected").parent(".owl-item").siblings().find("a").removeClass("selected");
			});
	});
	
	//
	 function initPagination() {
	 	var num_entries=${total};
        $("#Pagination").pagination(num_entries, {
            items_per_page: 8, //每页显示10条数目
            num_edge_entries: 1, //边缘页数
            num_display_entries: 4, //主体页数，
            current_page: 0, //当前选中的页面
//          callback: pageselectCallback,
			link_to:"classicCase.do?caseId=${caseId}",
            prev_text: "上一页",
            next_text: "下一页"
        });

    }
   initPagination();
	</script>

</html>
