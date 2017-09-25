package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.ThirdGetAuthorizerTokenResponse;

/**
 * 获取（刷新）授权公众号的令牌请求
 * 用于在授权方令牌（authorizer_access_token）失效时，可用刷新令牌（authorizer_refresh_token）获取新的令牌。
 * 请注意，此处token是2小时刷新一次，开发者需要自行进行token的缓存
 * */
public class ThirdGetAuthorizerTokenRequest extends WxThirdRequest<ThirdGetAuthorizerTokenResponse>{
	
	
	private static final long serialVersionUID = -7398472850804178619L;

	private String authorizer_appid;//授权公众号appid
	
	private String authorizer_refresh_token;//授权方的刷新令牌，刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌


	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_AUTHTOKEN_URL;
	}
	
	@Override
	public Class<ThirdGetAuthorizerTokenResponse> getResponseClass() {
		return ThirdGetAuthorizerTokenResponse.class;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.authorizer_appid, "authorizer_appid");
		RequestCheckUtils.checkNotEmpty(this.authorizer_refresh_token, "authorizer_refresh_token");
	}


	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	public String getAuthorizer_appid() {
		return authorizer_appid;
	}

	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}

	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}
	
}
