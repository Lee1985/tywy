package com.tywy.sc.controller.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tywy.constant.CfgConstant;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.WechatUserInfoT;
import com.tywy.sc.data.model.wechat.AccessTokenVO;
import com.tywy.sc.services.WechatUserInfoTService;
import com.tywy.utils.wechat.NetWorkCenter;

/**
 * @author Liuheli
 * @ClassName: WechatUserInfoTController
 * @Description: 用户控制层
 * @date 2016-11-23 21:46:22
 */
@Controller
public class WechatUserInfoTController extends BaseController {
	@Resource
	private WechatUserInfoTService service;

	@RequestMapping(value = "/wechatUserInfoTList")
	public String wechatUserInfoTList(HttpServletRequest request, HttpServletResponse response) {
		return "/back/wechat_user_info_t_list";
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxPage")
	@ResponseBody
	public PageInfo<WechatUserInfoT> wechatUserInfoTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WechatUserInfoT info, Integer page, Integer rows) {
		PageInfo<WechatUserInfoT> pageInfo = new PageInfo<WechatUserInfoT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxAll")
	@ResponseBody
	public List<WechatUserInfoT> wechatUserInfoTAjaxAll(HttpServletRequest request, HttpServletResponse response,
			WechatUserInfoT info, Integer page, Integer rows) {
		List<WechatUserInfoT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/wechatUserInfoTAjaxUpdate")
	@ResponseBody
	public Map<String, Object> wechatUserInfoTAjaxUpdate(HttpServletRequest request, HttpServletResponse response,
			WechatUserInfoT info) {
		int result = 0;
		String url = "";
		String resp = "";
		String token = "";
		try {
			token = getAccessToken();
			if (StringUtils.isNotBlank(token)) {

				switch (info.getStatus()) {
				case 0:// 拉黑
					url = CfgConstant.BATCHBLACKLIST.replace("_ACCESS_TOKEN", token);
					break;
				case 1:// 取消拉黑
					url = CfgConstant.BATCHUNBLACKLIST.replace("_ACCESS_TOKEN", token);
					break;
				}

				Map<String, List<String>> map = new HashMap<>();
				List<String> list = new ArrayList<>();
				list.add(info.getOpenid());
				map.put("openid_list", list);

				resp = NetWorkCenter.doPost(url, JSON.toJSONString(map));

				map = JSON.parseObject(resp, Map.class);
				if (map != null && "ok".equals(map.get("errmsg"))) {
					result = service.update(info);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getJsonResult(result, "操作成功", "更新失败！");
	}

	/**
	 * 获取access token
	 *
	 * @return
	 */
	private String getAccessToken() {
		String requestUrl = CfgConstant.GET_ACCESSTOKEN_URL.replace("_APPID", CfgConstant.APPID).replace("_APPSECRET",
				CfgConstant.APPSECRET);
		String token = "";
		try {
			String result = NetWorkCenter.doGet(requestUrl, null);
			if (StringUtils.isBlank(result) || StringUtils.contains(result, "errcode")) {
				System.out.println("-----【getAccessToken requestUrl】----" + requestUrl);
				System.out.println("----【getAccessToken Fail】----" + result);
			} else {
				AccessTokenVO accessTokenVO = JSON.parseObject(result, AccessTokenVO.class);
				token = accessTokenVO.getAccess_token();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}

}
