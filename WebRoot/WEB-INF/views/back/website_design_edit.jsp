<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>天雅设计管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>
<script type="text/javascript" src="js/system/keditor.js"></script>
<style type="text/css">
*{margin:0; padding:0;list-style: none}
#ul1{width:100%;position:relative;margin:10px auto;}
#ul1 li{width:150px;height:150px;float:left;margin:10px;-moz-border-radius:25px;border-radius:25px;}
#ul1 li:hover{border-color:#9a9fa4; box-shadow:0 0 6px 0 rgba(0, 0, 0, 0.85);}
#ul1 .active{border:1px dashed red;}
#ul1 li img{-moz-border-radius:25px;border-radius:25px;}
.sc{
	position: absolute;
	right: 0px;
	top: 0px;
}
.imgdiv{
	width: 150px;
	height: 150px;
	position: relative;
}	
</style>

<script type="text/javascript">
	
var basePath = "<%=basePath%>";
var editor;
KindEditor.ready(function(K) {
	editor = K.create('#descriptionLabel', {
		width : '100%',
		height:'339px',
		cssPath : '../js/kingeditor/plugins/code/prettify.css',
		uploadJson : basePath + 'keUpload.do?model=website_design_content',
		fileManagerJson : 'jsp/file_manager_json.jsp',
		allowFileManager : true,
		items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
    'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
    'anchor', 'link', 'unlink', 'media'],
		afterChange : function() {
			this.sync();// 这个是必须的,如果你要覆盖afterChange事件的话,请记得最好把这句加上.
		},
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['fm'].submit();
			});
			K.ctrl(self.edit.doc, 13, function() {
				self.sync();
				document.forms['fm'].submit();
			});
		}
	});
	prettyPrint();
});

function save(){
  $('#fm').form('submit', {
	onSubmit: function() {
	      if(!validation()){
	    	 return false;
	      }
	    },  
    dataType: 'json',
    success: function(result) {
      var result = eval('(' + result + ')');
      layer.close(index);
      if (result.success) {
        location.href = basePath + "system/websiteDesignTList.do";
      } else {
        $.messager.alert('错误信息', result.msg, 'error');
        return false;
      }
    }
  });
}

function validation(){
	var rr = $('#fm').form('enableValidation').form('validate');
    if (rr) {
    	index = layer.load('操作中...请等待！', 0);
    } else {
        return false;
    }
    return true;
}
</script>
</head>
<body>
	<form id="fm" name="fm" method="post" action="system/configInfoAjaxSave.do">
		<input type="hidden" name="configKey" id="configKeyLabel" value="website_design_content"/>
		<input type="hidden" name="id" id="idLabel" value="${configInfo.id }"/>
		<div class="easyui-panel" title="内容介绍" style="width:100%;height:400px;padding:10px;" data-options="iconCls:'icon-filter',closable:false,tools:'#two'">
			<textarea id="descriptionLabel" name="configValue" style="width:100%;height:145px;">${configInfo.configValue }</textarea>
		</div>
    	<div id="two">
        	<a href="javascript:void(0)" class="icon-save" onclick="javascript:save()" title="保存"></a>
    	</div>
	</form>
</body>
</html>
