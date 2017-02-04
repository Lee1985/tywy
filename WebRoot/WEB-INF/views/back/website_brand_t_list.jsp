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

<title>微信电子相册管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>

<script type="text/javascript">
	function searchData() {
		$('#dg').datagrid('load', {
			brandName : Trim($('#name').val())
		});
	}
	function Trim(str){ 
		return str.replace(/(^\s*)|(\s*$)/g, ""); 
	}
	
	function formatImg(value, row) {
		return "<img src="+ row.headimgurl +" style=\"height:50px;background-color:#434343\"/>";
	}
	
	function formatCity(value, row) {
		return row.country+row.province+row.city;
	}
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
	}
	function formatSex(value, row) {    
	    if (value == 1) {
			return "男";
		} else if (value == 2) {
			return "女";
		} else {
			return "未知";
		}
	}
	
	function doUpdateStatus(url,status) {
		var row = $('#dg').datagrid('getSelected');
		var msg="";
		if (row) {
			if (status==1) {
				msg="启用";
				if (row.status==1) {
					$.messager.show({ // show error message
						title : '提示',
						msg : '已启用！'
					});
					return;
				}
			}
			if (status==0) {
				msg="禁用";
				if (row.status==0) {
					$.messager.show({ // show error message
						title : '提示',
						msg : '已禁用！'
					});
					return;
				}
			}
			$.messager.confirm('确认操作', '你确定要'+msg+'吗?', function(r) {
				if (r) {
					$.post(url, {
						id : row.id,
						status : status
					}, function(result) {
						if (result.success) {
							$('#dg').datagrid('reload'); // reload the user data
						} else {
							$.messager.show({ // show error message
								title : '提示',
								msg : result.msg
							});
						}
					}, 'json');
				}
			});
		}
	}
</script>
</head>

<body>
	<div style="width:100%;height:100%">
		<table id="dg" class="easyui-datagrid" style="width:100%;height:100%"
			data-options="url:'system/websiteBrandTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th data-options="field:'headimgurl',width:50,align:'left',sortable:true,formatter:formatImg">相册封面</th>
					<th data-options="field:'openid',width:200,align:'center',sortable:true">相册名称</th>
					<th data-options="field:'nickname',width:150,align:'center',sortable:true">相册描述</th>
					<th data-options="field:'sex',width:60,align:'center',sortable:true,formatter:formatSex">照片数量</th>
					<th data-options="field:'city',width:200,align:'center',sortable:true,formatter:formatCity">更新时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<div style="margin-bottom:5px;">
				用户名: <input id="openid" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp;
				<a href="javaScript:void()" onclick="searchData()" class="easyui-linkbutton" plain="true"
				 	data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
			</div>				
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true"
				onclick="doUpdateStatus('wechatUserInfoTAjaxUpdate.do',1)">启用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true"
				onclick="doUpdateStatus('wechatUserInfoTAjaxUpdate.do',0)">禁用</a>
		</div>
	</div>
</body>
</html>
