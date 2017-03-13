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
		<link rel="stylesheet" type="text/css" href="css/wechat/photoswipe.css"/>
		<link rel="stylesheet" type="text/css" href="css/wechat/default-skin.css"/>
 		<link rel="stylesheet" type="text/css" href="js/wechat/need/layer.css"/>
		<title>${title}</title>
		<style type="text/css">
			main{overflow: auto;-webkit-overflow-scrolling: touch;}
			div.piclist_box{overflow: auto;width: 92%; padding: 4% 0; margin-left: 4%; margin-right: 4%;  margin-bottom: 1.1rem;}
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
			div.pswp__caption__center {text-align: left;max-width: auto;width:100%; max-width: 100%; font-size: 0.28rem;padding: 0;line-height: 1.5;color: #FFFFFF; }
		</style>
	</head>
	<body class="gray_bg">
		<main>	
		   <div class="piclist_box demo-gallery" data-pswp-uid="1">
		   		<c:forEach items="${albums}" var="item" varStatus="status">
				   	<a href="downFileResult.do?urlPath=${item.systemPictureInfo.urlPath}" data-size="1600x1600" data-med="downFileResult.do?urlPath=${item.systemPictureInfo.urlPath}" data-med-size="1500x2412"  class="demo-gallery__img--main">
		       			<img class="lazy"   width="10" height="10"  src="downFileResult.do?urlPath=${item.systemPictureInfo.urlPath}" />
		       			<figure>${item.description}</figure>
		       			<p>${item.serialNumber}</p>
		       			<div class="single_select">
		       				<input type="checkbox" name="single" id="${item.id}" value="${item.id}"/><label for="${item.id}"></label>
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
   		</main>
		<!--main-->
		<div class="sc_share">
			<div class="scang"></div>
			<div class="share"></div>
		</div>
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
	<script src="js/wechat/photoswipe.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/photoswipe-ui-default.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/jquery.lazyload.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/wechat/layer.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$(function() {
		  //获取列表图片高度
		  $(window).on("load resize",
		  function() {  
		    var w = $(".piclist_box a").width();
		    $(".piclist_box a").height(w);
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
		    //禁用分页
		    $('main').css('overflow','scroll');
		  });
		  //全选
		  $(".select_all").on("click",
		  function() {
		    $(".single_select").find("input[name='single']").prop("checked", $(this).find("input").prop("checked"));
		    if ($(this).find("input").prop("checked")) {
		      $(".select_all label").text("取消全选");
		    } else {
		      $(".select_all label").text("全选");
		    }
		  });
		  //当单选时，选择的全部
		  var len = $(".single_select").length;
		  $(".single_select").on("click",
		  function(e) {
			e.stopPropagation();
		    var len1 = $(".single_select input:checked").length;
		    if (len == len1) {
		      $(".select_all input").prop("checked", true);
		      $(".select_all label").text("取消全选");
		    } else {
		      $(".select_all input").prop("checked", false);
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
		});
		
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
		       				var str = '<a href="downFileResult.do?urlPath='+item.systemPictureInfo.urlPath+'" data-size="1600x1600" data-med="downFileResult.do?urlPath='+item.systemPictureInfo.urlPath+'" data-med-size="1500x2412"  class="demo-gallery__img--main">';
		       				    str += '<img class="lazy"   width="10" height="10"  src="downFileResult.do?urlPath='+item.systemPictureInfo.urlPath+'" />';
		       				    str += '<figure>'+item.description+'</figure><p>'+item.serialNumber+'</p>';		
		       					str	+= '<div class="single_select">';
		       					str	+= '<input type="checkbox" name="single" id="'+item.id+'" value="'+item.id+'"/><label for="'+item.id+'"></label></div></a>';
		       				$(".piclist_box").append(str);
						}
					});
					 var w = $(".piclist_box a").width();
					 $(".piclist_box a").height(w);
				},'json');
		    }
		  }
		  $("main").on('scroll',throttle(scroll,100,500));
		});
		
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
