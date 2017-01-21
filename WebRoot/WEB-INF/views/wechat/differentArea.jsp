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
		<title>客房专区</title>
	</head>
	<body class="gray_bg">
		<!--header-->
		<!--<header>
			<h1 class="title"><a href="javascript:history.go(-1);" class="back">返回</a>客房专区<a href="javasript:;" class="more"></a></h1>
		</header>-->
		<!--header-->
		<!--main-->
		<main>
           <ul class="piclist_box">
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_1')"><img class="lazy"  alt="" width="10" height="10"  data-original="images/wechat/pic01.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single01" value="01"/><label for="single01"></label>
           		</div>
           	</a></li>
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_2')"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic02.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single02" value="02"/><label for="single02"></label>
           		</div>
           	</a></li>
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_3')"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic03.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single03" value="03"/><label for="single03"></label>
           		</div>
           	</a></li>
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_4')"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic01.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single04" value="04"/><label for="single04"></label>
           		</div>
           	</a></li>
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_5')"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic02.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single05" value="05"/><label for="single05"></label>
           		</div>
           	</a></li>
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_6')"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic03.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single06" value="06"/><label for="single06"></label>
           		</div>
           	</a></li>
           	<li><a href="gallery.jsp#gallery_7"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic01.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single07" value="07"/><label for="single07"></label>
           		</div>
           	</a></li>
           	<li><a href="javaScript:void(0)" onclick="toDetail('gallery_7')"><img class="lazy" alt="" width="10" height="10"  data-original="images/wechat/pic02.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single08" value="08"/><label for="single08"></label>
           		</div>
           	</a></li>
           </ul>			
		</main>
		<!--main-->
		<!--footer-->
		<footer>
			<div class="sc_box">
				<span class="sc1">批量收藏</span>
				<div class="sc_operate">
					<div class="select_all"><input type="checkbox" name="all" id="all" value="0"/><label for="all">全选</label></div>
					<div class="sc_text">收藏</div>
				</div>
			</div>
		</footer>
		<!--footer-->
	</body>
	<script src="js/wechat/rem.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery.lazyload.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			//获取列表图片高度
			$(window).on("load resize",function(){
				var w=$(".piclist_box li").width();
				$(".piclist_box li").height(w);
			});
            //滑动懒加载效果
			$("img.lazy").lazyload({
                effect : "fadeIn",
                failure_limit : 100
            });
            //点击批量选择按钮
            $(".sc1").on("click",function(){
            	$(this).hide();
            	$(".sc_operate,.single_select").show();
            });
           //全选
	           $(".select_all").on("click",function(){
	           	$(".single_select").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
	           	if ($(this).find("input").prop("checked")) {
	        		$(".sc_text").text("取消收藏");
	        		$(".select_all label").text("取消全选");
	        	} else{
	        		$(".sc_text").text("收藏");
	        		$(".select_all label").text("全选");
	        	}
	           });
	       //当单选时，选择的全部
	        var len=$(".single_select").length;
	        $(".single_select").on("click",function(){
	        	var len1=$(".single_select input:checked").length;
	        	if (len==len1) {
	        		$(".select_all input").prop("checked",true);
	        		$(".sc_text").text("取消收藏");
	        		$(".select_all label").text("取消全选");
	        	}else{
	        		$(".select_all input").prop("checked",false);
	        		$(".sc_text").text("取消收藏");
	        		$(".select_all label").text("全选");
	        	}
	           });
		});
	</script>
	<script type="text/javascript">
		function toDetail(id) {
			window.location.href="./toGallery.do?id=" + id;
		}
	</script>	
</html>
