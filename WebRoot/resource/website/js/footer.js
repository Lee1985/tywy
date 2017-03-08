$(function(){
	//footer 地址切换
	$(".address_title span").on("click",function(){
		var indexs=$(this).index();
		$(this).parents(".address").css("background","url(resource/website/img/location"+indexs+".png)")
		$(this).addClass("selected").siblings().removeClass("selected");
		$(".address_detail").eq(indexs).show().siblings(".address_detail").hide();
	});
	
	var ajaxOptions = {
	 url: 'netInfo.do',
	 type: 'post',
	 dataType: 'json',
	 success: function(data) {
		 console.log(data);
	 }
	};
	$.ajax(ajaxOptions);
});