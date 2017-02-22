<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>销售网络地图</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>
<!-- <script type="text/javascript" src="js/uploadPreview.js"></script> -->
<script src="http://api.map.baidu.com/api?v=2.0&ak=IAN0wgv9qiTllV6NWon2GgLvheuBuKUQ&s=1" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}

div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	text-align: left;
	padding: 2px;
}
</style>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 5px;
}

.ftitle {
	font-size: 12px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 65px;
}

.fitem input {
	width: 280px;
}

.anchorBL{ 
	display:none; 
} 
</style>
</head>

<body>
	<div id="container" style="width:100%;height:100%"></div>
	<div id="hqPoint" style="display: none" data-lng="" data-lat=""></div>
</body>
</html>
<script type="text/javascript">
		var ajaxOptions = {
			 url: 'system/websiteSalesGenerateMap.do',
	   		 type: 'post',
	   		 dataType: 'json',
	   		 success: function(data) {
	   			var hqInfo = data.hqInfo;
	   			var areas = data.areas;
	   			var hqName = hqInfo.area;
	   			var hqPoint = new BMap.Point(Number(hqInfo.longitude),Number(hqInfo.latitude));
	   			
	   			var map = new BMap.Map("container",{enableMapClick:false});
   				map.centerAndZoom("太原", 5);
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
		   		            size: BMAP_POINT_SIZE_SMALLER,
		   		            shape: BMAP_POINT_SHAPE_CIRCLE,
		   		            color: '#ce0000'
		   		        };
	   					var opts = {
  		   				  width : 300,     // 信息窗口宽度
  		   				  height: 120,     // 信息窗口高度
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