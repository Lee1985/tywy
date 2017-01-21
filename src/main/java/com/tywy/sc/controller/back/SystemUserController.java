package com.tywy.sc.controller.back;

import com.alibaba.fastjson.JSONObject;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.SystemUser;
import com.tywy.sc.services.SystemUserService;
import com.tywy.utils.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SystemUserController extends BaseController {
    @Resource
    private SystemUserService service;

    @RequestMapping(value = "/system/systemUserList")
    public String systemUserList(HttpServletRequest request, HttpServletResponse response) {
        return "system/system_user_list";
    }

    @RequestMapping(value = "/system/systemUserAjaxAll")
    @ResponseBody
    public Object systemUserAjaxAll(HttpServletRequest request, HttpServletResponse response, SystemUser info,
                                    Integer page, Integer rows) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setPageSize(rows);
        service.selectAll(info, pageInfo);
        return JSONObject.toJSON(pageInfo);
    }

    @RequestMapping(value = "/system/systemUserAjaxSave")
    @ResponseBody
    public Object systemUserAjaxSave(HttpServletRequest request, HttpServletResponse response, SystemUser info) {
        int result = 0;
        String msg = "";
        // if (info.getUserPwd() != null && !info.getUserPwd().equals("")) {
        // info.setUserPwd(CipherUtil.generatePassword(info.getUserPwd()));
        // }

        if (info.getId() == null || info.getId().equals("")) {
            SystemUser con = new SystemUser();
            con.setUserId(info.getUserId());
            int count = service.selectCount(con);
            if (count > 0) {
                msg = "账号重复！";
            } else {
                info.setId(UUIDUtil.getUUID());
                result = service.insert(info);
                msg = "保存失败！";
            }

        } else {
            if (info.getStatus() == 1) {
                //info.setIsDelete(0);
            }
            result = service.update(info);
            msg = "修改失败！";
        }
        return getJsonResult(result, "操作成功", msg);
    }

    @RequestMapping(value = "/system/systemUserAjaxDelete")
    @ResponseBody
    public Object systemUserAjaxDelete(HttpServletRequest request, HttpServletResponse response, SystemUser info) {
        int result = 0;
        try {
            SystemUser uinfo = new SystemUser();
            uinfo.setId(info.getId());
            uinfo.setStatus(0);
            //uinfo.setIsDelete(1);
            result = service.update(uinfo);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return getJsonResult(result, "操作成功", "删除失败！");
    }

    @RequestMapping(value = "/system/systemUserAjaxUpdate")
    @ResponseBody
    public Object systemUserAjaxUpdate(HttpServletRequest request, HttpServletResponse response, SystemUser info) {
        int result = 0;
        try {
            if (info.getStatus() == 1) {
                //info.setIsDelete(0);
            }
            result = service.update(info);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return getJsonResult(result, "操作成功", "操作失败！");
    }
}
