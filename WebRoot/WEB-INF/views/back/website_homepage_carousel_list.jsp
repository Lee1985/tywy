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

<title>网站首页轮播图维护</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>

<script type="text/javascript">
	function formatImg(value, row) {
		return "<img src="+ row.systemPictureInfo.urlPath +" style=\"height:50px;background-color:#434343\"/>";
	}
	
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
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
			data-options="url:'system/websiteHomePageCarouselAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th data-options="field:'systemPictureInfo.urlPath',width:50,align:'left',sortable:true,formatter:formatImg">图片</th>
					<th data-options="field:'orderList',width:200,align:'center',sortable:true">排序</th>
					<th data-options="field:'status',width:150,align:'center',sortable:true,formatter:formatStatus">状态</th>
					<th data-options="field:'createDate',width:200,align:'center',sortable:true">上传时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
						
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="doSave()">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
				onclick="doEdit()">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
				onclick="doDelete()">删除</a>	
						
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock_open" plain="true"
				onclick="doUpdateStatus('wechatUserInfoTAjaxUpdate.do',1)">启用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-lock" plain="true"
				onclick="doUpdateStatus('wechatUserInfoTAjaxUpdate.do',0)">禁用</a>
		</div>
	</div>
</body>
</html>
