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

<title>联系我们管理</title>

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

</script>
</head>
<body>
	<form id="fm" name="fm" method="post" action="system/websiteContactAjaxSaveSettings.do">
		<input type="hidden" name="configKey" id="configKeyLabel" value="website_design_content"/>
		<input type="hidden" name="id" id="idLabel" value="${configInfo.id }"/>
		<div class="easyui-panel" title="通用设置" style="width:100%;height:400px;padding:10px;" data-options="iconCls:'icon-filter',closable:false,tools:'#two'">
			<div class="fitem">
				<div style="float: left;margin-top: 25px;"><font color="red">*</font>导航图片:</div>
				<div id="showImage" class="showImage" style="width:160px;height:90px;border:1px solid;margin-left:70px;cursor:pointer;text-align:center;" >
					<c:choose>
						<c:when test="${empty imageValue }">
							<img id="addImg" class="addImg" src="images/add.png" style="width:50px;height:50px;padding-top: 20px;"/>
							<img id="imgShow" class="imgShow" src="" style="display:none;width:100%;height:100%;"/>
						</c:when>
						<c:otherwise>
							<img id="addImg" class="addImg" src="images/add.png" style="width:50px;height:50px;padding-top: 20px;display: none;"/>
							<img id="imgShow" class="imgShow" src="downFileResult.do?urlPath=${imageValue}" style="width:100%;height:100%;"/>
						</c:otherwise>
					</c:choose>
				</div>
				<div style="width:160px;margin-left:70px;text-align:center;" >建议比例(16:9)</div>
				<input type="hidden" id="operType" name="operType">
			</div>
			
			<div class="fitem">
				<label><font color="red">*</font>在线QQ:</label>
				<input id="qqValueLabel" name="qqValue" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'" value="${qqValue }" />
			</div>
			
			<div class="fitem">
				<label><font color="red">*</font>联系电话:</label>
				<input id="telValueLabel" name="telValue" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'" value="${telValue }" />
			</div>
			
			<div class="fitem">
				<label>描述内容:</label><textarea id="descriptionLabel" name="contentValue" style="width:100%;height:145px;">${contentValue }</textarea></textarea>
			</div>
		</div>
    	<div id="two">
        	<a href="javascript:void(0)" class="icon-save" onclick="javascript:uploadAndSaveSettings()" title="保存"></a>
    	</div>
	</form>
	
	<script type="text/javascript" src="js/stream/js/stream-v1.js"></script>
	<script type="text/javascript" src="js/stream/js/stream-upload-util.js"></script>
	<script type="text/javascript">
	var stream = singleCommonUpload('website_design_nav',function(file){
	      var inputs = ''; 
		  for(var prop in file){
			  var value = file[prop];
			  if(prop == 'id'){
				  continue;
			  }
			  if($('input[name="' + prop + '"]').size() <= 0){
				  inputs += '<input type="hidden" id="'+prop+'" name="'+prop+'" value="'+value+'" />';
			  }else{
				  $('input[name="' + prop + '"]').remove();
				  inputs += '<input type="hidden" id="'+prop+'" name="'+prop+'" value="'+value+'" />';
			  }
		  }
		  $('#fm').append(inputs);
		  saveSettings();	
	});
	
	function uploadAndSaveSettings(){
		var operType = $('#operType').val();
		if(operType == ''){
			//不上传图片,直接进行操作
			if(!settingValidation()){
				return false;
			}
			saveSettings();
			return false;	
		}
		if(!settingValidation()){
			return false;
		}
		stream.upload();
	}
	
	function saveSettings(){
	  $('#fm').form('submit', {
	    dataType: 'json',
	    success: function(result) {
	      var result = eval('(' + result + ')');
	      layer.close(index);
	      if (result.success) {
	    	  location.href = basePath + "system/websiteContactInfo.do";
	      } else {
	        $.messager.alert('错误信息', result.msg, 'error');
	        return false;
	      }
	    }
	  });
	}
	
	function settingValidation(){
		var src = $('#imgShow').attr('src');
		if (src == '') {
	        $.messager.alert('错误信息', '请上传图片!', 'error');
	        return false;
	    }
		var rr = $('#fm').form('enableValidation').form('validate');
	    if (rr) {
	    	index = layer.load('操作中...请等待！', 0);
	    } else {
	        return false;
	    }
	    return true;
	}
	</script>
</body>
</html>
