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
		<link rel="stylesheet" type="text/css" href="css/wechat/photoswipe.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/default-skin.css"/>
		<link rel="stylesheet" type="text/css" href="js/wechat/need/layer.css"/>
		<style type="text/css">
			main{overflow: auto;-webkit-overflow-scrolling: touch;}
			div.piclist_box{overflow: auto;width: 92%; margin-left: 4%; margin-right: 4%;  margin-bottom: 0.4rem;}
			div.piclist_box a{width: 30.6%;  margin-right: 4%; margin-bottom: 4%; float: left; overflow: hidden; position: relative;-webkit-border-radius: 0.06rem;-moz-border-radius: 0.06rem;border-radius: 0.06rem; }
			div.piclist_box a p{width: 100%; height: 0.4rem; line-height: 0.4rem; text-align: center; color: #FFFFFF; font-size: 0.24rem;position: absolute; bottom: 0; background: rgba(0,0,0,.4); 
			-webkit-border-radius-bottom-left: 0.06rem;-moz-border-radius-bottom-left: 0.06rem;-ms-border-radius-bottom-left: 0.06rem;-o-border-radius-bottom-left: 0.06rem;border-radius-bottom-left: 0.06rem;
			-webkit-border-radius-bottom-left: 0.06rem;-moz-border-radius-bottom-right: 0.06rem;-ms-border-radius-bottom-right: 0.06rem;-o-border-radius-bottom-right: 0.06rem;border-radius-bottom-right: 0.06rem;}
			div.piclist_box a img{width: 100%; height: 100%;-webkit-border-radius: 0.06rem;-moz-border-radius: 0.06rem;border-radius: 0.06rem;}
			div.piclist_box a:nth-child(3n){margin-right: 0;}
			div.demo-gallery figure {display: none;}
			/*div.pswp__zoom-wrap{transform: translateY(0)!important;}*/
			/*div.pswp__zoom-wrap img{width: 100%!important; height: 100%!important;}*/
			div.pswp__top-bar{bottom: 0!important; top: auto!important; left: 0.05rem; z-index: 9999; height: 0.88rem;}
			div.pswp__caption{font-size: 0.28rem;padding: 0.25rem 0.25rem 0.25rem 0.8rem; height: 0.88rem; }
			div.pswp__counter{  height: auto;font-size: 0.28rem;line-height: 0.88rem;opacity: 1;padding: 0; color: #FFFFFF;}
			div.pswp__caption__center {text-align: left;max-width: auto;width:100%; max-width: 84%; font-size: 0.28rem;padding: 0;line-height: 1.5;color: #FFFFFF; }
		</style>
		<title>我的收藏</title>
	</head>
	<body class="gray_bg">
		<!--header-->
		<div class="edit_box">
			<c:choose>
				<c:when test="${sortFlag eq 1}">
					<div class="edit_rank"><span>时间正序</span></div>	
				</c:when>
				<c:otherwise>
					<div class="edit_rank"><span>时间逆序</span></div>
				</c:otherwise>
			</c:choose>
			
			<div class="edit_text">编辑</div>
		</div>
		<!--header-->
		<!--main-->
		<main class="ts">
			<c:forEach items="${resultList}" var="item" varStatus="status">
				<div class="day_box">
					<h1 class="time">${item.createdate}
						<p class="single_all">
							<input type="checkbox" name="single${status.index }" id="single${status.index }" value=""/>
							<label for="single${status.index }"></label>
						</p>
					</h1>
					<%-- <ul class="piclist_box1">
						<c:forEach items="${item.entity}" var="entity">
							<li>
								<a href="javascript:;" onclick="doDetail('${entity.imgUid}')">
									<img class="lazy"  alt="" width="10" height="10"  data-original="downFileResult.do?urlPath=${entity.album.urlPath}" alt="" />
								</a>
								<p>${entity.album.serialNumber}</p>
								<div class="single_select">
									<input type="checkbox" name="single${status.index }" id="${entity.id}" value="${entity.album.orderList}"/><label for="${entity.id}"></label>
								</div>
							</li>
						</c:forEach>
					</ul> --%>
					<div class="piclist_box demo-gallery" data-pswp-uid="1">
				   		<c:forEach items="${item.entity}" var="entity" varStatus="status">
						   	<a href="downFileResult.do?urlPath=${entity.album.urlPath}" data-size="1600x1600" data-med="downFileResult.do?urlPath=${entity.album.urlPath}" data-med-size="1500x2412"  class="demo-gallery__img--main">
				       			<img class="lazy"   width="10" height="10"  src="downFileResult.do?urlPath=${entity.album.urlPath}" />
				       			<figure>${entity.album.description}</figure>
				       			<p>${entity.album.serialNumber}</p>
				       			<div class="single_select">
				       				<input type="checkbox" name="single${status.index }" id="${entity.id}" value="${entity.album.orderList}"/><label for="${entity.id}"></label>
				       			</div>
			       			</a>
			       		</c:forEach>
				     </div>
				     <div id="gallery" class="pswp" tabindex="-1" role="dialog" aria-hidden="true">
		       			<div class="pswp__bg"></div>
		       			<div class="pswp__scroll-wrap">
				          	<div class="pswp__container">
								<div class="pswp__item"></div>
								<div class="pswp__item"></div>
								<div class="pswp__item"></div>
				          	</div>
		         			<div class="pswp__ui pswp__ui--hidden">
		            			<div class="pswp__top-bar">
									<div class="pswp__counter"></div>
									<button class="pswp__button pswp__button--close" title="Close (Esc)"></button>
									<button class="pswp__button pswp__button--share" title="Share"></button>
									<button class="pswp__button pswp__button--fs" title="Toggle fullscreen"></button>
									<button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>
									<div class="pswp__preloader">
										<div class="pswp__preloader__icn">
								  			<div class="pswp__preloader__cut">
									    		<div class="pswp__preloader__donut"></div>
									  		</div>
										</div>
									</div>
			            		</div>
			            		<div class="pswp__caption">
			              			<div class="pswp__caption__center"></div>
			            		</div>
		          			</div>
		       			</div>
		   			</div>
				</div>
			</c:forEach>
		</main>
		<!--main-->
		<!--footer-->
		<footer>
			<div class="sc_box show_box">
				<div class="sc_operate">
					<div class="select_all">
						<input type="checkbox" name="all" id="all" value="0"/><label for="all">全选</label>
					</div>
					<div class="sc_text">收藏</div>
				</div>
			</div>
		</footer>
		<!--footer-->
	</body>
	<script src="js/wechat/rem.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/photoswipe.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/photoswipe-ui-default.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery.lazyload.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/layer.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {
			
		    //$('ul.piclist_box1 li img').css('height',$('ul.piclist_box1 li img').css('width'));
		    
			//获取列表图片高度
			$(window).on("load resize",function() {
				var w = $(".piclist_box a").width();
				$(".piclist_box a").height(w);
			});
			
			//滑动懒加载效果
			$("img.lazy").lazyload({
				effect: "fadeIn",
				failure_limit: 100
			});
			
			//点击编辑时
			$(".edit_text").on("click",
			function() {
				//$(this).parents(".edit_box").slideUp();
				$(".single_all,.single_select,.sc_box.show_box,.sc_operate").show();
				//$(".sc_box.show_box").slideDown();
			});
			
			//点击排序
			$(".edit_rank").on("click",function() {
				var sortFlag;
				if ($(this).find("span").text() == "时间正序") {	
					sortFlag = 2;
				} else {
					sortFlag = 1;
				}
				var userid='${userid}';
				if (userid!=null&&userid!="") {
				} else {
					userid="o_rsSv19Shjb9U71kWm8QmWdfh_E";
				}
				window.location.href="./toCollection.do?userid=" + userid + "&sortFlag=" + sortFlag;
				
			});
			
			//点击批量选择按钮
			$(".sc1").on("click",function() {
				$(this).hide();
				$(".sc_operate,.single_select").show();
			});
			
			//全选所有日期
			$(".select_all").on("click",function() {
				$(".single_select,.single_all").find("input[name^='single']").prop("checked", $(this).find("input").prop("checked"));
				if ($(this).find("input").prop("checked")) {
					$(".select_all label").text("取消全选");
				} else {
					$(".select_all label").text("全选");
				}
				shoucang();
			});
			
			//全选同一日期
			var len0 = $(".single_all").length;
			$(".single_all").on("click",function() {
				//console.log($(this).parent().next(".piclist_box1").find("input[name='single']").prop("checked"));
				console.log($(this).parent().next(".piclist_box").children().size());
				$(this).parent().next(".piclist_box").find("input").prop("checked", $(this).find("input").prop("checked"));
				//按日期全选时
				var len11 = $(".single_all input:checked").length;
				quanxuan(len0, len11);
				shoucang();
			});
	
			//当单选时，逐个选择了全部
			var len = $(".single_select").length;
			$(".single_select").on("click",function(e) {
				e.stopPropagation();
				var len00 = $(this).parents(".piclist_box").find("li").length;
				var len1 = $(".single_select input:checked").length;
				var len2 = $(this).parents(".piclist_box").find(".single_select input:checked").length;
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
			$(".sc_text").on("click",function() {
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
					var userid='${userid}';
					if (userid!=null&&userid!="") {
					} else {
						userid="o_rsSv19Shjb9U71kWm8QmWdfh_E";
					}
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
		
		function doDetail(id) {
			var userid='${userid}';
			if (userid!=null&&userid!="") {
			} else {
				userid="o_rsSv19Shjb9U71kWm8QmWdfh_E";
			}
			window.location.href="./toCollectionDetail.do?id=" + id + "&userid="+userid;
		}
		
		//图片放大
		 (function() {
		var initPhotoSwipeFromDOM = function(gallerySelector) {

			var parseThumbnailElements = function(el) {
			    var thumbElements = el.childNodes,
			        numNodes = thumbElements.length,
			        items = [],
			        el,
			        childElements,
			        thumbnailEl,
			        size,
			        item;

			    for(var i = 0; i < numNodes; i++) {
			        el = thumbElements[i];

			        // include only element nodes 
			        if(el.nodeType !== 1) {
			          continue;
			        }

			        childElements = el.children;
					
			        
			        
			        size = el.getAttribute('data-size').split('x');

			        // create slide object
			        item = {
						src: el.getAttribute('href'),
						w: parseInt(size[0], 10),
						h: parseInt(size[1], 10),
//						author: el.getAttribute('data-author')
			        };

			        item.el = el; // save link to element for getThumbBoundsFn

			        if(childElements.length > 0) {
			          item.msrc = childElements[0].getAttribute('src'); // thumbnail url
			          if(childElements.length > 1) {
			              item.title = childElements[1].innerHTML; // caption (contents of figure)
			          }
			        }

					var mediumSrc = el.getAttribute('data-med');
		          	if(mediumSrc) {
		            	size = el.getAttribute('data-med-size').split('x');
		            	// "medium-sized" image
		            	item.m = {
		              		src: mediumSrc,
		              		w: parseInt(size[0], 10),
		              		h: parseInt(size[1], 10)
		            	};
		          	}
		          	// original image
		          	item.o = {
		          		src: item.src,
		          		w: item.w,
		          		h: item.h
		          	};

			        items.push(item);
			    }

			    return items;
			};

			// find nearest parent element
			var closest = function closest(el, fn) {
			    return el && ( fn(el) ? el : closest(el.parentNode, fn) );
			};

			var onThumbnailsClick = function(e) {
			    e = e || window.event;
			    e.preventDefault ? e.preventDefault() : e.returnValue = false;

			    var eTarget = e.target || e.srcElement;

			    var clickedListItem = closest(eTarget, function(el) {
			        return el.tagName === 'A';
			    });

			    if(!clickedListItem) {
			        return;
			    }

			    var clickedGallery = clickedListItem.parentNode;

			    var childNodes = clickedListItem.parentNode.childNodes,
			        numChildNodes = childNodes.length,
			        nodeIndex = 0,
			        index;

			    for (var i = 0; i < numChildNodes; i++) {
			        if(childNodes[i].nodeType !== 1) { 
			            continue; 
			        }

			        if(childNodes[i] === clickedListItem) {
			            index = nodeIndex;
			            break;
			        }
			        nodeIndex++;
			    }

			    if(index >= 0) {
			        openPhotoSwipe( index, clickedGallery );
			    }
			    return false;
			};

			var photoswipeParseHash = function() {
				var hash = window.location.hash.substring(1),
			    params = {};

			    if(hash.length < 5) { // pid=1
			        return params;
			    }

			    var vars = hash.split('&');
			    for (var i = 0; i < vars.length; i++) {
			        if(!vars[i]) {
			            continue;
			        }
			        var pair = vars[i].split('=');  
			        if(pair.length < 2) {
			            continue;
			        }           
			        params[pair[0]] = pair[1];
			    }

			    if(params.gid) {
			    	params.gid = parseInt(params.gid, 10);
			    }

			    return params;
			};

			var openPhotoSwipe = function(index, galleryElement, disableAnimation, fromURL) {
			    var pswpElement = document.querySelectorAll('.pswp')[0],
			        gallery,
			        options,
			        items;

				items = parseThumbnailElements(galleryElement);

			    // define options (if needed)
			    options = {

			        galleryUID: galleryElement.getAttribute('data-pswp-uid'),

			        getThumbBoundsFn: function(index) {
			            // See Options->getThumbBoundsFn section of docs for more info
			            var thumbnail = items[index].el.children[0],
			                pageYScroll = window.pageYOffset || document.documentElement.scrollTop,
			                rect = thumbnail.getBoundingClientRect(); 

			            return {x:rect.left, y:rect.top + pageYScroll, w:rect.width};
			        },

			        addCaptionHTMLFn: function(item, captionEl, isFake) {
						if(!item.title) {
							captionEl.children[0].innerText = '';
							return false;
						}
						captionEl.children[0].innerHTML = item.title;
						return true;
			        },
					
			    };

			    if(fromURL) {
			    	if(options.galleryPIDs) {
			    		// parse real index when custom PIDs are used 
			    		// http://photoswipe.com/documentation/faq.html#custom-pid-in-url
			    		for(var j = 0; j < items.length; j++) {
			    			if(items[j].pid == index) {
			    				options.index = j;
			    				break;
			    			}
			    		}
				    } else {
				    	options.index = parseInt(index, 10) - 1;
				    }
			    } else {
			    	options.index = parseInt(index, 10);
			    }

			    // exit if index not found
			    if( isNaN(options.index) ) {
			    	return;
			    }

              options.mainClass = 'pswp--minimal--dark';
					        options.barsSize = {top:0,bottom:0};
							options.captionEl = true;
							options.fullscreenEl = true;
							options.shareEl = false;
							options.bgOpacity = 0.95;
							options.tapToClose = true;
							options.tapToToggleControls = false;


			    if(disableAnimation) {
			        options.showAnimationDuration = 0;
			    }

			    // Pass data to PhotoSwipe and initialize it
			    gallery = new PhotoSwipe( pswpElement, PhotoSwipeUI_Default, items, options);

			    // see: http://photoswipe.com/documentation/responsive-images.html
				var realViewportWidth,
				    useLargeImages = false,
				    firstResize = true,
				    imageSrcWillChange;

				gallery.listen('beforeResize', function() {

					var dpiRatio = window.devicePixelRatio ? window.devicePixelRatio : 1;
					dpiRatio = Math.min(dpiRatio, 2.5);
				    realViewportWidth = gallery.viewportSize.x * dpiRatio;


				    if(realViewportWidth >= 1200 || (!gallery.likelyTouchDevice && realViewportWidth > 800) || screen.width > 1200 ) {
				    	if(!useLargeImages) {
				    		useLargeImages = true;
				        	imageSrcWillChange = true;
				    	}
				        
				    } else {
				    	if(useLargeImages) {
				    		useLargeImages = false;
				        	imageSrcWillChange = true;
				    	}
				    }

				    if(imageSrcWillChange && !firstResize) {
				        gallery.invalidateCurrItems();
				    }

				    if(firstResize) {
				        firstResize = false;
				    }

				    imageSrcWillChange = false;

				});

				gallery.listen('gettingData', function(index, item) {
				    if( useLargeImages ) {
				        item.src = item.o.src;
				        item.w = item.o.w;
				        item.h = item.o.h;
				    } else {
				        item.src = item.m.src;
				        item.w = item.m.w;
				        item.h = item.m.h;
				    }
				});

			    gallery.init();
			};

			// select all gallery elements
			var galleryElements = document.querySelectorAll( gallerySelector );
			for(var i = 0, l = galleryElements.length; i < l; i++) {
				galleryElements[i].setAttribute('data-pswp-uid', i+1);
				galleryElements[i].onclick = onThumbnailsClick;
			}

			// Parse URL and open gallery if it contains #&pid=3&gid=1
			var hashData = photoswipeParseHash();
			if(hashData.pid && hashData.gid) {
				openPhotoSwipe( hashData.pid,  galleryElements[ hashData.gid - 1 ], true, true );
			}
		};

		initPhotoSwipeFromDOM('.demo-gallery');

	})();
	</script>
</html>
