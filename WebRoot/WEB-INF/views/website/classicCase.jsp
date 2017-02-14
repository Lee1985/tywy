<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<div class="banner banner_bg8">
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="carpets_box">
					<div class="carpets_text">
						<p>天雅知道，色彩，设计决定了整个外观和空间的感觉。为了确保我们的设计看起来更精湛，天雅使用的打印其技术是世界上最先进的数码印花技术。这完美的数码印刷技术能够将精心设计的图案和细节完美的呈现。</p>
						<p>公司设有设计研发中心，具有最大、最专业的设计团队，并与意大利顶级设计公司长期深度合作，拥有多项图案设计专利，不断推出国际最新趋势的印花地毯设计。</p>
					</div>
				</div>
				<div class="carpets_pic case">
					<div class="qualification_box">
		        	<div class="controls-pre1 controls1 disabled"></div>
		        	<div class="carousel-box">
		        	<div class="carousel case_img" id="d_carousel">
		        			<a href="javascript:;" class="selected">2017</a>
		        			<a href="javascript:;">2016</a>
		        			<a href="javascript:;">2015</a>
		        			<a href="javascript:;">2014</a>
		        			<a href="javascript:;">2013</a>
		        			<a href="javascript:;">2012</a>
		        			<a href="javascript:;">2011</a>
		        			<a href="javascript:;">2010</a>
		        			<a href="javascript:;">2009</a>
		        			<a href="javascript:;">2008</a>
	                    </div>
		        	</div>
		            <div class="controls-next1 controls1"></div>
		            <div class="clearfix"></div>
		        </div>
				</div>
				<div class="case_list clearfix">
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img1.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img2.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img3.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img4.png" alt="" />
						<p class="case_name">印花天雅地毯印花天雅地毯印花天雅地毯印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img5.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img6.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img7.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
					<a title="照片的名称或没写就不显示照片的名称或没写就不显示照片的名称或没写就不显示照片的名称" rel="gallery" class="boxer" href="resource/website/img/lightbox1.png">
						<img src="resource/website/img/img8.png" alt="" />
						<p class="case_name">印花天雅地毯</p>
						<p class="case_number">1009001</p>
					</a>
				</div>
				<section id="page_container" class="page-container">
					<div class="list-view-page">
						<div class="wrapper">
							<div id="Pagination" class="pagination">
								<a href="javascript:void(0)">首页</a>
								<a href="javascript:void(0)">上一页</a>
								<span class="current">1</span>
								<a href="?p=2">2</a>
								<a href="?p=3">3</a>
								<a href="?p=4">4</a>
								<a href="?p=5">5</a>
								<a href="?p=2" class="next">下一页</a>
								<a href="?p=5" class="next">尾页</a>
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
	<script src="js/owl.carousel.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.fs.boxer.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/lightbox.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.pagination.js" type="text/javascript" charset="utf-8"></script>
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
	 	var num_entries=100;
        $("#Pagination").pagination(num_entries, {
            items_per_page: 10, //每页显示10条数目
            num_edge_entries: 1, //边缘页数
            num_display_entries: 4, //主体页数，
            current_page: 1, //当前选中的页面
//          callback: pageselectCallback,
            prev_text: "上一页",
            next_text: "下一页"
        });

    }
   initPagination();
	</script>

</html>
