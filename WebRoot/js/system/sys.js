var setting = {
	data : {
		simpleData : {
			enable : false
		}
	},
	callback : {
		onClick : onClick
	}
};
function onClick(event, treeId, treeNode) {
	if (typeof (treeNode.menuUrl)) {
		if (treeNode.menuUrl != "") {
			// $("#tt").tabs("close",treeNode.name);
			var tabs = $("#tt").tabs("tabs");
			if (tabs) {
				for (var i = 0, length = tabs.length; i < length; i++) {
					$("#tt").tabs('close', 0);
				}
			}
			$("#tt")
					.tabs(
							'add',
							{
								title : treeNode.name,
								width : "100%",
								height : "600px",
								content : '<iframe title="content" frameborder="0" height="100%"'
										+ 'width="100%" allowTransparency="true" align="center"'
										+ 'src='
										+ treeNode.menuUrl
										+ '></iframe>',
								closable : false
							});
		}
	}
}
$(document).ready(function() {
	$.ajax({
		type : "POST",
		dataType : "JSON",
		url : "./system/initSystemMenuTree.do",
		success : function(data) {
			// var z=jQuery.parseJSON(data);alert(data);
			$.fn.zTree.init($("#tree"), setting, data);
			zTree = $.fn.zTree.getZTreeObj("tree");
		}
	});
});
