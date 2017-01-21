package com.tywy.sc.controller.back;

import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.services.WechatAlbumListTService;
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
 * @ClassName: WechatAlbumListTController
 * @Description: 控制层
 * @date 2016-11-27 16:56:19
 * @Copyright：
 */
@Controller
public class WechatAlbumListTController extends BaseController {
    @Resource
    private WechatAlbumListTService service;

    @RequestMapping(value = "/wechatAlbumListTList")
    public String wechatAlbumListTList(HttpServletRequest request,
                                       HttpServletResponse response) {
        return "/wechat_album_list_t_list";
    }

    @RequestMapping(value = "/wechatAlbumListTAjaxPage")
    @ResponseBody
    public PageInfo<WechatAlbumListT> wechatAlbumListTAjaxPage(HttpServletRequest request,
                                                               HttpServletResponse response, WechatAlbumListT info, Integer page,
                                                               Integer rows) {
        PageInfo<WechatAlbumListT> pageInfo = new PageInfo<WechatAlbumListT>();
        pageInfo.setPage(page);
        pageInfo.setPageSize(rows);
        service.selectAll(info, pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "/wechatAlbumListTAjaxAll")
    @ResponseBody
    public List<WechatAlbumListT> wechatAlbumListTAjaxAll(HttpServletRequest request,
                                                          HttpServletResponse response, WechatAlbumListT info, Integer page,
                                                          Integer rows) {
        List<WechatAlbumListT> results = service.selectAll(info);
        return results;
    }

    @RequestMapping(value = "/wechatAlbumListTAjaxSave")
    @ResponseBody
    public Map<String, Object> wechatAlbumListTAjaxSave(HttpServletRequest request,
                                                        HttpServletResponse response, WechatAlbumListT info) {
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

    @RequestMapping(value = "/wechatAlbumListTAjaxDelete")
    @ResponseBody
    public Map<String, Object> wechatAlbumListTAjaxDelete(HttpServletRequest request,
                                                          HttpServletResponse response, WechatAlbumListT info) {
        int result = 0;
        try {
            result = service.delete(info);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return getJsonResult(result, "操作成功", "删除失败！");
    }
}
