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
		<div class="edit_box">
			<div class="edit_rank"><span>时间正序</span></div>
			<div class="edit_text">编辑</div>
		</div>
		<!--header-->
		<!--main-->
		<main class="ts">
			<c:forEach items="${resultList}" var="item">
				<div class="day_box">
					<h1 class="time">${item.createdate}
						<p class="single_all"><input type="checkbox" name="single" id="single" value=""/>
							<label for="single"></label>
						</p>
					</h1>
					<ul class="piclist_box1">
						<c:forEach items="${item.entity}" var="entity">
							<li>
								<a href="javascript:;">
									<img class="lazy"  alt="" width="10" height="10"  data-original="downFileResult.do?urlPath=${entity.album.urlPath}" alt="" />
								</a>
								<p>${entity.album.serialNumber}</p>
								<div class="single_select">
									<input type="checkbox" name="single" id="${entity.id}" value="${entity.album.orderList}"/><label for="${entity.id}"></label>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
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
		$(function() {
			//获取列表图片高度
			$(window).on("load resize",
			function() {
				var w = $(".piclist_box li").width();
				$(".piclist_box li").height(w);
			});
			//滑动懒加载效果
			$("img.lazy").lazyload({
				effect: "fadeIn",
				failure_limit: 100
			});
			//点击编辑时
			$(".edit_text").on("click",
			function() {
				//          	$(this).parents(".edit_box").slideUp();
				$(".single_all,.single_select,.sc_box.show_box,.sc_operate").show();
				//          	$(".sc_box.show_box").slideDown();
			});
			//点击排序
			$(".edit_rank").on("click",
			function() {
				var sortFlag;
				if ($(this).find("span").text() == "时间正序") {
					$(this).find("span").text("时间逆序");
					sortFlag = 2;
				} else {
					$(this).find("span").text("时间正序")
					sortFlag = 1;
				}
				var url = './toCollection.do';//排序接口
				var userid = 'o_rsSv19Shjb9U71kWm8QmWdfh_E';//当前用户,当前写死
				window.location.href="./toCollection.do?userid=" + userid + "&sortFlag=" + sortFlag;
				
			});
			//点击批量选择按钮
			$(".sc1").on("click",
			function() {
				$(this).hide();
				$(".sc_operate,.single_select").show();
			});
			//全选所有日期
			$(".select_all").on("click",
			function() {
				$(".single_select,.single_all").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
				if ($(this).find("input").prop("checked")) {
					$(".select_all label").text("取消全选");
				} else {
					$(".select_all label").text("全选");
				}
				shoucang();
			});
			//全选同一日期
			var len0 = $(".single_all").length;
			$(".single_all").on("click",
			function() {
				$(this).parent().next(".piclist_box1").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
				//按日期全选时
				var len11 = $(".single_all input:checked").length;
				quanxuan(len0, len11);
				shoucang();
			});
	
			//当单选时，逐个选择了全部
			var len = $(".single_select").length;
			$(".single_select").on("click",
			function() {
				var len00 = $(this).parents(".piclist_box1").find("li").length;
				var len1 = $(".single_select input:checked").length;
				var len2 = $(this).parents(".piclist_box1").find(".single_select input:checked").length;
				if (len00 == len2) {
					$(this).parents("ul").prev(".time").find("input").prop("checked", true);
				} else {
					$(this).parents("ul").prev(".time").find("input").prop("checked", false);
				}
				quanxuan(len, len1);
				shoucang();
			});
	
			function quanxuan(len1, len2) {
				if (len1 == len2) {
					$(".select_all input").prop("checked", true);
					$(".select_all label").text("取消全选");
				} else {
					$(".select_all input").prop("checked", false);
					$(".select_all label").text("全选");
				}
			}
	
			function shoucang() {
				for (var i = 0; i < $(".single_select").length; i++) {
					if ($(".ts").find(".single_select").eq(i).find("input").prop("checked")) {
						$(".sc_text").text("取消收藏");
						break;
					} else {
						$(".sc_text").text("收藏");
					}
				}
			}
			
			//点击收藏/取消收藏按钮
			$(".sc_text").on("click",
			function() {
				var len = $(".single_select input:checked").length;
				//判断是否需要调用后台接口服务
				if (len > 0) {
					//获取选中图片主键list
					var idList = new Array();
					$(".single_select input:checked").each(
					function(){
					    idList.push($(this).attr('id'));
					});
					//id用-拼接
					var str = idList.join("-");
					
					var url = './batchDeleteFavourite.do';//收藏接口
					var userid = 'o_rsSv19Shjb9U71kWm8QmWdfh_E';//当前用户,当前写死
					$.post(url, {
						ids : str,
						userid : userid
					}, function(data) {
						//提示消息
						console.log(data.msg);
						window.location.href="./toCollection.do?userid=" + userid;
					}, 'json');
				} else {
					//提示消息，请选择需要收藏的图片
					alert('请选择需要收藏的图片');
				}
			});
		});
	</script>
</html>
