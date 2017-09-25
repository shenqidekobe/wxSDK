package com.dw.weixin.sdk.response.third;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取（刷新）授权公众号的令牌的返回对象
 * */
public class ThirdGetAuthorizerTokenResponse extends WxResponse{
	
	private static final long serialVersionUID = -6728834965143994020L;

	private String authorizer_access_token;//授权方令牌
	
	private Integer expires_in;//有效期
	
	private String authorizer_refresh_token;//刷新令牌

	public String getAuthorizer_access_token() {
		return authorizer_access_token;
	}

	public void setAuthorizer_access_token(String authorizer_access_token) {
		this.authorizer_access_token = authorizer_access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}

	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}
	
}
