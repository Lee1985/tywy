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
	
	var ajaxOptions = {
	 url: 'contactInfo.do',
	 type: 'post',
	 dataType: 'json',
	 success: function(data) {
		$('#qqLi').data('qqvalue',data.qqValue);
		$('div.tels span').text(data.telValue);
	 }
	};
	$.ajax(ajaxOptions);
	
	$('#qqLi').click(function(){
		window.open('http://wpa.qq.com/msgrd?v=3&uin='+$(this).data('qqvalue')+'&site=qq&menu=yes', '_blank', 'height=502, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');
	});
});