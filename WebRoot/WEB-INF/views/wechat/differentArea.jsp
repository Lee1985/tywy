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
		<style type="text/css">
			main{
				overflow: auto;
    			-webkit-overflow-scrolling: touch;
			}
		</style>
	</head>
	<body class="gray_bg" ontouchstart="">
		<main>
	           <ul class="piclist_box">
	           	<c:forEach items="${albums}" var="item" varStatus="status">
	           		<li>
		           		<a class="album_detail" data-id="${item.id }" data-parentid="${item.parentid}" href="javaScript:void(0)">
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
		      $(".single_select input:checked").each(function() {
		        idList.push($(this).attr('id'));
		      });
		      //id用-拼接
		      var str = idList.join("-");

		      var url = './batchAddFavourite.do'; //收藏接口
		      var userid = "${userid}";
		      if (userid != null && userid != "") {} else {
		        userid = 'o_rsSv19Shjb9U71kWm8QmWdfh_E'; //当前用户,当前写死
		      }
		      $.post(url, {
		        ids: str,
		        userid: userid
		      },
		      function(data) {
		        //提示消息
		        layer.open({
		          content: data.msg,
		          time: 2
		        });
		        window.location.href = "./toCollection.do?userid=" + userid;
		      },
		      'json');
		    } else {
		      //提示消息，请选择需要收藏的图片
		      layer.open({
		        content: '请选择需要收藏的图片',
		        time: 2
		      });
		    }
		  });
		  
		  $('body').on('click','.album_detail',function(){
			  var indexs=$(this).parent('li').index();
			  var page = indexs+1;
			  var id = $(this).data('id');
			  var parentid = $(this).data('parentid');
			  window.location.href = "./toGallery.do?id=" + id + "&parentid=" + parentid + "&userid=${userid}";
		  });
		});

		/* function toDetail(id, parentid) {
		  window.location.href = "./toGallery.do?id=" + id + "&parentid=" + parentid + "&userid=${userid}";
		} */
		
		$(function() {
		  var height = function() {
		    var h = $(window).height();
		    var h2 = $('.sc_box').height();
		    $("main").height(h - h2);
		  };
		  height();
		
		  var nScrollHight = 0;
		  var nScrollTop = 0;
		  var nDivHight = $("main").height();
		  var html = '';
		  var page = 2;
		  var scroll_do = true;
			
		  //函数节流
		  function throttle(fun, delay, time) {
		    var timeout, startTime = new Date();
		    return function() {
		      var context = this,
		      args = arguments,
		      curTime = new Date();
		      clearTimeout(timeout);
		      // 如果达到了规定的触发时间间隔，触发 handler
		      if (curTime - startTime >= time) {
		        fun.apply(context, args);
		        startTime = curTime;
		        // 没达到触发间隔，重新设定定时器
		      } else {
		        timeout = setTimeout(fun, delay);
		      }
		    };
		  };
			
		  var totalnum=${total};
		  var curtotal=${currtotal};
		  var parentid='${parentid}';
		  function scroll() {
		    nScrollHight = $("main")[0].scrollHeight;
		    nScrollTop = $("main")[0].scrollTop;
		    if (nScrollTop + nDivHight >= nScrollHight - 2 && scroll_do) {
		      //html = '<li>' + '<div class="notice-date">04-15 上午 11：53</div>' + '<div class="notice-box">' + '<a href="notice_detail.html" class="link-more">' + '<img src="img/example.png"/>' + '<h2 class="title6">社区通知</h2>' + '</a>' + '</div>' + '</li>';
		      $.post("./queryDiffAreAjax.do", {
					parentid:parentid,
					page:page,
					pageSize:15// 默认30条
				},function(data) {
					totalnum=data.total;
					curtotal+=data.albums.length;
					page++;
					$.each(data.albums,function(index, item){
						if(item!=null){
						var	str = "<li>";
							str += "	<a class='album_detail' data-id='" + item.id + "' data-parentid='" + item.parentid + "' href=\"javaScript:void(0)\">";
							str += "		<img class=\"lazy\" alt=\"\" width=\"10\" height=\"10\"";
							str += "			data-original=\"downFileResult.do?urlPath="+item.systemPictureInfo.urlPath+"\"";
							str += "			src=\"downFileResult.do?urlPath="+item.systemPictureInfo.urlPath+"\" alt=\"\" />";
							str += "	</a>";
							str += "	<p>"+item.serialNumber+"</p>";
							str += "	<div class=\"single_select\">";
							str += "		<input type=\"checkbox\" name=\"single\" id=\""+item.id+"\" value=\""+item.id+"\"/>";
							str += "		<label for=\""+item.id+"\"></label>";
							str += "	</div>";
							str += "</li>";
							$(".piclist_box").append(str);
						}
					});
					 var w = $(".piclist_box li").width();
					 $(".piclist_box li").height(w);
				},'json');
		    }
		  }
		  $("main").on('scroll',throttle(scroll,100,500));
		});
	</script>
</html>
