package com.tywy.sc.data.model;

import java.io.Serializable;
import java.util.List;

import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_user_favorite_t实体表()
 * 
 * @author Liuheli
 * @date 2017-01-25 20:09:48
 */
@SuppressWarnings("serial")
public class WechatUserFavoriteT extends BaseEntity implements Serializable {
	private java.lang.String id; //
	private java.lang.String userid; // 用户id
	private java.lang.String imgUid; // 图片ID
	private String createDate; // 收藏时间

	private String urlPath;// 照片url
	private List<String> idList;// 后台处理
	private String ids;// 前台传入
	private WechatAlbumListT album;// 照片
	private Integer sortFlag;// 排序标志1正序2倒叙

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getUserid() {
		return userid;
	}

	public void setUserid(java.lang.String userid) {
		this.userid = userid;
	}

	public java.lang.String getImgUid() {
		return imgUid;
	}

	public void setImgUid(java.lang.String imgUid) {
		this.imgUid = imgUid;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public WechatAlbumListT getAlbum() {
		return album;
	}

	public void setAlbum(WechatAlbumListT album) {
		this.album = album;
	}

	public Integer getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(Integer sortFlag) {
		this.sortFlag = sortFlag;
	}

}