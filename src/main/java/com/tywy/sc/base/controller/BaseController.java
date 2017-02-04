package com.tywy.sc.base.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.alibaba.fastjson.JSONObject;
import com.tywy.constant.SessionConstants;
import com.tywy.sc.data.model.SystemUser;
import com.tywy.utils.FileTool;

@Controller
public class BaseController {

	public final static Integer pageSize = 10;

	protected Map<String, Object> getJsonResult(Integer result, String msg, String errorMsg) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (result > 0) {
			map.put("success", true);
			map.put("msg", msg);
		} else {
			map.put("success", false);
			map.put("msg", errorMsg);
		}
		return map;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex, HttpServletRequest request) {
		String errorMessage = StringUtils.EMPTY;
		if (ex instanceof MaxUploadSizeExceededException) {
			errorMessage = "文件应不大于 " + getFileMB(((MaxUploadSizeExceededException) ex).getMaxUploadSize());
		} else {
			ex.printStackTrace();
			errorMessage = "未知错误: " + ex.getMessage();
		}
		return errorMessage;
	}

	private String getFileMB(long byteFile) {
		if (byteFile == 0)
			return "0MB";
		long mb = 1024 * 1024;
		return "" + byteFile / mb + "MB";
	}

	public String encodeParam(String param) {
		try {
			if (StringUtils.isNotBlank(param)) {
				param = URLEncoder.encode(param, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}

	public String decodeParam(String param) {
		try {
			if (StringUtils.isNotBlank(param)) {
				param = URLDecoder.decode(param, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}

	public void writeJsonObject(HttpServletResponse response, int result, String msg, Object ob) {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("result", result);
		jsonobject.put("msg", msg);
		if (null != ob) {
			jsonobject.put("data", ob);
		}
		try {
			String json = jsonobject.toString();
			System.out.println(json);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(json);// mess为返回到jsp页面的值
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SystemUser getSessionUser(HttpServletRequest request) {
		SystemUser systemUser = null;
		try {
			systemUser = (SystemUser) request.getSession().getAttribute(SessionConstants.SESSION_USER);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return systemUser;
	}

	protected boolean deleteFile(String path) {
		boolean flag = false;
		FileTool.deleteFile(path);
		path = path.substring(0, path.lastIndexOf("/"));
		File dirFile = new File(path);
		// 删除日文件夹
		if (dirFile.listFiles() != null && dirFile.listFiles().length == 0) {
			flag = FileTool.deleteDirectory(path);
		}
		// 删除月文件夹
		if (flag) {
			path = path.substring(0, path.lastIndexOf("/"));
			dirFile = new File(path);
			if (dirFile.listFiles().length == 0) {
				flag = FileTool.deleteDirectory(path);
			}
		}
		// 删除年文件夹
		if (flag) {
			path = path.substring(0, path.lastIndexOf("/"));
			dirFile = new File(path);
			if (dirFile.listFiles().length == 0) {
				flag = FileTool.deleteDirectory(path);
			}
		}
		return flag;
	}
}
