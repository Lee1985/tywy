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
import com.tywy.sc.data.model.WechatElectronicAlbumT;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.sc.services.WechatElectronicAlbumTService;
import com.tywy.utils.DateUtils;
import com.tywy.utils.FileTool;
import com.tywy.utils.UUIDUtil;

/**
 * @author Liuheli
 * @ClassName: WechatElectronicAlbumTController
 * @Description: 电子相册封面控制层
 * @date 2016-11-27 16:56:19
 */
@Controller
public class WechatElectronicAlbumTController extends BaseController {
	@Resource
	private WechatElectronicAlbumTService service;
	@Resource
	private SystemPictureInfoService systemPictureInfoService;

	@RequestMapping(value = "/wechatElectronicAlbumTList")
	public String wechatElectronicAlbumTList(HttpServletRequest request, HttpServletResponse response) {
		return "back/wechat_electronic_album_t_list";
	}

	@RequestMapping(value = "/wechatElectronicAlbumTAjaxPage")
	@ResponseBody
	public PageInfo<WechatElectronicAlbumT> wechatElectronicAlbumTAjaxPage(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info, Integer page, Integer rows) {
		info.setOrder("asc");
		info.setSort("orderList");
		PageInfo<WechatElectronicAlbumT> pageInfo = new PageInfo<WechatElectronicAlbumT>();
		pageInfo.setPage(page);
		pageInfo.setPageSize(rows);
		service.selectAll(info, pageInfo);
		return pageInfo;
	}

	@RequestMapping(value = "/wechatElectronicAlbumTAjaxAll")
	@ResponseBody
	public List<WechatElectronicAlbumT> wechatElectronicAlbumTAjaxAll(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info, Integer page, Integer rows) {
		List<WechatElectronicAlbumT> results = service.selectAll(info);
		return results;
	}

	@RequestMapping(value = "/wechatElectronicAlbumTAjaxSave")
	@ResponseBody
	public Map<String, Object> wechatElectronicAlbumTAjaxSave(HttpServletRequest request, HttpServletResponse response,
			WechatElectronicAlbumT info) {
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

	@RequestMapping(value = "/wechatElectronicAlbumTAjaxDelete")
	@ResponseBody
	public Map<String, Object> wechatElectronicAlbumTAjaxDelete(HttpServletRequest request,
			HttpServletResponse response, WechatElectronicAlbumT info) {
		int result = 0;

		SystemUser systemUser = getSessionUser(request);
		if (systemUser == null) {
			return getJsonResult(result, "操作成功", "session过期请登录");
		}

		try {
			WechatElectronicAlbumT uinfo = new WechatElectronicAlbumT();
			uinfo.setId(info.getId());
			uinfo.setIsDelete(1);
			uinfo.setUpdateDate(DateUtils.getDateTimeFormat(new Date()));
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
			WechatElectronicAlbumT info = service.selectById(id);
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
		String pathTmp = FileConstant.UPLOAD_WECHAT_COVERIMG_PATH + "/";
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
