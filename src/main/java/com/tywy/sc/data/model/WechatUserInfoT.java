package com.tywy.sc.data.model;

import java.io.Serializable;
import com.tywy.sc.base.entity.BaseEntity;

/**
 * wechat_user_info_t实体表()
 * @author William
 * @date 2016-11-23 21:46:22
 * @project 
 */
 @SuppressWarnings("serial")
public class WechatUserInfoT extends BaseEntity implements Serializable {
	private java.lang.String id; // 
	private java.lang.Integer subscribe; // 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）
	private java.lang.String openid; // 用户的标识，对当前公众号唯一
	private java.lang.String nickname; // 用户的昵称
	private java.lang.Integer sex; // 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private java.lang.String city; // 用户所在城市
	private java.lang.String country; // 用户所在国家
	private java.lang.String province; // 用户所在省份
	private java.lang.String headimgurl; // 用户头像
	private java.util.Date subscribe_time; // 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private java.lang.String unionid; // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	private java.lang.String remark; // 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private java.lang.String groupid; // 用户所在的分组ID（暂时兼容用户分组旧接口）
	private java.lang.String tagid_list; // 用户被打上的标签ID列表
	private java.lang.Integer status; // 状态1启用0禁用(拉黑)
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
     * 获取用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）属性
     *
     * @return subscribe
     */
	public java.lang.Integer getSubscribe() {
		return subscribe;
	}
	
	/**
	 * 设置用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）属性
	 *
	 * @param subscribe
	 */
	public void setSubscribe(java.lang.Integer subscribe) {
		this.subscribe = subscribe;
	}
	
	/**
     * 获取用户的标识，对当前公众号唯一属性
     *
     * @return openid
     */
	public java.lang.String getOpenid() {
		return openid;
	}
	
	/**
	 * 设置用户的标识，对当前公众号唯一属性
	 *
	 * @param openid
	 */
	public void setOpenid(java.lang.String openid) {
		this.openid = openid;
	}
	
	/**
     * 获取用户的昵称属性
     *
     * @return nickname
     */
	public java.lang.String getNickname() {
		return nickname;
	}
	
	/**
	 * 设置用户的昵称属性
	 *
	 * @param nickname
	 */
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}
	
	/**
     * 获取用户的性别，值为1时是男性，值为2时是女性，值为0时是未知属性
     *
     * @return sex
     */
	public java.lang.Integer getSex() {
		return sex;
	}
	
	/**
	 * 设置用户的性别，值为1时是男性，值为2时是女性，值为0时是未知属性
	 *
	 * @param sex
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}
	
	/**
     * 获取用户所在城市属性
     *
     * @return city
     */
	public java.lang.String getCity() {
		return city;
	}
	
	/**
	 * 设置用户所在城市属性
	 *
	 * @param city
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	
	/**
     * 获取用户所在国家属性
     *
     * @return country
     */
	public java.lang.String getCountry() {
		return country;
	}
	
	/**
	 * 设置用户所在国家属性
	 *
	 * @param country
	 */
	public void setCountry(java.lang.String country) {
		this.country = country;
	}
	
	/**
     * 获取用户所在省份属性
     *
     * @return province
     */
	public java.lang.String getProvince() {
		return province;
	}
	
	/**
	 * 设置用户所在省份属性
	 *
	 * @param province
	 */
	public void setProvince(java.lang.String province) {
		this.province = province;
	}
	
	/**
     * 获取用户头像属性
     *
     * @return headimgurl
     */
	public java.lang.String getHeadimgurl() {
		return headimgurl;
	}
	
	/**
	 * 设置用户头像属性
	 *
	 * @param headimgurl
	 */
	public void setHeadimgurl(java.lang.String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	/**
     * 获取用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间属性
     *
     * @return subscribe_time
     */
	public java.util.Date getSubscribeTime() {
		return subscribe_time;
	}
	
	/**
	 * 设置用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间属性
	 *
	 * @param subscribe_time
	 */
	public void setSubscribeTime(java.util.Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	
	/**
     * 获取只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。属性
     *
     * @return unionid
     */
	public java.lang.String getUnionid() {
		return unionid;
	}
	
	/**
	 * 设置只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。属性
	 *
	 * @param unionid
	 */
	public void setUnionid(java.lang.String unionid) {
		this.unionid = unionid;
	}
	
	/**
     * 获取公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注属性
     *
     * @return remark
     */
	public java.lang.String getRemark() {
		return remark;
	}
	
	/**
	 * 设置公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注属性
	 *
	 * @param remark
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	/**
     * 获取用户所在的分组ID（暂时兼容用户分组旧接口）属性
     *
     * @return groupid
     */
	public java.lang.String getGroupid() {
		return groupid;
	}
	
	/**
	 * 设置用户所在的分组ID（暂时兼容用户分组旧接口）属性
	 *
	 * @param groupid
	 */
	public void setGroupid(java.lang.String groupid) {
		this.groupid = groupid;
	}
	
	/**
     * 获取用户被打上的标签ID列表属性
     *
     * @return tagid_list
     */
	public java.lang.String getTagidList() {
		return tagid_list;
	}
	
	/**
	 * 设置用户被打上的标签ID列表属性
	 *
	 * @param tagid_list
	 */
	public void setTagidList(java.lang.String tagid_list) {
		this.tagid_list = tagid_list;
	}
	
	/**
     * 获取状态1启用0禁用(拉黑)属性
     *
     * @return status
     */
	public java.lang.Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置状态1启用0禁用(拉黑)属性
	 *
	 * @param status
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WechatUserInfoT");
        sb.append("{id=").append(id);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", subscribe_time=").append(subscribe_time);
        sb.append(", unionid=").append(unionid);
        sb.append(", remark=").append(remark);
        sb.append(", groupid=").append(groupid);
        sb.append(", tagid_list=").append(tagid_list);
        sb.append(", status=").append(status);
		sb.append('}');
        return sb.toString();
    }
    
}