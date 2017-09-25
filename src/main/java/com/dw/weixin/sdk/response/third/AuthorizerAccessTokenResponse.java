package com.dw.weixin.sdk.response.third;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取第三方平台的token返回对象信息
 * */
public class AuthorizerAccessTokenResponse extends WxResponse{

	private static final long serialVersionUID = -6146359589178107751L;
	
	private String component_access_token;//token值
	
	private Integer expires_in;//有效期

	public String getComponent_access_token() {
		return component_access_token;
	}

	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
}
