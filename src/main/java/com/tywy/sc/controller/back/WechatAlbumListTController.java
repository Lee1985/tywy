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
import com.tywy.sc.data.model.WechatAlbumListT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatAlbumListTService;
import com.tywy.utils.DateUtils;
import com.tywy.utils.FileTool;
import com.tywy.utils.UUIDUtil;

/**
 * 
 * @ClassName: WechatAlbumListTController
 * @Description: 电子相册照片控制层
 * @author Liuheli
 * @date 2017-01-25 10:23:05
 */
@Controller
public class WechatAlbumListTController extends BaseController {
	@Resource
	private WechatAlbumListTService service;
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "/wechatAlbumListTList")
	public String wechatAlbumListTList(HttpServletRequest request, HttpServletResponse response, String id) {
		request.setAttribute("id", id);
		return "back/wechat_album_list_t_list";
	}

	@RequestMapping(value = "/wechatAlbumListTAjaxPage")
	@ResponseBody
	public PageInfo<WechatAlbumListT> wechatAlbumListTAjaxPage(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info, Integer page, Integer rows) {
		PageInfo<WechatAlbumListT> pageInfo = new PageInfo<WechatAlbumListT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatAlbumListTAjaxAll")
	@ResponseBody
	public List<WechatAlbumListT> wechatAlbumListTAjaxAll(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info, Integer page, Integer rows) {
		List<WechatAlbumListT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/wechatAlbumListTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatAlbumListTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info) {
		int result = 0;
		String msg = "";

		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String root = request.getSession().getServletContext().getRealPath("/") + "\\";
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

		info.setUpdateDate(new Date());
		info.setUpdateUser(systemUser.getId());
		if (info.getId() == null || info.getId().equals("")) {
			info.setId(UUIDUtil.getUUID());
			info.setCreateDate(new Date());
			info.setCreateUser(systemUser.getId());
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
	public Map<String, Object> wechatAlbumListTAjaxDelete(HttpServletRequest request, HttpServletResponse response,
			WechatAlbumListT info) {
		int result = 0;

		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}

		try {
			WechatAlbumListT uinfo = new WechatAlbumListT();
			uinfo.setId(info.getId());
			uinfo.setIsDelete("1");
			uinfo.setUpdateDate(new Date());
			uinfo.setUpdateUser(systemUser.getId());
			result = service.update(uinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getJsonResult(result, "操作成功", "删除失败！");
	}

	private int deleteImg(String id, String root) {
		if (id != null && !id.equals("")) {
			// 删除旧图片
			WechatAlbumListT info = service.selectById(id);
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

	/**
	 * 保存照片
	 * 
	 * @param root
	 * @param uuid
	 * @param listfile
	 * @return
	 */
	private int saveImg(String root, String uuid, MultipartFile listfile) {
		String pathTmp = FileConstant.UPLOAD_WECHAT_PHOTO_PATH + "/";
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
