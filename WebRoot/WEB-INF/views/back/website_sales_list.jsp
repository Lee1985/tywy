<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>销售网络</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>
<script type="text/javascript" src="js/system/keditor.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=IAN0wgv9qiTllV6NWon2GgLvheuBuKUQ&s=1" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<script>
	var basePath = "<%=basePath%>";
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('#contentHtml', {
			width : '750px',
			height:'300px',
			cssPath : '../js/kingeditor/plugins/code/prettify.css',
			//uploadJson : 'jsp/upload_json.jsp',
			uploadJson : basePath + 'keUpload.do?model=website_case_content',
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
					document.forms['settingsFm'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['settingsFm'].submit();
				});
			}
		});
		prettyPrint();
	});
	
</script>
<script type="text/javascript">
	$(function() {
	  $('#addBtn').click(function(){
		  doAdd(function(){
			  $('#statusLabel').combobox('select', 1);
			  $('#categoryIdLabel').combobox({
			    url:'system/comboCategoryByCode.do?code=district',
			    valueField:'id',
			    textField:'categoryName',
			    onLoadSuccess:function(){
					var data = $('#categoryIdLabel').combobox('getData');
					if(data!=''){
						var id = data[0].id;
						$('#categoryIdLabel').combobox('select','');
					}
				}
			  });
		  });
	  });
	  
	  $('#hqBtn').click(function(){
		  $('#hq_dlg').dialog('open').dialog('setTitle', '总部设置');
	  });
	  
	  $('#editBtn').click(function(){
		  $('#categoryIdLabel').combobox({
		    url:'system/comboCategoryByCode.do?code=district',
		    valueField:'id',
		    textField:'categoryName'
		  });
		  doEdit();
	  });
	  
	  $('#deleteBtn').click(function(){
		  doDelete('system/websiteSalesTAjaxDelete.do');
	  });
	  
	  $('#lockOpenBtn').click(function(){
		  doUpdateStatus('system/websiteSalesTAjaxUpdate.do',1);
	  });
	  
	  $('#lockBtn').click(function(){
		  doUpdateStatus('system/websiteSalesTAjaxUpdate.do',0);
	  });
	  
	  $('#mapBtn').click(function(){
			location.href = "system/websiteSalesMap.do";
	  });
	  
	  $('#settingsBtn').click(function(){
		  $('#settings_dlg').dialog('open').dialog('setTitle', '设置');
	  });
	  
	});
	
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
	}
	
