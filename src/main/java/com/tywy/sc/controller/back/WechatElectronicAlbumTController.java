package com.tywy.sc.controller.back;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.utils.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author William
 * @ClassName: WechatElectronicAlbumTController
 * @Description: 控制层
 * @date 2016-11-27 16:56:19
 * @Copyright：
 */
@Controller
public class WechatElectronicAlbumTController extends BaseController {
    @Resource
    private WechatElectronicAlbumTService service;

    @RequestMapping(value = "/wechatElectronicAlbumTList")
    public String wechatElectronicAlbumTList(HttpServletRequest request,
                                             HttpServletResponse response) {
        return "/wechat_electronic_album_t_list";
    }

    @RequestMapping(value = "/wechatElectronicAlbumTAjaxPage")
    @ResponseBody
    public PageInfo<WechatElectronicAlbumT> wechatElectronicAlbumTAjaxPage(HttpServletRequest request,
                                                                           HttpServletResponse response, WechatElectronicAlbumT info, Integer page,
                                                                           Integer rows) {
        PageInfo<WechatElectronicAlbumT> pageInfo = new PageInfo<WechatElectronicAlbumT>();
        pageInfo.setPage(page);
        pageInfo.setPageSize(rows);
        service.selectAll(info, pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "/wechatElectronicAlbumTAjaxAll")
    @ResponseBody
    public List<WechatElectronicAlbumT> wechatElectronicAlbumTAjaxAll(HttpServletRequest request,
                                                                      HttpServletResponse response, WechatElectronicAlbumT info, Integer page,
                                                                      Integer rows) {
        List<WechatElectronicAlbumT> results = service.selectAll(info);
        return results;
    }

    @RequestMapping(value = "/wechatElectronicAlbumTAjaxSave")
    @ResponseBody
    public Map<String, Object> wechatElectronicAlbumTAjaxSave(HttpServletRequest request,
                                                              HttpServletResponse response, WechatElectronicAlbumT info) {
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

    @RequestMapping(value = "/wechatElectronicAlbumTAjaxDelete")
    @ResponseBody
    public Map<String, Object> wechatElectronicAlbumTAjaxDelete(HttpServletRequest request,
                                                                HttpServletResponse response, WechatElectronicAlbumT info) {
        int result = 0;
        try {
            result = service.delete(info);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return getJsonResult(result, "操作成功", "删除失败！");
    }
}
