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

<title>首页网点管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="js/system/easy.js"></script>
<script type="text/javascript" src="js/system/base.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="js/system/keditor.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=IAN0wgv9qiTllV6NWon2GgLvheuBuKUQ&s=1" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		 $('#dg').datagrid({
             view: detailview,
             detailFormatter:function(index,row){
                 return '<div id="' + row.id + '" class="ddv"></div>';
             },
             onExpandRow: function(index,row){
      			var map = new BMap.Map(row.id,{enableMapClick:false});            // 创建Map实例
      			var point = new BMap.Point(row.lng, row.lat); // 创建点坐标
      			map.centerAndZoom(point,15);                 
      			map.disableDragging();
   				map.disableDoubleClickZoom();
      			
      			var locationIcon = new BMap.Icon("resource/website/img/location.png", new BMap.Size(46,76));
				var marker = new BMap.Marker(point,{icon:locationIcon});
				map.addOverlay(marker);
             }
         });		
		 
	  $('#addBtn').click(function(){
		  doAdd(function(){
			  $('#statusLabel').combobox('select', 1);
		  });
	  });
	  
	  $('#editBtn').click(function(){
		  doEdit();
	  });
	  
	  $('#deleteBtn').click(function(){
		  doDelete('system/websiteHomepageSalesTAjaxDelete.do');
	  });
	  
	  $('#lockOpenBtn').click(function(){
		  doUpdateStatus('system/websiteHomepageSalesTAjaxUpdate.do',1);
	  });
	  
	  $('#lockBtn').click(function(){
		  doUpdateStatus('system/websiteHomepageSalesTAjaxUpdate.do',0);
	  });
	  
	});
	
	function formatStatus(value, row) {
		var view = (value == 1) ? '启用' : '禁用';
		return view;
	}
	
</script>
<style type="text/css">
.ddv{
	height: 240px;
}

.anchorBL{ 
	display:none; 
} 

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
			data-options="url:'system/websiteHomepageSalesTAjaxPage.do', iconCls:'icon-save', 
			rownumbers:true, pagination:true, singleSelect:true, 
			toolbar:'#toolbar',rowStyler:function(index,row){   
	          if (row.status==0){   
            		return 'color:red;';   
	          	}   
	     	}">
			<thead>
				<tr>
					<th width="10%" data-options="field:'saleName',align:'center',sortable:true">网点名称</th>
					<th width="5%" data-options="field:'city',align:'center',sortable:true">所在城市</th>					
					<th width="20%" data-options="field:'address',align:'center',sortable:true">地址</th>
					<th width="10%" data-options="field:'email',align:'center',sortable:true">邮箱</th>
					<th width="20%" data-options="field:'webAddress',align:'center',sortable:true">网址</th>
					<th width="5%" data-options="field:'status',align:'center',sortable:true,formatter:formatStatus">状态</th>
					
				</tr>
			</thead>
		</table>
		<div id="dlg" class="easyui-dialog"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			style="width:400px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">请完善以下信息！</div>
			<form id="fm" name="fm" method="post" action="system/websiteHomepageSalesTAjaxSave.do">
				<div class="fitem">
					<label><font color="red">*</font>网点名称:</label>
					<input id="saleNameLabel" name="saleName" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>
					<input type="hidden" id="idLabel" name="id" />
					<input type="hidden" id="lngLabel" name="lng" />
					<input type="hidden" id="latLabel" name="lat" />
				</div>
				<div class="fitem">
					<label><font color="red">*</font>所在城市:</label>
					<input id="cityLabel" name="city" style="width: 100px" class="easyui-textbox" data-options="required:true,validType:'length[1,15]'"/>市
				</div>
				<div class="fitem">
					<label><font color="red">*</font>地址:</label>
					<input id="addressLabel" name="address" style="width: 200px" class="easyui-textbox" data-options="required:true,validType:'length[1,50]'" />
				</div>
				<div class="fitem">
					<label>邮箱:</label>
					<input id="emailLabel" name="email" style="width: 200px" class="easyui-textbox"/>
				</div>
				<div class="fitem">
					<label>网址:</label>
					<input id="webAddressLabel" name="webAddress" style="width: 200px" class="easyui-textbox"/>
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
			</div>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="getPointAndSave()" style="width:90px">确定</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		</div>
	</div>
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
			var address = $('#addressLabel').val();
   			myGeo.getPoint(address, function(point){
   				if (point) {
   					$('#lngLabel').val(point.lng);
   					$('#latLabel').val(point.lat);
   					save();
   				}else{
   					$.messager.alert('错误信息', '您填写的地址没有解析到坐标!', 'error');
   					return false;
   				}
   			}, $('#cityLabel').val());
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
</body>
</html>
