<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="format-detection" content="email=no" />
		<link rel="stylesheet" type="text/css" href="css/wechat/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/swiper.min.css"/>
		<title>客房专区_图集</title>
	</head>
	<body>
		<!--header-->
		<!--<header>
			<h1 class="title"><a href="javascript:history.go(-1);" class="back">返回</a>客房专区<a href="javasript:;" class="more"></a></h1>
		</header>-->
		<!--header-->
		<!--main-->
		<input type="hidden" id="id" name="id" value="${album.id}">
		<main>
           	<div class="gallery-mask" id="gallery_mask">
			    <div class="swiper-container" id="swiper_wrapper">
			        <div class="swiper-wrapper">
				        <c:forEach items="${albums}" var="item">
				            <div class="swiper-slide" id="${item.orderList}">
				                <div class="swiper-pic">
				                	<img alt="" id="1" data-src="${item.urlPath}" class="swiper-lazy" 
				                		 data-desc="${item.description}">
				                    <div class="swiper-lazy-preloader"></div>
				                </div>
				            </div>
						</c:forEach>
			            <!-- <div class="swiper-slide" id="gallery_2">
			                <div class="swiper-pic"><img alt="" id="2" data-src="images/wechat/big_pic.png" class="swiper-lazy" data-desc="02享受舒适惬意的慢生活 9款小清新阳光餐厅（来自：和家网）享受舒适惬意的慢生活 9款小清新阳光餐厅享受
			                    和家网1">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div>
			            <div class="swiper-slide" id="gallery_3">
			                <div class="swiper-pic"><img alt="" id="3" data-src="images/wechat/big_pic.png" class="swiper-lazy" data-desc="03享受舒适惬意的慢生活 9款小清新阳光餐厅（来自：和家网）享受舒适惬意的慢生活 9款小清新阳光餐厅享受
			                    和家网2">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div>
			            <div class="swiper-slide" id="gallery_4">
			                <div class="swiper-pic"><img alt="" id="4"  data-src="images/wechat/js0.png" class="swiper-lazy" data-desc="04享受舒适惬意的慢生活 9款小清新阳光餐厅（来自：和家网）享受舒适惬意的慢生活 9款小清新阳光餐厅享受
			                    和家网3">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div>
			            <div class="swiper-slide" id="gallery_5">
			                <div class="swiper-pic"><img alt="" id="5"  data-src="images/wechat/js0.png" class="swiper-lazy" data-desc="05享受舒适惬意的慢生活 9款小清新阳光餐厅（来自：和家网）享受舒适惬意的慢生活 9款小清新阳光餐厅享受
			                    和家网4">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div>
			            <div class="swiper-slide" id="gallery_6">
			                <div class="swiper-pic"><img alt="" id="6" data-src="images/wechat/big_pic.png" class="swiper-lazy" data-desc="06享受舒适惬意的慢生活 9款小清新阳光餐厅（来自：和家网）享受舒适惬意的慢生活 9款小清新阳光餐厅享受
			                    和家网5">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div>
			            <div class="swiper-slide" id="gallery_7">
			                <div class="swiper-pic"><img alt="" id="8" data-src="images/wechat/big_pic.png" class="swiper-lazy" data-desc="07享受舒适惬意的慢生活 9款小清新阳光餐厅（来自：和家网）享受舒适惬意的慢生活 9款小清新阳光餐厅享受
			                    和家网6">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div>
			            <div class="swiper-slide" id="gallery_8">
			                <div class="swiper-pic"><img alt="" id="9" data-src="images/wechat/big_pic.png" class="swiper-lazy" data-desc="08享受舒适惬意的慢生活 7">
			                    <div class="swiper-lazy-preloader"></div>
			                </div>
			            </div> -->
			            <div class="clearfix"></div>
			        </div>
			    </div>

			    <div class="gallery-bottom">
			        <div class="gallery-bottom-info-wrap">
			            <div class="gallery-bottom-page"><span id="page"></span><span id="img_desc"></span></div>
			        </div>
			    </div>
		</div>
		</main>
		<!--main-->
		<div class="sc_share">
			<div class="scang"></div>
			<div class="share"></div>
		</div>
		
		<div id="div_share_notice" style="display: none; 
			    right: 0;
			    bottom: 0;
			    z-index: 904;
			    background: rgba(0, 0, 0, 0.8);    
			    position: absolute;
			    left: 50%;
			    top: 50% !important;
			    transform: translateY(-95%);
			    color: #fff;">
            <h3>立刻分享吧！</h3>
            <div>
                <p>分享此给您的朋友吧~！</p>
            </div>
		</div>
	</body>
	<script src="js/wechat/rem.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/swiper.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/imggallery.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			//点击窗口图片描述隐藏
			$("main").on("click",function(){
				$(".sc_share,.gallery-bottom").fadeToggle();
			});
			//点击收藏按钮
			$(".scang").on("click",function(){
				$(this).toggleClass("selected");
			});
			$(".share").on("click",function(){
				$("#div_share_notice").css('display','block');
			});
			$("#div_share_notice").on("click",function(){
				$("#div_share_notice").css('display','none');
			});
		});
	</script>
</html>
