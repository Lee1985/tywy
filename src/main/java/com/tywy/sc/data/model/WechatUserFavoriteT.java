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

	private WechatAlbumListT album;// 照片
	private List<String> idList;// 批量删除

	/**
	 * 获取属性
	 *
	 * @return id
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * 设置属性
	 *
	 * @param id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 获取用户id属性
	 *
	 * @return userid
	 */
	public java.lang.String getUserid() {
		return userid;
	}

	/**
	 * 设置用户id属性
	 *
	 * @param userid
	 */
	public void setUserid(java.lang.String userid) {
		this.userid = userid;
	}

	/**
	 * 获取图片ID属性
	 *
	 * @return imgUid
	 */
	public java.lang.String getImgUid() {
		return imgUid;
	}

	/**
	 * 设置图片ID属性
	 *
	 * @param imgUid
	 */
	public void setImgUid(java.lang.String imgUid) {
		this.imgUid = imgUid;
	}

	/**
	 * 获取收藏时间属性
	 *
	 * @return createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置收藏时间属性
	 *
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public WechatAlbumListT getAlbum() {
		return album;
	}

	public void setAlbum(WechatAlbumListT album) {
		this.album = album;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

}