</script>
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
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'system/websiteSalesTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th width="10%" data-options="field:'categoryName',align:'left',sortable:true">类别</th>
					<th width="15%" data-options="field:'company',align:'left',sortable:true">公司名称</th>					
					<th width="5%" data-options="field:'contact',align:'center',sortable:true">负责人</th>
					<th width="15%" data-options="field:'mobile',align:'center',sortable:true">手机号</th>
					<th width="10%" data-options="field:'email',align:'center',sortable:true">邮箱</th>
					<th width="20%" data-options="field:'adress',align:'center',sortable:true">地址</th>
					<th width="15%" data-options="field:'fax',align:'center',sortable:true">传真</th>
					<th width="5%" data-options="field:'status',align:'center',sortable:true,formatter:formatStatus">状态</th>
					
				</tr>
			</thead>
		</table>
		<div id="dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post" action="system/websiteSalesTAjaxSave.do">
				<div class="fitem">
					<label><font color="red">*</font>公司名称:</label>
					<input id="company" name="company" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>
					<input type="hidden" id="idLabel" name="id" />
					<input type="hidden" id="longitudeLabel" name="longitude" />
					<input type="hidden" id="latitudeLabel" name="latitude" />
				</div>
				<div class="fitem">
					<label><font color="red">*</font>所在城市:</label>
					<input id="areaLabel" name="area" style="width: 100px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>市
				</div>
				<div class="fitem">
					<label>类别:</label>
					<select id="categoryIdLabel" name="categoryId" class="easyui-combobox" style="width:100px;" 
						data-options="panelHeight:'auto',editable:false">
					</select>
				</div>
				<div class="fitem">
					<label>负责人:</label>
					<input id="contactLabel" name="contact" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>手机号:</label>
					<input id="mobileLabel" name="mobile" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>邮箱:</label>
					<input id="emailLabel" name="email" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>地址:</label>
					<input id="adressLabel" name="adress" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>传真:</label>
					<input id="faxLabel" name="fax" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>状态:</label>
					<select id="statusLabel" name="status" class="easyui-combobox" style="width:100px;" data-options="panelHeight:'auto',editable:false">
						<option value="1" selected="selected">启用</option>
						<option value="0">禁用</option>
					</select>
				</div>
			</form>
		</div>
		<div id="toolbar">
			<div>				
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="addBtn">添加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="editBtn">编辑</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="deleteBtn">删除</a>	
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true" id="lockOpenBtn">启用</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lockBtn">禁用</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="mapBtn">生成地图</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-settings" plain="true" id="settingsBtn">通用设置</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-hq" plain="true" id="hqBtn">总部设置</a>
			</div>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="getPointAndSave()" style="width:90px">确定</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		</div>
		
		<div id="settings_dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:100%;height:100%;padding:10px 20px" closed="true"
			buttons="#settings_dlg-buttons">
			
			<div class="ftitle">请完善以下信息！</div>
			<form id="settingsFm" name="settingsFm" method="post" action="system/websiteSalesTAjaxSaveSettings.do">
				<div class="fitem">
					<div style="float: left;margin-top: 25px;">导航图:</div>
					<div id="showImage" class="showImage" style="width:160px;height:90px;border:1px solid;margin-left:70px;cursor:pointer;text-align:center;" >
						<c:choose>
							<c:when test="${empty configImageInfo}">
								<img id="addImg" class="addImg" src="images/add.png" style="width:50px;height:50px;padding-top: 20px;"/>
								<img id="imgShow" class="imgShow" src="" style="display:none;width:100%;height:100%;"/>
							</c:when>
							<c:otherwise>
								<img id="addImg" class="addImg" src="images/add.png" style="display:none;width:50px;height:50px;padding-top: 20px;"/>
								<img id="imgShow" class="imgShow" src="downFileResult.do?urlPath=${configImageInfo.configValue}" style="width:100%;height:100%;"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div style="width:160px;margin-left:70px;text-align:center;" >建议比例(16:9)</div>
					<input type="file" id="up_img" name="uploadFile" style="display: none;"/>
					<input type="hidden" id="idLabel1" name="id1" />
					<input type="hidden" id="imgUuidLabel" name="imgUuid">
					<input type="hidden" id="operType" name="operType">
				</div>
				
				<div class="fitem">
					<label>描述内容:</label> <textarea id="contentHtml" name="configValue">${configInfo.configValue}</textarea>
				</div>
			</form>
		</div>
		<div id="settings_dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="uploadAndSaveSettings()" style="width:90px">确定</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#settings_dlg').dialog('close')" style="width:90px">取消</a>
		</div>
		
		<div id="hq_dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;padding:10px 20px" closed="true"
			buttons="#hq_dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="hqFm" name="hqFm" method="post" action="system/websiteSalesTAjaxSave.do">
				<div class="fitem">
					<label><font color="red">*</font>公司名称:</label>
					<input id="company" name="company" value="${hqInfo.company}" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>
					<input type="hidden" id="idLabel" name="id" value="${hqInfo.id }" />
					<input type="hidden" id="longitudeLabel" name="longitude" />
					<input type="hidden" id="latitudeLabel" name="latitude" />
					<input type="hidden" id="isHq" name="isHq" value="1" />
				</div>
				<div class="fitem">
					<label><font color="red">*</font>所在城市:</label>
					<input id="areaLabel" name="area" style="width: 100px" class="easyui-textbox" value="${hqInfo.area }" data-options="required:true,validType:'length[1,15]'"/>市
				</div>
				<div class="fitem">
					<label>负责人:</label>
					<input id="contactLabel" name="contact" style="width: 200px" value="${hqInfo.contact }" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>手机号:</label>
					<input id="mobileLabel" name="mobile" value="${hqInfo.mobile }" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>邮箱:</label>
					<input id="emailLabel" name="email" value="${hqInfo.email }" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>地址:</label>
					<input id="adressLabel" name="adress" value="${hqInfo.adress }" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>传真:</label>
					<input id="faxLabel" name="fax" value="${hqInfo.fax }" style="width: 200px" class="easyui-textbox"/>
				</div>
			</form>
		</div>
		<div id="hq_dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="getPointAndSaveHq()" style="width:90px">确定</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#hq_dlg').dialog('close')" style="width:90px">取消</a>
		</div>
	</div>
	<script type="text/javascript" src="js/stream/js/stream-v1.js"></script>
	<script type="text/javascript" src="js/stream/js/stream-upload-util.js"></script>
	<script type="text/javascript">
	 	var index;		
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
		        $('#dlg').dialog('close'); // close the dialog
		        $('#dg').datagrid('reload'); // reload the menu data
		      } else {
		        $.messager.alert('错误信息', result.msg, 'error');
		        return false;
		      }
		    }
		  });
		}
		
		function getPointAndSave(){
			var myGeo = new BMap.Geocoder();
			var cityName = $('#areaLabel').val();
   			myGeo.getPoint(cityName, function(point){
   				if (point) {	   					
   					$('#longitudeLabel').val(point.lng);
   					$('#latitudeLabel').val(point.lat);
   					save();
   				}else{
   					$.messager.alert('错误信息', '您填写的所在城市没有解析到坐标!', 'error');
   					return false;
   				}
   			}, cityName);
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
		
		var stream = singleCommonUpload('website_sales_nav',function(file){
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
			  $('#settingsFm').append(inputs);
			  saveSettings();
		},null,'settingsFm');
		
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
		  $('#settingsFm').form('submit', {
		    dataType: 'json',
		    success: function(result) {
		    	console.log(result);
		      var result = eval('(' + result + ')');
		      layer.close(index);
		      if (result.success) {
		        $('#settings_dlg').dialog('close'); // close the dialog
		        $('#dg').datagrid('reload'); // reload the menu data
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
			var rr = $('#settingsFm').form('enableValidation').form('validate');
		    if (rr) {
		    	index = layer.load('操作中...请等待！', 0);
		    } else {
		        return false;
		    }
		    return true;
		}
		
		function saveHq(){
		  $('#hqFm').form('submit', {
		    dataType: 'json',
		    success: function(result) {
		      var result = eval('(' + result + ')');
		      layer.close(index);
		      if (result.success) {
		        $('#hq_dlg').dialog('close'); // close the dialog
		        $('#dg').datagrid('reload'); // reload the menu data
		      } else {
		        $.messager.alert('错误信息', result.msg, 'error');
		        return false;
		      }
		    }
		  });
		}
		
		function getPointAndSaveHq(){
			var myGeo = new BMap.Geocoder();
			var cityName = $('#hqFm').find('#areaLabel').val();
   			myGeo.getPoint(cityName, function(point){
   				if (point) {	   					
   					$('#hqFm').find('#longitudeLabel').val(point.lng);
   					$('#hqFm').find('#latitudeLabel').val(point.lat);
   					saveHq();
   				}else{
   					$.messager.alert('错误信息', '您填写的所在城市没有解析到坐标!', 'error');
   					return false;
   				}
   			}, cityName);
		}
	</script>
</body>
</html>
