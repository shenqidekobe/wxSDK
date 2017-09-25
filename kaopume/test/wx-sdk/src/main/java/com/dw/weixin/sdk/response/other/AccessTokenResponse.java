package com.dw.weixin.sdk.response.other;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取公众号的AccessToken的返回对象信息
 * */
public class AccessTokenResponse extends WxResponse{

	private static final long serialVersionUID = 7107451721718687476L;
	
	private String access_token;//返回的token
	
	private Integer expires_in;//token的有效期

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
}
