<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>设计相册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script type="text/javascript" src="js/system/easy.js"></script>
		<script type="text/javascript" src="js/system/base.js"></script>
		<link rel="stylesheet" href="js/stream/css/dropzone.css" />
		<style>
			body{color: rgb(100, 108, 127);  line-height: 28px;}
				.dropzone {
			  border: 2px dashed #0087F7;
			  border-radius: 5px;
			  background: white;
			}
			.dropzone .dz-message {
			  font-weight: 400;
			}
			.dropzone .dz-message .note {
			  font-size: 0.8em;
			  font-weight: 200;
			  display: block;
			  margin-top: 1.4rem;
			}
		</style>
	</head>
	<body>
			<h1 id="try-it-out">设计相册维护,支持文件夹,建议比例16:9</h1>
			<div id="dropzone">
				<form action="/upload" class="dropzone dz-clickable dz-started" id="uploadForm" method="post">
					<c:forEach items="${list}" var="picture">
						<div id="${picture.systemPictureInfo.uuid }" data-id="${picture.id }" class="dz-preview dz-file-preview dz-processing dz-error dz-add" style="margin:12px;">
							<div class="dz-image" style="width:100%;"><img width="173px" height="100px" data-dz-thumbnail="" src="downFileResult.do?urlPath=${picture.systemPictureInfo.urlPath }"></div>
							<div class="dz-details">
								<div class="dz-size"><span data-dz-size="">${picture.systemPictureInfo.fileSize }</span></div>
								<div class="dz-filename"><span data-dz-name="">${picture.systemPictureInfo.name }</span></div>
							</div>
							<div class="dz-error-message"><span data-dz-errormessage="">点击✖️将取消本文件上传。</span></div>
							<div class="dz-success-mark">
								<svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
									<!-- Generator: Sketch 3.2.1 (9971) - http://www.bohemiancoding.com/sketch -->
									<title>Check</title>
									<desc>Created with Sketch.</desc>
									<defs></defs>
									<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
										<path d="M23.5,31.8431458 L17.5852419,25.9283877 C16.0248253,24.3679711 13.4910294,24.366835 11.9289322,25.9289322 C10.3700136,27.4878508 10.3665912,30.0234455 11.9283877,31.5852419 L20.4147581,40.0716123 C20.5133999,40.1702541 20.6159315,40.2626649 20.7218615,40.3488435 C22.2835669,41.8725651 24.794234,41.8626202 26.3461564,40.3106978 L43.3106978,23.3461564 C44.8771021,21.7797521 44.8758057,19.2483887 43.3137085,17.6862915 C41.7547899,16.1273729 39.2176035,16.1255422 37.6538436,17.6893022 L23.5,31.8431458 Z M27,53 C41.3594035,53 53,41.3594035 53,27 C53,12.6405965 41.3594035,1 27,1 C12.6405965,1 1,12.6405965 1,27 C1,41.3594035 12.6405965,53 27,53 Z"
										id="Oval-2" stroke-opacity="0.198794158" stroke="#747474" fill-opacity="0.816519475" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
									</g>
								</svg>
							</div>
							<!-- <div class="dz-error-mark">
			
								<svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
									Generator: Sketch 3.2.1 (9971) - http://www.bohemiancoding.com/sketch
									<title>error</title>
									<desc>Created with Sketch.</desc>
									<defs></defs>
									<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
										<g id="Check-+-Oval-2" sketch:type="MSLayerGroup" stroke="#747474" stroke-opacity="0.198794158" fill="#FFFFFF" fill-opacity="0.816519475">
											<path d="M32.6568542,29 L38.3106978,23.3461564 C39.8771021,21.7797521 39.8758057,19.2483887 38.3137085,17.6862915 C36.7547899,16.1273729 34.2176035,16.1255422 32.6538436,17.6893022 L27,23.3431458 L21.3461564,17.6893022 C19.7823965,16.1255422 17.2452101,16.1273729 15.6862915,17.6862915 C14.1241943,19.2483887 14.1228979,21.7797521 15.6893022,23.3461564 L21.3431458,29 L15.6893022,34.6538436 C14.1228979,36.2202479 14.1241943,38.7516113 15.6862915,40.3137085 C17.2452101,41.8726271 19.7823965,41.8744578 21.3461564,40.3106978 L27,34.6568542 L32.6538436,40.3106978 C34.2176035,41.8744578 36.7547899,41.8726271 38.3137085,40.3137085 C39.8758057,38.7516113 39.8771021,36.2202479 38.3106978,34.6538436 L32.6568542,29 Z M27,53 C41.3594035,53 53,41.3594035 53,27 C53,12.6405965 41.3594035,1 27,1 C12.6405965,1 1,12.6405965 1,27 C1,41.3594035 12.6405965,53 27,53 Z"
											id="Oval-2" sketch:type="MSShapeGroup"></path>
										</g>
									</g>
								</svg>
							</div> -->
							<div>
								<input type="text" id="${picture.id }input" name="${picture.id }input" placeholder="请在此输入图片名称" value="${picture.designName }"/>
							</div>
						</div>
					</c:forEach>
				</form>
			</div>
			<div style="width:100%;text-align: center; height: 50px; " >
				<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="uploadAndSave()" style="width:90px;padding-bottom: 0;">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:location.href='system/websiteDesignTList.do';" style="width:90px">取消</a>
			</div>
		<script type="text/javascript" src="js/stream/js/stream-v1.js"></script>
		<script type="text/javascript" src="js/stream/js/stream-upload-util.js"></script>
		<script id="DropUploadMessage" type="text/template">
			<div class="dz-message">
				将您的文件（或文件夹）拖拽到这里开始上传。
				<br>
				<span class="note">(Dropzone风格样例。文件上传至服务器之后将会被 <strong>删除</strong> 。)</span>
			</div>
		</script>
		
		<script id="UploadFileModule" type="text/template">
			<div id="#FILE_ID#" class="dz-preview dz-file-preview dz-processing dz-error dz-edit" style="margin:12px;">
				<div class="dz-image" style="width:100%;"><img width="173px" data-dz-thumbnail=""></div>

				<div class="dz-details">
					<div class="dz-size"><span data-dz-size="">#FILE_SIZE#</span></div>
					<div class="dz-filename"><span data-dz-name="">#FILE_NAME#</span></div>
				</div>
				<div class="dz-progress"><span class="dz-upload" data-dz-uploadprogress=""></span></div>
				<div class="dz-error-message"><span data-dz-errormessage="">点击✖️将取消本文件上传。</span></div>

				<div class="dz-success-mark">

					<svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
						<!-- Generator: Sketch 3.2.1 (9971) - http://www.bohemiancoding.com/sketch -->
						<title>Check</title>
						<desc>Created with Sketch.</desc>
						<defs></defs>
						<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
							<path d="M23.5,31.8431458 L17.5852419,25.9283877 C16.0248253,24.3679711 13.4910294,24.366835 11.9289322,25.9289322 C10.3700136,27.4878508 10.3665912,30.0234455 11.9283877,31.5852419 L20.4147581,40.0716123 C20.5133999,40.1702541 20.6159315,40.2626649 20.7218615,40.3488435 C22.2835669,41.8725651 24.794234,41.8626202 26.3461564,40.3106978 L43.3106978,23.3461564 C44.8771021,21.7797521 44.8758057,19.2483887 43.3137085,17.6862915 C41.7547899,16.1273729 39.2176035,16.1255422 37.6538436,17.6893022 L23.5,31.8431458 Z M27,53 C41.3594035,53 53,41.3594035 53,27 C53,12.6405965 41.3594035,1 27,1 C12.6405965,1 1,12.6405965 1,27 C1,41.3594035 12.6405965,53 27,53 Z"
							id="Oval-2" stroke-opacity="0.198794158" stroke="#747474" fill-opacity="0.816519475" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
						</g>
					</svg>

				</div>
				<div class="dz-error-mark">

					<svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
						<!-- Generator: Sketch 3.2.1 (9971) - http://www.bohemiancoding.com/sketch -->
						<title>error</title>
						<desc>Created with Sketch.</desc>
						<defs></defs>
						<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
							<g id="Check-+-Oval-2" sketch:type="MSLayerGroup" stroke="#747474" stroke-opacity="0.198794158" fill="#FFFFFF" fill-opacity="0.816519475">
								<path d="M32.6568542,29 L38.3106978,23.3461564 C39.8771021,21.7797521 39.8758057,19.2483887 38.3137085,17.6862915 C36.7547899,16.1273729 34.2176035,16.1255422 32.6538436,17.6893022 L27,23.3431458 L21.3461564,17.6893022 C19.7823965,16.1255422 17.2452101,16.1273729 15.6862915,17.6862915 C14.1241943,19.2483887 14.1228979,21.7797521 15.6893022,23.3461564 L21.3431458,29 L15.6893022,34.6538436 C14.1228979,36.2202479 14.1241943,38.7516113 15.6862915,40.3137085 C17.2452101,41.8726271 19.7823965,41.8744578 21.3461564,40.3106978 L27,34.6568542 L32.6538436,40.3106978 C34.2176035,41.8744578 36.7547899,41.8726271 38.3137085,40.3137085 C39.8758057,38.7516113 39.8771021,36.2202479 38.3106978,34.6538436 L32.6568542,29 Z M27,53 C41.3594035,53 53,41.3594035 53,27 C53,12.6405965 41.3594035,1 27,1 C12.6405965,1 1,12.6405965 1,27 C1,41.3594035 12.6405965,53 27,53 Z"
								id="Oval-2" sketch:type="MSShapeGroup"></path>
							</g>
						</g>
					</svg>
				</div>
				<div>
					<input type="text" id="#FILE_ID#input" name="#FILE_ID#input" placeholder="请在此输入图片名称" data-options="required:true,validType:'length[1,25]'"/>
				</div>
			</div>
		</script>
		
		<script type="text/javascript">
				var stream = mutiFileUpload('website_design_ablum',function(file){
					var imageName = $("#"+file.id+'input').val();
					var formInfo = $("#uploadForm").serialize()+'&designName='+imageName;
				    var ajaxOptions = {
		    		 url: 'system/websiteDesignTAjaxSave.do',
		    		 data:formInfo,
		    		 type: 'post',
		    		 async: false,
		    		 dataType: 'json',
		    		 success: function(data) {
		    			 /** 100% percent */
		    			var $bar = $("#"+file.id).find("div.progress-bar");
		    			$bar.css("width", file.percent + "%");
		    			var module = $("#"+file.id);
		    			module.addClass("dz-complete dz-success");
		    			module.removeClass('dz-processing dz-error');
		    		 }
		    		};
		    		$.ajax(ajaxOptions);
				});
		
				var index;
				function uploadAndSave(){
					if(!validation()){
						return false;
					}
					save();
					if($('.dz-edit').size() > 0){
						stream.upload();
					}else{
						if(layer){
							layer.close(index);
						}
					}
				}
				
				function save(){
					$('.dz-add').each(function(i){
						var id = $(this).data('id');
						var imageName = $(this).find('input').val();
						 var ajaxOptions = {
			    		 url: 'system/websiteDesignTAjaxSave.do',
				    		 data:'id='+id+'&designName='+imageName,
				    		 type: 'post',
				    		 async: false,    
				    		 dataType: 'json',
				    		 success: function(data) {
				    			console.log(data);
				    		 }
			    		};
			    		$.ajax(ajaxOptions);
					});										
				}
				
				function validation(){
					var size = $('.dz-preview').size();
					if (size <= 0) {
				        $.messager.alert('错误信息', '请上传图片!', 'error');
				        return false;
				    }
					var rr = $('#uploadForm').form('enableValidation').form('validate');
				    if (rr) {
				    	index = layer.load('操作中...请等待！', 0);
				    } else {
				        return false;
				    }
				    return true;
				}
				
				$(function(){
					$('.dz-preview').click(function(e){
						e.stopPropagation();
						var url = "system/websiteDesignTAjaxDelete.do";
						var uuid = $(this).attr('id');
						var id = $(this).data('id');						
						$.messager.confirm('Confirm', '你确定要删除吗?', function(r) {
							if (r) {
								$.post(url, {
									id : id
								}, function(result) {
									if (result.success) {
										$('#'+uuid).remove();
										layer.close(index);
									} else {
										$.messager.show({ // show error message
											title : '提示',
											msg : result.msg
										});
									}
								}, 'json');
							}
						});
					});
					
					$('.dz-preview').find('input').click(function(e) {
						e.stopPropagation();								
					});
				});
		</script>
	</body>
</html>