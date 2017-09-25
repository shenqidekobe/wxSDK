package com.dw.weixin.sdk.base.thrid;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 公众号的授权信息
 * */
public class ThridAuthInfoObject extends WxObject{
	
	private static final long serialVersionUID = -3036556739219892439L;

	private String authorizer_appid;//授权方appid
	
	private String authorizer_access_token;//授权方令牌（在授权的公众号具备API权限时，才有此返回值）
	
	private Integer expires_in;//有效期（在授权的公众号具备API权限时，才有此返回值）
	
	private String authorizer_refresh_token;//刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token
	
	private String func_info;

	public String getAuthorizer_appid() {
		return authorizer_appid;
	}

	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

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

	public String getFunc_info() {
		return func_info;
	}

	public void setFunc_info(String func_info) {
		this.func_info = func_info;
	}
	
}
