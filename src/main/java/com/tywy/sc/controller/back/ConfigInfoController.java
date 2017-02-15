package com.tywy.sc.controller.back;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.data.model.ConfigInfo;
import com.tywy.sc.services.ConfigInfoService;
import com.tywy.utils.UUIDUtil;

/**
 * 
* @ClassName: ConfigInfoController 
* @Description: 控制层 
* @author lipeng 
* @date 2017-02-15 17:59:04 
* @Copyright：
 */
@Controller
public class ConfigInfoController extends BaseController {
	
	@Resource
	private ConfigInfoService configInfoService;
	
	@RequestMapping(value = "system/configInfoAjaxSave")
	@ResponseBody
	public Map<String,Object> configInfoAjaxSave(HttpServletRequest request,
			HttpServletResponse response, ConfigInfo info) {
		int result = 0;
		String msg = "";
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setCreateUser(getSessionUser(request).getId());
			info.setCreateDate(new Date());
			info.setStatus("1");
			info.setIsDelete("0");
			result = configInfoService.insert(info);
			msg = "保存失败！";
		} else {
			result = configInfoService.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功",msg);
	}
	
	
}
