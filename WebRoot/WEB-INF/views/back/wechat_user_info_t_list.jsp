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

<title>微信用户表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>

<script type="text/javascript">
	function searchData() {
		$('#dg').datagrid('load', {
			nickname : Trim($('#nickname').val()),
			sex : $('#sex').combobox('getValue'),
			status : $('#status').combobox('getValue'),
			openid : Trim($('#openid').val())
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
			data-options="url:'wechatUserInfoTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th data-options="field:'headimgurl',width:50,align:'left',sortable:true,formatter:formatImg">头像</th>
					<th data-options="field:'openid',width:200,align:'center',sortable:true">微信号</th>
					<th data-options="field:'nickname',width:150,align:'center',sortable:true">微信昵称</th>
					<th data-options="field:'sex',width:60,align:'center',sortable:true,formatter:formatSex">性别</th>
					<th data-options="field:'city',width:200,align:'center',sortable:true,formatter:formatCity">地区</th>
					<!-- <th data-options="field:'mobile',width:80,align:'center',sortable:true">手机号</th> -->
					<th data-options="field:'status',width:80,align:'center',sortable:true,formatter:formatStatus">状态</th>
					<th data-options="field:'subscribeTime',width:125,align:'center',sortable:true">关注时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<div>
				微信号: <input id="openid" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp; 
				微信昵称: <input id="nickname" class="easyui-textbox" style="width:180px"> &nbsp;&nbsp; 
				性别: <select class="easyui-combobox" id="sex" name="sex" style="width:180px"
						data-options="panelHeight:'auto',required:true,editable:false">
						<option value="" selected="selected">全部</option>
						<option value="1">男</option>
						<option value="2">女</option>
						<option value="0">未知</option>
					</select>&nbsp;&nbsp; 
				状态: <select class="easyui-combobox" id="status" name="status" style="width:180px"
						data-options="panelHeight:'auto',required:true,editable:false">
						<option value="" selected="selected">全部</option>
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select>&nbsp;&nbsp;
				 <a href="javaScript:void()" onclick="searchData()" class="easyui-linkbutton" plain="true"
				 	data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true"
					onclick="doUpdateStatus('wechatUserInfoTAjaxUpdate.do',1)">启用</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true"
					onclick="doUpdateStatus('wechatUserInfoTAjaxUpdate.do',0)">禁用</a>
			</div>
		</div>
	</div>
</body>
</html>
