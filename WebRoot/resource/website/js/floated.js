$(function(){
	//悬浮层
	$(".items li").each(function(){
		$(this).mouseenter(function(){
			$(this).addClass("selected").siblings().removeClass("selected");
				$(this).find(".wx_box").show();
		});
		$(this).mouseleave(function(){
			$(".items li").removeClass("selected");
			$(this).find(".wx_box").hide();
		});
		
	});
	
	$('#qqLi').click(function(){
		//window.open('http://wpa.qq.com/msgrd?v=3&uin=147903469&site=qq&menu=yes', '_blank', 'height=502, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');
		//新闻
		var ajaxOptions = {
		 url: 'qqServer.do',
		 type: 'post',
		 dataType: 'json',
		 success: function(data) {
			 window.open('http://wpa.qq.com/msgrd?v=3&uin='+data.qqValue+'&site=qq&menu=yes', '_blank', 'height=502, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');
		 }
		};
		$.ajax(ajaxOptions);
	});
});