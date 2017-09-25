package com.dw.weixin.sdk.response.oauth;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 网页授权成功返回的用户信息
 * */
public class OAuthGetUserInfoResponse extends WxResponse{

	private static final long serialVersionUID = 2216494236755652483L;

    private String openid;//用户的唯一标识
	
	private String nickname;//用户昵称
	
	private Integer sex;//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	
	private String language;

	private String city;//城市
	
	private String province;//用户个人资料填写的省份
	
	private String country;//国家，如中国为CN
	
	private String headimgurl;//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。

	private Long subscribe_time;
	
	private String privilege;//用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	
	private String unionid;//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
	
	private String remark;
	
	private Integer groupid;

	
	
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Long getSubscribe_time() {
		return subscribe_time;
	}

	public void setSubscribe_time(Long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
}
