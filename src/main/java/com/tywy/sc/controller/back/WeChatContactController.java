package com.tywy.sc.controller.back;

import java.util.Date;
import java.util.HashMap;
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
 * @ClassName: WeChatContactController
 * @Description: 控制层
 * @author liuheli
 * @date 2017-02-15 17:15:36
 */
@Controller
public class WeChatContactController extends BaseController {

	@Resource
	private ConfigInfoService configInfoService;

	@RequestMapping(value = "system/wechatContactInfo")
	public String wechatContactInfo(HttpServletRequest request, HttpServletResponse response, String id) {

		// 公司名称
		String companyValue = configInfoService.getConfigValueByKey("contact_us_wechat_company");
		request.setAttribute("companyValue", companyValue);

		// 公司地址
		String addressValue = configInfoService.getConfigValueByKey("contact_us_wechat_address");
		request.setAttribute("addressValue", addressValue);

		// 公司网址
		String websiteValue = configInfoService.getConfigValueByKey("contact_us_wechat_website");
		request.setAttribute("websiteValue", websiteValue);

		// 描述
		String contentValue = configInfoService.getConfigValueByKey("contact_us_wechat_content");
		request.setAttribute("contentValue", contentValue);

		return "back/wechat_contact_info";
	}

	@RequestMapping(value = "system/wechatContactEdit")
	public String wechatContactEdit(HttpServletRequest request, HttpServletResponse response, String id) {

		// 公司名称
		String companyValue = configInfoService.getConfigValueByKey("contact_us_wechat_company");
		request.setAttribute("companyValue", companyValue);

		// 公司地址
		String addressValue = configInfoService.getConfigValueByKey("contact_us_wechat_address");
		request.setAttribute("addressValue", addressValue);

		// 公司网址
		String websiteValue = configInfoService.getConfigValueByKey("contact_us_wechat_website");
		request.setAttribute("websiteValue", websiteValue);

		// 描述
		String contentValue = configInfoService.getConfigValueByKey("contact_us_wechat_content");
		request.setAttribute("contentValue", contentValue);

		return "back/wechat_contact_edit";
	}

	@RequestMapping(value = "system/wechatContactAjaxSaveSettings")
	@ResponseBody
	public Map<String, Object> wechatContactAjaxSaveSettings(HttpServletRequest request, HttpServletResponse response,
			String companyValue, String addressValue, String websiteValue, String contentValue) {
		int result = 0;
		String msg = "";

		// 公司名称
		Map<String, Object> companyParams = new HashMap<String, Object>();
		companyParams.put("configKey", "contact_us_wechat_company");
		ConfigInfo companyConfigInfo = configInfoService.selectEntity(companyParams);
		if (companyConfigInfo == null) {
			companyConfigInfo = new ConfigInfo();
			companyConfigInfo.setId(UUIDUtil.getUUID());
			companyConfigInfo.setConfigKey("contact_us_wechat_company");
			companyConfigInfo.setConfigValue(companyValue);
			companyConfigInfo.setCreateDate(new Date());
			companyConfigInfo.setCreateUser(getSessionUser(request).getId());
			companyConfigInfo.setIsDelete("0");
			companyConfigInfo.setStatus("1");
			result = configInfoService.insert(companyConfigInfo);
			msg = "保存失败！";
		} else {
			companyConfigInfo.setConfigValue(companyValue);
			result = configInfoService.update(companyConfigInfo);
			msg = "修改失败！";
		}

		// 公司地址
		Map<String, Object> addressParams = new HashMap<String, Object>();
		addressParams.put("configKey", "contact_us_wechat_address");
		ConfigInfo addressConfigInfo = configInfoService.selectEntity(addressParams);
		if (addressConfigInfo == null) {
			addressConfigInfo = new ConfigInfo();
			addressConfigInfo.setId(UUIDUtil.getUUID());
			addressConfigInfo.setConfigKey("contact_us_wechat_address");
			addressConfigInfo.setConfigValue(addressValue);
			addressConfigInfo.setCreateDate(new Date());
			addressConfigInfo.setCreateUser(getSessionUser(request).getId());
			addressConfigInfo.setIsDelete("0");
			addressConfigInfo.setStatus("1");
			result = configInfoService.insert(addressConfigInfo);
			msg = "保存失败！";
		} else {
			addressConfigInfo.setConfigValue(addressValue);
			result = configInfoService.update(addressConfigInfo);
			msg = "修改失败！";
		}

		// 公司网址
		Map<String, Object> websiteParams = new HashMap<String, Object>();
		websiteParams.put("configKey", "contact_us_wechat_website");
		ConfigInfo websiteConfigInfo = configInfoService.selectEntity(websiteParams);
		if (websiteConfigInfo == null) {
			websiteConfigInfo = new ConfigInfo();
			websiteConfigInfo.setId(UUIDUtil.getUUID());
			websiteConfigInfo.setConfigKey("contact_us_wechat_website");
			websiteConfigInfo.setConfigValue(websiteValue);
			websiteConfigInfo.setCreateDate(new Date());
			websiteConfigInfo.setCreateUser(getSessionUser(request).getId());
			websiteConfigInfo.setIsDelete("0");
			websiteConfigInfo.setStatus("1");
			result = configInfoService.insert(websiteConfigInfo);
			msg = "保存失败！";

		} else {
			websiteConfigInfo.setConfigValue(websiteValue);
			result = configInfoService.update(websiteConfigInfo);
			msg = "修改失败！";
		}

		// 描述
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("configKey", "contact_us_wechat_content");
		ConfigInfo configInfo = configInfoService.selectEntity(params);
		if (configInfo == null) {
			configInfo = new ConfigInfo();
			configInfo.setId(UUIDUtil.getUUID());
			configInfo.setConfigKey("contact_us_wechat_content");
			configInfo.setConfigValue(contentValue);
			configInfo.setCreateDate(new Date());
			configInfo.setCreateUser(getSessionUser(request).getId());
			configInfo.setIsDelete("0");
			configInfo.setStatus("1");
			result = configInfoService.insert(configInfo);
			msg = "保存失败！";

		} else {
			configInfo.setConfigValue(contentValue);
			result = configInfoService.update(configInfo);
			msg = "修改失败！";
		}

		return getJsonResult(result, "操作成功", msg);
	}
}
