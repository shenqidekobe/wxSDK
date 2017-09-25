package com.dw.weixin.sdk.response.third;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取预授权码的返回对象
 * */
public class ThirdPreauthCodeResponse extends WxResponse{
	
	private static final long serialVersionUID = 8894347526199279867L;

	private String pre_auth_code;//预授权码
	
	private Integer expires_in;//有效期，20分钟

	public String getPre_auth_code() {
		return pre_auth_code;
	}

	public void setPre_auth_code(String pre_auth_code) {
		this.pre_auth_code = pre_auth_code;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
}
