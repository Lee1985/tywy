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
		<!--轮播图 css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/jquery.bxslider.css"/>
		<!--轮播图 css-->
		<!--function css-->
		<link rel="stylesheet" type="text/css" href="resource/website/css/style.css"/>
		<!--function css-->
		<script src="resource/website/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="http://api.map.baidu.com/api?v=2.0&ak=IAN0wgv9qiTllV6NWon2GgLvheuBuKUQ&s=1" type="text/javascript"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
		<title>天雅地毯</title>
		<style type="text/css">
			.map_container{
			    width: 843px;
   				margin: -100px auto 115px;
   				height: 650px;
			}
			.anchorBL{ 
				display:none; 
			}
		</style>
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
		<div class="banner">
			<img alt="" src="downFileResult.do?urlPath=${salesImageUrl }" class="banner_img">
			<div class="nav_bg">
				<ul class="navigation">
					<li class="selected"><a href="map.do">销售网络</a></li>
					<li><a href="contact.do">联系我们</a></li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<!--main-->
		<main>
			<div class="main1">
				<div class="map_box">
					<div class="map_text">${salesContents }</div>
					<div id="map_container" class="map_container"></div>
				</div>
				<!--网点-->
				<div class="map_sitemap">
					<ul class="sitemap_name clearfix">
						<c:forEach items="${salesCateList }" var="category" varStatus="status">
							<li <c:if test="${status.count eq 1 }">class="selected"</c:if> data-categoryid="${category.id }">${category.categoryName }</li>
						</c:forEach>
					</ul>
					<div class="sitemap_detail">
						<ul class="clearfix">
							<c:forEach items="${salesList }" var="sale">
								<li>
									<p class="company_name">${sale.company }</p>
									<c:if test="${!empty sale.contact }">
										<p class="company_list">负责人：${sale.contact }</p>
									</c:if>
									<c:if test="${!empty sale.mobile }">
										<p class="company_list">手机号：${sale.mobile }</p>
									</c:if>
									<c:if test="${!empty sale.adress }">
										<p class="company_list">地址：${sale.adress }</p>
									</c:if>
									<c:if test="${!empty sale.email }">
										<p class="company_list">邮箱：${sale.email }</p>
									</c:if>
									<c:if test="${!empty sale.fax }">
										<p class="company_list">传真：${sale.fax }</p>
									</c:if>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!--网点-->
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
	<script type="text/javascript">
		var ajaxOptions = {
			 url: 'websiteSalesGenerateMap.do',
	   		 type: 'post',
	   		 dataType: 'json',
	   		 success: function(data) {
	   			var hqInfo = data.hqInfo;
	   			var areas = data.areas;
	   			var hqName = hqInfo.area;
	   			var hqPoint = new BMap.Point(Number(hqInfo.longitude),Number(hqInfo.latitude));
	   			
	   			var map = new BMap.Map("map_container",{enableMapClick:false});
   				map.centerAndZoom("白银", 5);
   				map.disableDragging();
   				map.disableDoubleClickZoom();
   				
   				map.setMapStyle({style:'grayscale'});
   				
   				var marker = new BMap.Marker(hqPoint);  // 创建标注
	   			map.addOverlay(marker);               // 将标注添加到地图中
	   			
	   			if(areas && areas.length > 0){
	   				$.each(areas,function(index,value){
	   					
	   					//绘制弧线
	   					var lng = Number(value.longitude);
	   					var lat = Number(value.latitude);
	   					var areaPoint = new BMap.Point(lng,lat);
	   					var points = [hqPoint,areaPoint];
	   					var curve = new BMapLib.CurveLine(points, {strokeColor:"#6c6c6c", strokeWeight:1, strokeOpacity:1}); //创建弧线对象
	   					map.addOverlay(curve);
	   					
	   					//绘制标记
	   					var areaPoints = [];
	   					areaPoints.push(areaPoint);
	   					var options = {
		   		            size: BMAP_POINT_SIZE_SMALL,
		   		            shape: BMAP_POINT_SHAPE_CIRCLE,
		   		            color: '#ce0000'
		   		        };
	   					var opts = {
  		   				  width : 300,     // 信息窗口宽度
  		   				  height: 130,     // 信息窗口高度
  		   				  title : '<b>' + value.company + '</b>' // 信息窗口标题
  		   				};
	   					var content = '';
	   					if(value.contact && $.trim(value.contact) != ''){
	   						content += '负责人：' + value.contact + '<br/>';
	   					}
	   					if(value.mobile && $.trim(value.mobile) != ''){
	   						content += '联系电话：' + value.mobile + '<br/>';
	   					}
	   					if(value.email && $.trim(value.email) != ''){
	   						content += '邮箱：' + value.email + '<br/>';
	   					}
	   					if(value.adress && $.trim(value.adress) != ''){
	   						content += '地址：' + value.adress + '<br/>';
	   					}
	   					if(value.fax && $.trim(value.fax) != ''){
	   						content += '传真：' + value.fax + '<br/>';
	   					}
  		   			 	var infoWindow = new BMap.InfoWindow(content, opts);
  		   			 	var pointCollection = new BMap.PointCollection(areaPoints, options);  // 初始化PointCollection
  		 	        	pointCollection.addEventListener('click', function (e) {
  		 	          		map.openInfoWindow(infoWindow,e.point); //开启信息窗口
  		 	        	});
  		 	        	map.addOverlay(pointCollection);
	   				});
	   			}
	   		 }
	    };
		$.ajax(ajaxOptions);
	</script>
	<script type="text/javascript">
		$(function(){
			//网点分布地址点击
			$(".sitemap_name li").on("click",function(){
				$(this).addClass("selected").siblings().removeClass("selected");
				$.ajax({
					url: 'websiteSalesByCategory.do',
					type: 'post',
					dataType: 'json',
					data: {categoryId: $(this).data('categoryid')},
					success:function(data){
						var content = '';
						if(data && data.length > 0){
							$.each(data,function(index,value){
								content += '<li><p class="company_name">' + value.company + '</p>';
								if(value.contact && $.trim(value.contact) != ''){
									content += '<p class="company_list">负责人:' + value.contact + '</p>';
								}
								if(value.mobile && $.trim(value.mobile) != ''){
									content += '<p class="company_list">手机号:' + value.mobile + '</p>';
								}
								if(value.adress && $.trim(value.adress) != ''){
									content += '<p class="company_list">地址:' + value.adress + '</p>';
								}
								if(value.email && $.trim(value.email) != ''){
									content += '<p class="company_list">邮箱:' + value.email + '</p>';
								}
								if(value.fax && $.trim(value.fax) != ''){
									content += '<p class="company_list">传真:' + value.fax + '</p>';
								}
								content += '</li>';
								$('.sitemap_detail ul').html(content);
							});
						}else{
							$('.sitemap_detail ul').html('');
						}
					},
					error:function() {
						/* Act on the event */
					}
				});
			});
		});
	</script>
</html>
