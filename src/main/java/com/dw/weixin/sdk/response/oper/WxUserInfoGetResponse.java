package com.dw.weixin.sdk.response.oper;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取关注者的详细信息的返回对象信息
 * */
public class WxUserInfoGetResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;
	
	public static enum SEX {
        NONE(0), MALE(1), FEMALE(2);
        private int i;

        SEX(int i) {
            this.i = i;
        }
        public static SEX valueOf(int i) {
            if (i == 1) {
                return MALE;
            } else if (i == 2) {
                return FEMALE;
            } else {
                return NONE;
            }
        };
        public int getValue() {
            return this.i;
        }
    }


	private String subscribe;

	private String openid;
	
	private String nickname;
	
	private Integer sex;
	
	private String language;

	private String city;
	
	private String province;
	
	private String country;
	
	private String headimgurl;

	private Long subscribe_time;//关注事件，单位为分钟
	
	private String unionid;
	
	private String remark;
	
	private Integer groupid;
	

	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

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