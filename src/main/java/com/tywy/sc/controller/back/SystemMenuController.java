package com.tywy.sc.controller.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tywy.constant.SessionConstants;
import com.tywy.sc.base.entity.EUTree;
import com.tywy.sc.data.model.SystemMenu;
import com.tywy.sc.data.model.SystemUser;
import com.tywy.sc.services.SystemMenuService;
import com.tywy.utils.UUIDUtil;

@Controller
public class SystemMenuController {
	@Resource
	private SystemMenuService systemMenuService;

	@RequestMapping(value = "/system/systemMenuList")
	public String systemMenuList(HttpServletRequest request, HttpServletResponse response) {
		return "system/system_menu_list";
	}

	@RequestMapping(value = "/system/systemMenuAjaxAll")
	@ResponseBody
	public JSONArray systemMenuAjaxAll(HttpServletRequest request, HttpServletResponse response) {
		List<SystemMenu> menus = systemMenuService.selectAllByPid("0");
		System.out.println(JSONArray.toJSON(menus).toString());
		return (JSONArray) JSONArray.toJSON(menus);
	}

	@RequestMapping(value = "/system/systemMenuAjaxAllByRole")
	@ResponseBody
	public JSONArray systemMenuAjaxAllByRole(HttpServletRequest request, HttpServletResponse response,
			SystemMenu info) {
		List<SystemMenu> menus = systemMenuService.selectAllByRole(info);
		System.out.println(JSONArray.toJSON(menus).toString());
		return (JSONArray) JSONArray.toJSON(menus);
	}

	@RequestMapping(value = "/system/systemMenuDrag")
	@ResponseBody
	public String systemMenuDrag(HttpServletRequest request, HttpServletResponse response, String id, String pid,
			String moveType) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String json = "";
		int result = 0;
		try {
			result = systemMenuService.systemMenuDrag(id, pid, moveType);
		} catch (Exception e) {
			// TODO: handle exception
		}
		resultMap.put("result", result);
		json = JSONObject.toJSON(resultMap).toString();
		return json;
	}

	@RequestMapping(value = "/system/systemMenuAjaxSave")
	@ResponseBody
	public JSONObject systemMenuAjaxSave(HttpServletRequest request, HttpServletResponse response, SystemMenu menu) {
		try {

			if (menu.getId() != null && !menu.getId().equals("")) {
				systemMenuService.update(menu);
			} else {
				menu.setId(UUIDUtil.getUUID());
				if (menu.getPid() == null || menu.getPid().equals("")) {
					menu.setPid("0");
				}
				int max = systemMenuService.selectMaxOrderListByPid(menu);
				menu.setOrderList(max + 1);
				systemMenuService.insert(menu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONObject) JSONObject.toJSON(menu);
	}

	@RequestMapping(value = "/system/systemMenuAjaxDelete")
	@ResponseBody
	public String systemMenuAjaxDelete(HttpServletRequest request, HttpServletResponse response, SystemMenu menu) {
		String json = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = 0;
		try {
			result = systemMenuService.delete(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			resultMap.put("result", true);

		} else {
			resultMap.put("result", false);
		}
		json = JSONObject.toJSON(menu).toString();
		return json;
	}

	@RequestMapping(value = "system/initSystemMenuTree")
	@ResponseBody
	public List<EUTree> initSystemMenuTree(HttpServletRequest request, HttpServletResponse response) {
		SystemUser userInfo = (SystemUser) request.getSession().getAttribute(SessionConstants.SESSION_BACK_USER);
		if (null == userInfo) {
			return null;
		}
		List<SystemMenu> menus = null;
		SystemMenu menu = new SystemMenu();
		menu.setRoleId(userInfo.getRoleId());
		List<EUTree> treeList = new ArrayList<EUTree>();
		if (menu.getRoleId().equals("root")) {
			menus = systemMenuService.selectAllByPid("0");
			getMenuList (menus, treeList);
		} else {
			menus = systemMenuService.selectAllByRoleLogin(menu);
			for(SystemMenu sysmenu : menus){
				EUTree euTree = new EUTree();
				euTree.setAttributes(sysmenu);
				euTree.setId(sysmenu.getId());
				euTree.setParent(sysmenu.getPid());
				euTree.setState("close");
				euTree.setText(sysmenu.getName());
				euTree.setMenuUrl(sysmenu.getMenuUrl());
				treeList.add(euTree);
			}
		}
		request.getSession(true).setAttribute(SessionConstants.SESSION_PERMISSACT, menus);
		return treeList;
	}
	
	private void getMenuList (List<SystemMenu> menus, List<EUTree> treeList){
		for(SystemMenu sysmenu : menus){
			EUTree euTree = new EUTree();
			euTree.setAttributes(sysmenu);
			euTree.setId(sysmenu.getId());
			euTree.setParent(sysmenu.getPid());
			euTree.setState("close");
			euTree.setText(sysmenu.getName());
			euTree.setMenuUrl(sysmenu.getMenuUrl());
			treeList.add(euTree);
			List<SystemMenu> menu2 = sysmenu.getChildren();
			if(menu2!=null && menu2.size()>0){
				getMenuList (menu2, treeList);
			}
		}
	}

}
