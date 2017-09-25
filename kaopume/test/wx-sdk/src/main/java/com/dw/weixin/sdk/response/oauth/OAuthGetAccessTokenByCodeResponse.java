package com.dw.weixin.sdk.response.oauth;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 代网页授权获取access_token返回的对象信息
 * */
public class OAuthGetAccessTokenByCodeResponse extends WxResponse{

	private static final long serialVersionUID = 3421483333587855291L;

	private String access_token;//	接口调用凭证
	private Integer expires_in;//	access_token接口调用凭证超时时间，单位（秒）
	private String refresh_token;//	用户刷新access_token
	private String openid;//	授权用户唯一标识
	private String scope;//	用户授权的作用域，使用逗号（,）分隔
	
	
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
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
