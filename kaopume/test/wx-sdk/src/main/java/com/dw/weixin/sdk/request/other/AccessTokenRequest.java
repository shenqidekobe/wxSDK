package com.dw.weixin.sdk.request.other;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.other.AccessTokenResponse;

/**
 * 获取微信公众号的access_token请求
 * */
public class AccessTokenRequest implements WxRequest<AccessTokenResponse>{
	
	private String grant_type="client_credential";
	
	private String appid;//公众号ID
	
	private String secret;//公众号密钥

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.ACCESS_TOKEN_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.appid, "appid");
		RequestCheckUtils.checkNotEmpty(this.secret, "secret");
	}

	@Override
	public Class<AccessTokenResponse> getResponseClass() {
		return AccessTokenResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.POST;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId(){
		return null;
	}
	
	@Override
	public String getAccessTokenParamName() {
		return null;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
}
