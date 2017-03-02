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
		<div class="banner">
			<img alt="" src="downFileResult.do?urlPath=${imageValue}" class="banner_img">
			<div class="nav_bg">
				<ul class="navigation">
					<li><a href="map.do">销售网络</a></li>
					<li class="selected"><a href="contact.do">联系我们</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main">
				<div class="contact_box">
					<h2 class="title">联系我们<span>Contact us</span></h2>
					<div class="contact_text">${contentValue }</div>
				    <ul class="contact_method clearfix">
				    	<li>
				    		<img src="resource/website/img/icon_00.png" alt="" />
				    		<p class="c_name">在线客服</p>
				    		<p class="c_time">每天8:30-17:00</p>
				    	</li>
				    	<li>
				    		<img src="resource/website/img/icon_10.png" alt="" />
				    		<p class="c_name">电话:${telValue }</p>
				    		<p class="c_time">每天8:30-17:00</p>
				    	</li>
				    	<li class="contact">
				    		<img src="resource/website/img/icon_20.png" alt="" />
				    		<p class="c_name">在线留言</p>
				    		<p class="c_time">写下您的问题</p>
				    	</li>
				    </ul>
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
		<!--弹出层-->
		<div class="mask1">
			<div class="poup_box1">
				<h1 class="title">留言</h1>
				<form class="select_box" method="post" action="contactSubmit.do">
					<!--联系方式-->
					<div class="form_box">
						<div class="form_title">联系姓名</div>
						<div class="form_detail">
							<input type="text" id="name" name="name" placeholder="姓名" />
						</div>
					</div>
					<!--联系方式-->
					<!--联系地址-->
					<div class="form_box">
						<div class="form_title">联系方式</div>
						<div class="form_detail">
							<input type="text" id="tel" name="mobile" placeholder="手机号" />
						</div>
					</div>
					<!--联系地址-->
					<!--留言框-->
					<div class="form_box">
						<div class="form_title">留言內容</div>
						<div class="form_detail">
							<textarea id="content" name="content" rows="" cols=""></textarea>
						</div>
					</div>
					<!--留言框-->
					<div class="submit" style="display: inline-block;">提交</div>
					<div class="cancel" style="display: inline-block;">取消</div>
				</form>
			</div>
		</div>
		<!--弹出层-->
	</body>
	<script type="text/javascript">
		$(function(){
			//鼠标经过联系方式box
			$(".contact_method li").hover(function(){
				var indexs=$(this).index();
				$(this).find("img").attr("src","resource/website/img/icon_"+indexs+"1.png");
				$(this).find(".c_name").addClass("hover");
				$(this).find(".c_time").addClass("hover");
			},function(){
				var indexs=$(this).index();
				$(this).find("img").attr("src","resource/website/img/icon_"+indexs+"0.png");
				$(this).find(".c_name").removeClass("hover");
				$(this).find(".c_time").removeClass("hover");
			});
			//彈出層
			var h=$(window).height();
			$(window).on("load resize",function(){
				$(".mask1").height(h);
			});
			$(".contact").on("click",function(){
				$(".mask1").show();
				$("html,body").css({overflow:"hidden",height:h});
			});
			$(".submit").on("click",function(){
				if($.trim($('#name').val()) == ''){
					alert('请输入您的姓名!')
					return false;
				}
				if($.trim($('#tel').val()) == ''){
					alert('请输入您的联系方式!')
					return false;
				}
				if($.trim($('#content').val()) == ''){
					alert('请输入您的留言内容!')
					return false;
				}
				
				var ajaxOptions = {
	    		 url: 'contactSubmit.do',
	    		 data:{name:$('#name').val(),mobile:$('#tel').val(),content:$('#content').val()},
	    		 type: 'post',
	    		 async: false,
	    		 dataType: 'json',
	    		 success: function(data) {
	    			 alert('留言成功,感谢您的反馈!');
	    			 $(".mask1").hide();
	 				 $("html,body").css({overflow:"auto",height:"auto"});
	    		 }
	    		};
	    		$.ajax(ajaxOptions);
				
				//$(".mask1").hide();
				//$("html,body").css({overflow:"auto",height:"auto"});
			});
			$(".cancel").on("click",function(){
				$(".mask1").hide();
				$("html,body").css({overflow:"auto",height:"auto"});
			});
			//彈出層
		});
	</script>
</html>
