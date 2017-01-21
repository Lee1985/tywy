$(function(){
			$("#footer a").click(function(){
				$(this).addClass("gray").siblings().removeClass("gray");
			})
});