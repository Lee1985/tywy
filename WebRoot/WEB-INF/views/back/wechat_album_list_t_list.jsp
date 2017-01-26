<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>微信专区照片管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>

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
	width: 60px;
}

.fitem input {
	width: 200px;
}
</style>

<script type="text/javascript">
	function formatImg(value, row) {
		return "<img src="+ row.urlPath +" style=\"height:50px;background-color:#434343\"/>";
	}
	function save() {
		var src = $("#headImgs").attr('src');
		if( src == ''){
			$.messager.show({
				title : '提示',
				msg : '请上传图片'
			});
			return false;
		}
		var index;
		$('#fm').form('submit', {
			onSubmit : function() {
				var rr = $(this).form('enableValidation').form('validate');
				if (rr) {
					index = layer.load('操作中...请等待！', 0);
				} else {
					return false;
				}
			},
			dataType : 'json',
			success : function(result) {
				var result = eval('(' + result + ')');
				layer.close(index);
				if (result.success) {
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
				} else {
					$.messager.show({
						title : '提示',
						msg : result.msg
					});
				}
			}
		});
	}
	function doEdit() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '修改');
			$('#fm').form('load', row);
			var headUrl = row.urlPath;
			if (headUrl == '' || headUrl == null || headUrl == undefined) {
				$('#headImgs').attr('src','images/add.jpg');
			} else {
				$("#headImgs").attr("src", headUrl);
			}
		}
	}
	function onChange(fileObj) {
		var r = isimg(fileObj.value);
		if(!r){
			$.messager.show({
				title : '提示',
				msg : '图片格式不正确'
			});
			fileObj.value = "";
			return ;
		}
		var reader = new FileReader();
		reader.readAsDataURL(fileObj.files[0]);
		reader.onload = function(e) {
			$("#headImgs").attr("src", e.target.result);
		};
	}
	function isDeleteStyler(value,row,index){
		if (value ==1){
			return 'background-color:#ccc;color:red;';
		}
	}
	function formatIsDelete(value, row) {
		var view = (value == 1) ? '是' : '否';
		return view;
	}
	function searchData() {
		$('#dg').datagrid('load', {
			serialNumber : Trim($('#_serialNumber').val())
		});
	}
	function Trim(str){ 
		return str.replace(/(^\s*)|(\s*$)/g, ""); 
	}
</script>
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'wechatAlbumListTAjaxPage.do?parentid=${id}', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar'">
			<thead>
				<tr>
					<th data-options="field:'imgUuid',width:60,align:'left',sortable:true,formatter:formatImg">照片</th>
					<th data-options="field:'serialNumber',width:200,align:'center',sortable:true">照片编号</th>
					<th data-options="field:'description',width:200,align:'center',sortable:true">照片描述</th>
					<th data-options="field:'updateDate',width:200,align:'center',sortable:true">更新时间</th>
					<th data-options="field:'isDelete',width:80,align:'center',sortable:true,styler:isDeleteStyler,formatter:formatIsDelete">是否删除</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<div>
				照片编号: <input id="_serialNumber" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp; 
				 <a href="javaScript:void()" onclick="searchData()" class="easyui-linkbutton" plain="true"
				 	data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
			</div>
			<div style="margin-bottom:5px;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit',plain:true" onclick="doEdit()">编辑相册</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="">上传照片</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="">批量删除</a>
			</div>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog"
		data-options="iconCls:'icon-save',resizable:true,modal:true"
		style="width:400px;height:500px;padding:10px 20px;" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">请完善以下信息！</div>
		<form id="fm" name="fm" method="post"
			action="wechatAlbumListTAjaxSave.do"
			data-options="novalidate:true" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id">
			<div class="fitem" style="float: left;">
				<label>照片(建议800*400)</label> <img id="headImgs" alt="" src=""
					style="width: 200px;height: 100px" onclick="headImg.click()">
				<label>&nbsp;</label> <input type="file" id="headImg"
					name="headImg" style="width:200px;display: none"
					onChange="onChange(this)"
					data-options="prompt:'选择图片...',required:true">
			</div>
			<div class="fitem">
				<label>照片编号:</label> <input id="serialNumber" name="serialNumber"
					class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem" style="float: left;">
				<label>描述:</label> <input id="description" name="description"
					class="easyui-textbox" style="height:200px;width: 200"
					data-options="prompt:'描述信息',multiline:true,required:false,validType:'length[0,2000]'">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			data-options="iconCls:'icon-ok'" onclick="save()" style="width:90px">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'"
			onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>
