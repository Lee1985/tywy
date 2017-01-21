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
		<title>我的收藏</title>
	</head>
	<body class="gray_bg">
		<!--header-->
		<!--<header>
			<h1 class="title"><a href="javascript:history.go(-1);" class="back">返回</a>我的收藏<a href="javasript:;" class="more"></a></h1>
		</header>-->
		<div class="edit_box">
				<div class="edit_rank"><span>时间正序</span></div>
				<div class="edit_text">编辑</div>
		</div>
		<!--header-->
		<!--main-->
		<main class="ts">
			<div class="day_box">
			   <h1 class="time">2016/10/10<p class="single_all"><input type="checkbox" name="single" id="single" value=""/><label for="single"></label></p></h1>
	           <ul class="piclist_box1">
	           	<li><a href="javascript:;"><img class="lazy"  alt="" width="10" height="10"  data-original="img/pic01.png" alt="" /><p>1009001</p>
	           		<div class="single_select">
	           			<input type="checkbox" name="single" id="single01" value="01"/><label for="single01"></label>
	           		</div>
	           	</a></li>
	           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic02.png" alt="" /><p>1009001</p>
	           		<div class="single_select">
	           			<input type="checkbox" name="single" id="single02" value="02"/><label for="single02"></label>
	           		</div>
	           	</a></li>
	           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic03.png" alt="" /><p>1009001</p>
	           		<div class="single_select">
	           			<input type="checkbox" name="single" id="single03" value="03"/><label for="single03"></label>
	           		</div>
	           	</a></li>
	           </ul>
			</div>
		<div class="day_box">
		<h1 class="time">2016/10/10 <p class="single_all"><input type="checkbox" name="single" id="single1" value=""/><label for="single1"></label></p></h1>
           <ul class="piclist_box1">
           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic01.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single04" value="04"/><label for="single04"></label>
           		</div>
           	</a></li>
           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic02.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single05" value="05"/><label for="single05"></label>
           		</div>
           	</a></li>
           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic03.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single06" value="06"/><label for="single06"></label>
           		</div>
           	</a></li>
           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic03.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single07" value="07"/><label for="single07"></label>
           		</div>
           	</a></li>
           	<li><a href="javascript:;"><img class="lazy" alt="" width="10" height="10"  data-original="img/pic03.png" alt="" /><p>1009001</p>
           		<div class="single_select">
           			<input type="checkbox" name="single" id="single08" value="08"/><label for="single08"></label>
           		</div>
           	</a></li>
           </ul>
        </div>
		</main>
		<!--main-->
		<!--footer-->
		<footer>
			<div class="sc_box show_box">
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
            //点击编辑时
            $(".edit_text").on("click",function(){
//          	$(this).parents(".edit_box").slideUp();
            	$(".single_all,.single_select,.sc_box.show_box,.sc_operate").show();
//          	$(".sc_box.show_box").slideDown();
            });
            //点击排序
            $(".edit_rank").on("click",function(){
            	if ($(this).find("span").text()=="时间正序") {
            		$(this).find("span").text("时间逆序");
            	} else{
            		$(this).find("span").text("时间正序")
            	}
            	
            });
            //点击批量选择按钮
            $(".sc1").on("click",function(){
            	$(this).hide();
            	$(".sc_operate,.single_select").show();
            });
           //全选所有日期
	           $(".select_all").on("click",function(){
	           	$(".single_select,.single_all").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
	           	if ($(this).find("input").prop("checked")) {
	        		$(".select_all label").text("取消全选");
	        	} else{
	        		$(".select_all label").text("全选");
	        	}
	        	shoucang();
	           });
	           //全选同一日期
	          var len0=$(".single_all").length;
	           $(".single_all").on("click",function(){
	           	$(this).parent().next(".piclist_box1").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
	             //按日期全选时
	        	var len11=$(".single_all input:checked").length;
	        	quanxuan(len0,len11);
	        	shoucang();
	           });
	           
	        
	       //当单选时，逐个选择了全部
	        var len=$(".single_select").length;
	        $(".single_select").on("click",function(){
	        	var len00=$(this).parents(".piclist_box1").find("li").length;
	        	var len1=$(".single_select input:checked").length;
	        	var len2=$(this).parents(".piclist_box1").find(".single_select input:checked").length;
	        	if (len00==len2) {
	        		$(this).parents("ul").prev(".time").find("input").prop("checked",true);
	        	}else{
	        		$(this).parents("ul").prev(".time").find("input").prop("checked",false);
	        	}
	        	quanxuan(len,len1);
	        	shoucang();
	           });
	           
	           function quanxuan(len1,len2){
		        	if (len1==len2) {
		        		$(".select_all input").prop("checked",true);
		        		$(".select_all label").text("取消全选");
		        	}else{
		        		$(".select_all input").prop("checked",false);
		        		$(".select_all label").text("全选");
		        	}
	           }
	           
	           function shoucang(){
		           	for (var i=0; i<$(".single_select").length; i++) {
			           	if ($(".ts").find(".single_select").eq(i).find("input").prop("checked")) {
			        		$(".sc_text").text("取消收藏");
			        		break;
			        	} else{
			        		$(".sc_text").text("收藏");
			        	}
		           	}
		       }
		});
	</script>
</html>
