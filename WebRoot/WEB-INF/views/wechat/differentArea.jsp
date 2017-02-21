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
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="format-detection" content="email=no" />
		<link rel="stylesheet" type="text/css" href="css/wechat/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/style.css"/>
		<link rel="stylesheet" type="text/css" href="js/wechat/need/layer.css"/>
		<title>${title}</title>
	</head>
	<body class="gray_bg">
		<main>
           <ul class="piclist_box">
           	<c:forEach items="${albums}" var="item" varStatus="status">
           		<li>
	           		<a href="javaScript:void(0)" onclick="toDetail('${item.id}','${item.parentid}')">
	           			<img class="lazy" alt="" width="10" height="10"  
	           				data-original="downFileResult.do?urlPath=${item.systemPictureInfo.urlPath}"  
	           				src="downFileResult.do?urlPath=${item.systemPictureInfo.urlPath}" alt="" />
	           		</a>
           			<p>${item.serialNumber}</p>
	           		<div class="single_select">
	           			<input type="checkbox" name="single" id="${item.id}" value="${item.id}"/>
	           			<label for="${item.id}"></label>
	           		</div>
	           	</li>
			</c:forEach>
           </ul>			
		</main>
		<!--main-->
		<!--footer-->
		<footer>
			<div class="sc_box">
				<span class="sc1">批量收藏</span>
				<div class="sc_operate">
					<div class="select_all">
						<input type="checkbox" name="all" id="all" value="0"/>
						<label for="all">全选</label>
					</div>
					<div class="sc_text">收藏</div>
				</div>
			</div>
		</footer>
		<!--footer-->
	</body>
	
	<script src="js/wechat/rem.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery.lazyload.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/layer.js" type="text/javascript" charset="utf-8"></script>
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
			//点击批量选择按钮
			$(".sc1").on("click",
			function() {
				$(this).hide();
				$(".sc_operate,.single_select").show();
			});
			//全选
			$(".select_all").on("click",
			function() {
				$(".single_select").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
				if ($(this).find("input").prop("checked")) {
					//$(".sc_text").text("取消收藏");
					$(".select_all label").text("取消全选");
				} else {
					//$(".sc_text").text("收藏");
					$(".select_all label").text("全选");
				}
			});
			//当单选时，选择的全部
			var len = $(".single_select").length;
			$(".single_select").on("click",
			function() {
				var len1 = $(".single_select input:checked").length;
				if (len == len1) {
					$(".select_all input").prop("checked", true);
					//$(".sc_text").text("取消收藏");
					$(".select_all label").text("取消全选");
				} else {
					$(".select_all input").prop("checked", false);
					//$(".sc_text").text("取消收藏");
					$(".select_all label").text("全选");
				}
			});
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
					
					var url = './batchAddFavourite.do';//收藏接口
					var userid = 'o_rsSv19Shjb9U71kWm8QmWdfh_E';//当前用户,当前写死
					$.post(url, {
						ids : str,
						userid : userid
					}, function(data) {
						//提示消息
						layer.open({
							content: data.msg,
							time: 2
						});
						window.location.href="./toCollection.do?userid=" + userid;
					}, 'json');
				} else {
					//提示消息，请选择需要收藏的图片
					layer.open({
						content: '请选择需要收藏的图片',
						time: 2
					});
				}
			});
		});
		
		function toDetail(id, parentid) {
			window.location.href="./toGallery.do?id=" + id + "&parentid=" + parentid + "&title=${title}";
		}
	</script>
</html>
