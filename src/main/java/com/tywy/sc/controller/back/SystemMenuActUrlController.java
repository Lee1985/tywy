package com.tywy.sc.controller.back;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.SystemMenuActUrl;
import com.tywy.sc.services.SystemMenuActUrlService;
import com.tywy.utils.UUIDUtil;


/**
 * @author 郭冲
 * @ClassName: SystemMenuActUrlController
 * @Description: 系统菜单动作资源控制层
 * @date 2015-03-30 09:22:49
 * @Copyright：上海科匠信息科技有限公司 2015
 */
@Controller
public class SystemMenuActUrlController extends BaseController {
    @Resource
    private SystemMenuActUrlService service;

    @RequestMapping(value = "/system/systemMenuActUrlList")
    public String systemMenuActUrlList(HttpServletRequest request,
                                       HttpServletResponse response) {
        return "system/system_menu_act_url_list";
    }

    @RequestMapping(value = "/system/systemMenuActUrlAjaxPage")
    @ResponseBody
    public JSONObject systemMenuActUrlAjaxPage(HttpServletRequest request,
                                               HttpServletResponse response, SystemMenuActUrl info, Integer page,
                                               Integer rows) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setPageSize(rows);
        service.selectAll(info, pageInfo);
        return (JSONObject) JSONObject.toJSON(pageInfo);
    }

    @RequestMapping(value = "/system/systemMenuActUrlAjaxAll")
    @ResponseBody
    public JSONArray systemMenuActUrlAjaxAll(HttpServletRequest request,
                                             HttpServletResponse response, SystemMenuActUrl info, Integer page,
                                             Integer rows) {
        List<SystemMenuActUrl> results = service.selectAll(info);
        return (JSONArray) JSON.toJSON(results);
    }

    @RequestMapping(value = "/system/systemMenuActUrlAjaxSave")
    @ResponseBody
    public Object systemMenuActUrlAjaxSave(HttpServletRequest request,
                                           HttpServletResponse response, SystemMenuActUrl info) {
        int result = 0;
        String msg = "";
        if (info.getId() == null || info.getId().equals("")) {
            info.setId(UUIDUtil.getUUID());
            result = service.insert(info);
            msg = "保存失败！";
        } else {
            result = service.update(info);
            msg = "修改失败！";
        }
        return getJsonResult(result, "操作成功", msg);
    }

    @RequestMapping(value = "/system/systemMenuActUrlAjaxDelete")
    @ResponseBody
    public Object systemMenuActUrlAjaxDelete(HttpServletRequest request,
                                             HttpServletResponse response, SystemMenuActUrl info) {
        int result = 0;
        try {
            result = service.delete(info);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return getJsonResult(result, "操作成功", "删除失败！");
    }
}
