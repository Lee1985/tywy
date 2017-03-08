<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="resource/website/js/header.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/website/js/template.js" type="text/javascript" charset="utf-8"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=IAN0wgv9qiTllV6NWon2GgLvheuBuKUQ&s=1" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<script type="text/html" id="tpl">
		<div class="address">
				<div class="address_title">
					{{each cityList as value key}}
					<span>{{value}}</span>
					{{/each}}
				</div>
				{{each list as value key}}
				<div class="address_detail" data-lng="{{value.lng}}" data-lat="{{value.lat}}">
					<h3 class="address_name">{{value.saleName}}</h3>
					<ul>
						<li>地址：{{value.address}}</li>
						<li>邮箱：<a href="mailto:{{value.email}}">{{value.email}}</a></li>
						<li>网址：<a href="{{value.webAddress}}">{{value.webAddress}}</a></li>
					</ul>
				</div>
				{{/each}}
			</div>
</script>
<script type="text/javascript">
	$(function(){
		var data={};
		$.ajax({
			type:"post",
			url:"netInfo.do",
			dataType:"json",
			success:function(str){
				var data=str;
				var html=template("tpl",data);
				$(".address_box").append(html);
				$(".address_title span").eq(0).addClass("selected").siblings().removeClass("selected");
				$(".address_detail").eq(0).show().siblings(".address_detail").hide();
				
				var map = new BMap.Map('mapContainer',{enableMapClick:false});            // 创建Map实例
      			var point = new BMap.Point($(".address_detail").eq(0).data('lng')+0.02, $(".address_detail").eq(0).data('lat')); // 创建点坐标
      			map.centerAndZoom(point,15);                 
      			map.disableDragging();
   				map.disableDoubleClickZoom();
   				
   				var markerPoint = new BMap.Point($(".address_detail").eq(0).data('lng'), $(".address_detail").eq(0).data('lat'));
	      		var locationIcon = new BMap.Icon("resource/website/img/location.png", new BMap.Size(46,76));
				var marker = new BMap.Marker(markerPoint,{icon:locationIcon});
				marker.setZIndex(9999);
				map.addOverlay(marker);
				
				$(".address_title span").on("click",function(){
					var indexs=$(this).index();
					$(this).addClass("selected").siblings().removeClass("selected");
					$(".address_detail").eq(indexs).show().siblings(".address_detail").hide();
					
					var map = new BMap.Map('mapContainer',{enableMapClick:false});            // 创建Map实例
	      			var point = new BMap.Point($(".address_detail").eq(indexs).data('lng')+0.02, $(".address_detail").eq(indexs).data('lat')); // 创建点坐标
	      			map.centerAndZoom(point,15);                 
	      			map.disableDragging();
	   				map.disableDoubleClickZoom();
					
					var markerPoint = new BMap.Point($(".address_detail").eq(indexs).data('lng'), $(".address_detail").eq(indexs).data('lat'));
 	      			var locationIcon = new BMap.Icon("resource/website/img/location.png", new BMap.Size(46,76));
					var marker = new BMap.Marker(markerPoint,{icon:locationIcon});
					marker.setZIndex(9999);
					map.addOverlay(marker);
				});
			},
			error:function(jqXHR){
				alert(jqXHR.status);
			}
		});
	});
	
	function showMap(){
		
	}
</script>
<style type="text/css">
	.anchorBL{ 
		display:none; 
	}
</style>

<div class="sitemap clearfix">
	<ul id="aboutFooter"><h3>关于天雅</h3></ul>
	<ul id="newsFooter"><h3>新闻动态</h3></ul>
	<ul id="brandFooter"><h3>天雅品牌</h3></ul>
	<ul>
	<h3>天雅设计</h3>
		<li><a href="designList.do">设计图册</a></li>
		<li><a href="team.do">设计团队</a></li>
	</ul>
	<ul id="caseFooter"><h3>经典案例</h3></ul>
	<ul>
	<h3>天雅销售</h3>
		<li><a href="map.do">销售网络</a></li>
		<li><a href="contact.do">联系我们</a></li>
	</ul>
	<div class="code_box">
		<img src="resource/website/img/weinxin.jpg" alt="微信二维码" width="200" height="200"/>
		<p>微信公众号</p>
	</div>
</div>	
<div class="address_box">
	<div class="maps_bg"></div>
	<div id="mapContainer" class="maps_box"></div>
</div>
<div class="copyright">Copyright © 2009-2016 吉林省天雅万印毯业科技有限公司版权所有 All Rights Reserved.</div>
