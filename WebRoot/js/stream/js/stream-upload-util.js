function singleCommonUpload(model_name,complete){
	/**
	 * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
	 * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
	 * 是在ID为i_stream_message_container的页面元素中写日志
	 */
	var config = {
			customered:true,
			browseFileId : "showImage", /** 选择文件的ID, 默认: i_select_files */
			browseFileBtn : "<div></div>", /** 显示选择文件的样式, 默认: `<div>请选择文件</div>` */
			dragAndDropArea: "showImage", /** 拖拽上传区域，Id（字符类型"i_select_files"）或者DOM对象, 默认: `i_select_files` */
			dragAndDropTips: "<div></div>", /** 拖拽提示, 默认: `<span>把文件(文件夹)拖拽到这里</span>` */
			//filesQueueId : "showImage", /** 文件上传容器的ID, 默认: i_stream_files_queue */
			//messagerId : "showImage",
			autoUploading:false,
			extFilters:['.bmp','.jpg','.jpeg','.png','.gif'],
			tokenURL:"/tywy/tk",
			uploadURL:"/tywy/upload",
			postVarsPerFile:{model: model_name},
			multipleFiles:false,
			simLimit:1,
			onSelect: function(list) {
			},
			onFileCountExceed: function(selected, limit) {
				console.log("最多文件数量： " + limit + " 但已选择" + selected + "个");
			},
			onExtNameMismatch:function(file){
				console.log(file);
			},
			onRepeatedFile: function(file) {
			  console.log("文件： " + file.name
			   + " 大小：" + file.size + "已存在于上传队列中");
			   return false;
			},
			onAddTask: function(file, dat) {
				// 图片回显
				console.log(dat.file);
				var reader = new FileReader();
		        reader.readAsDataURL(dat.file);
		        reader.onload = function(evt) {
	          		var img = $('#imgShow');
	          		img.attr('src', reader.result);
	          		img.attr('alt', file.name);
	          		img.attr('width', '120px');
	          		$('#operType').val('edit');
	            }
		        $('#addImg').hide();
		        $('#imgShow').show();
			},onComplete : function(file) {
			  var msg = eval('(' + file.msg + ')');	
			  file.suffix = file.name.substring(file.name.lastIndexOf('.'),file.name.length);			  
			  file.urlPath = msg.urlPath;
			  var imgSrc = $("#imgShow").attr("src");
			  getImageWidth(imgSrc,function(w,h){
				  file.fwidth = w;
				  file.fheight = h;
				  
			  });
			  console.log(file);	
			  console.log("文件： " + file.name + "|" + file.size + " 已上传成功！");
			  complete(file);
			}
	};
	return new Stream(config);
}

function singleIconCommonUpload(model_name,complete){
	/**
	 * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
	 * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
	 * 是在ID为i_stream_message_container的页面元素中写日志
	 */
	var config = {
			customered:true,
			browseFileId : "iconImgShow", /** 选择文件的ID, 默认: i_select_files */
			browseFileBtn : "<div></div>", /** 显示选择文件的样式, 默认: `<div>请选择文件</div>` */
			dragAndDropArea: "iconImgShow", /** 拖拽上传区域，Id（字符类型"i_select_files"）或者DOM对象, 默认: `i_select_files` */
			dragAndDropTips: "<div></div>", /** 拖拽提示, 默认: `<span>把文件(文件夹)拖拽到这里</span>` */
			autoUploading:false,
			extFilters:['.bmp','.jpg','.jpeg','.png','.gif'],
			tokenURL:"/tywy/tk",
			uploadURL:"/tywy/upload",
			postVarsPerFile:{model: model_name},
			simLimit:1,
			onSelect: function(list) {
				
			},
			onExtNameMismatch:function(file){
				console.log(file);
			},
			onAddTask: function(file, dat) {
				// 图片回显
				var reader = new FileReader();
		        reader.readAsDataURL(dat.file);
		        reader.onload = function(evt) {
	          		var img = $('#iconImgShow');
	          		img.attr('src', reader.result);
	          		img.attr('alt', file.name);
	          		$('#iconOperType').val('edit');
	            }
			},onComplete : function(file) {
			  var msg = eval('(' + file.msg + ')');
			  file.suffix = file.name.substring(file.name.lastIndexOf('.'),file.name.length);			  
			  file.urlPath = msg.urlPath;
			  var imgSrc = $("#iconImgShow").attr("src");
			  getImageWidth(imgSrc,function(w,h){
				  file.fwidth = w;
				  file.fheight = h;
			  });
			  console.log(file);
			  console.log("文件： " + file.name + "|" + file.size + " 已上传成功！");
			  complete(file);
			}
	};
	return new Stream(config);
}

function getImageWidth(url,callback){
	var img = new Image();
	img.src = url;
	
	// 如果图片被缓存，则直接返回缓存数据
	if(img.complete){
	    callback(img.width, img.height);
	}else{
        // 完全加载完毕的事件
		img.onload = function(){
			callback(img.width, img.height);
		}
	}
}