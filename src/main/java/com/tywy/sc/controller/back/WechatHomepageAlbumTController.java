package com.tywy.sc.controller.back;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tywy.constant.FileConstant;
import com.tywy.sc.base.controller.BaseController;
import com.tywy.sc.base.page.PageInfo;
import com.tywy.sc.data.model.FileInfo;
import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.data.model.SystemUser;
import com.tywy.sc.data.model.WechatHomepageAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatHomepageAlbumTService;
import com.tywy.utils.DateUtils;
import com.tywy.utils.FileTool;
import com.tywy.utils.UUIDUtil;

/**
 * 
 * @ClassName: WechatHomepageAlbumTController
 * @Description: 微信电子相册轮播图控制层
 * @author Liuheli
 * @date 2017-01-23 17:12:42
 */
@Controller
public class WechatHomepageAlbumTController extends BaseController {
	@Resource
	private WechatHomepageAlbumTService service;
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "/wechatHomepageAlbumTList")
	public String wechatHomepageAlbumTList(HttpServletRequest request, HttpServletResponse response) {
		return "/back/wechat_homepage_album_t_list";
	}

	@RequestMapping(value = "/wechatHomepageAlbumTAjaxPage")
	@ResponseBody
	public PageInfo<WechatHomepageAlbumT> wechatHomepageAlbumTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WechatHomepageAlbumT info, Integer page, Integer rows) {
		info.setOrder("asc");
		info.setSort("orderList");
		PageInfo<WechatHomepageAlbumT> pageInfo = new PageInfo<WechatHomepageAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatHomepageAlbumTAjaxAll")
	@ResponseBody
	public List<WechatHomepageAlbumT> wechatHomepageAlbumTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WechatHomepageAlbumT info, Integer page, Integer rows) {
		List<WechatHomepageAlbumT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/wechatHomepageAlbumTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatHomepageAlbumTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatHomepageAlbumT info) {
		int result = 0;
		String msg = "";
		
		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String root = request.getSession().getServletContext().getRealPath("/") +"\\";
		// 上传图片
		String imgUuid = UUIDUtil.getUUID();
		MultipartFile picture = multipartRequest.getFile("headImg");
		if (picture != null && picture.getSize() > 0) {
			// 删除旧图片
			deleteImg(info.getId(), root);
			// 新图片处理
			saveImg(root, imgUuid, picture);
			info.setImgUuid(imgUuid);
		}
		
		String now = DateUtils.getDateTimeFormat(new Date());
		info.setUpdateDate(now);
		info.setUpdateUser(systemUser.getId());
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setCreateDate(now);
			info.setCreateUser(systemUser.getId());
			result = service.insert(info);
			msg = "保存失败！";
		} else {
			result = service.update(info);
			msg = "修改失败！";
		}
		return getJsonResult(result, "操作成功", msg);
	}

	@RequestMapping(value = "/wechatHomepageAlbumTAjaxDelete")
	@ResponseBody
	public Map<String, Object> wechatHomepageAlbumTAjaxDelete(HttpServletRequest request, HttpServletResponse response,
			WechatHomepageAlbumT info) {
		int result = 0;
		try {
			result = service.delete(info);
		} catch (Exception e) {
		}
		return getJsonResult(result, "操作成功", "删除失败！");
	}

	private int deleteImg(String id, String root) {
		if (id != null && !id.equals("")) {
			// 删除旧图片
			WechatHomepageAlbumT info = service.selectById(id);
			if (info != null) {
				String delRealPath = info.getUrlPath();
				if (delRealPath != null) {
					deleteFile(root + delRealPath);
					SystemPictureInfo delp = new SystemPictureInfo();
					delp.setUuid(info.getImgUuid());
					systemPictureInfoService.delete(delp);
				}
			}
		}
		return 0;
	}

	private int saveImg(String root, String uuid, MultipartFile listfile) {
		String pathTmp = FileConstant.UPLOAD_WECHAT_CAROUSELIMG_PATH + "/";
		String path = pathTmp + DateUtils.toString(new Date(), "yyyy/MM/dd") + "/";
		FileInfo imageInfo = FileTool.saveFile(listfile, root + path, 0, 0);

		SystemPictureInfo pictureInfo = new SystemPictureInfo();
		pictureInfo.setId(UUIDUtil.getUUID());
		pictureInfo.setUuid(uuid);
		pictureInfo.setUrlPath(path + imageInfo.getRealName());
		pictureInfo.setFwidth(imageInfo.getWidth());
		pictureInfo.setFheight(imageInfo.getHeight());
		pictureInfo.setName(imageInfo.getRealName());
		pictureInfo.setSuffix(imageInfo.getSuffix());
		pictureInfo.setCdate(DateUtils.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		int result = systemPictureInfoService.insert(pictureInfo);
		return result;
	}
}
