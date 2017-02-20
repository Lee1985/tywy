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
		<title>${title}_图集</title>
	</head>
	<body>
		<!--main-->
		<main>
           	<div class="gallery-mask" id="gallery_mask">
			    <div class="swiper-container" id="swiper_wrapper">
			        <div class="swiper-wrapper">
				        <c:forEach items="${albums}" var="item" varStatus="status">
				            <div class="swiper-slide" id="${item.id}">
				                <div class="swiper-pic">
				                	<img alt="" id="${status.index+1}" data-src="downFileResult.do?urlPath=${item.urlPath}" class="swiper-lazy" 
				                		 imgUid="${item.id}" data-desc="${item.description}">
				                    <div class="swiper-lazy-preloader"></div>
				                </div>
				            </div>
			            	<div class="clearfix"></div>
						</c:forEach>
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
				//$(this).toggleClass("selected");
				var url = './doFavourite.do';//收藏接口
				var imgUid= $(".swiper-slide.swiper-slide-active").find('img').attr('imgUid');//获取图片的id
				var userid = 'o_rsSv19Shjb9U71kWm8QmWdfh_E';//当前用户,当前写死
				$.post(url, {
					imgUid : imgUid,
					userid : userid
				}, function(data) {
					alert(data.msg);
				}, 'json');
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
