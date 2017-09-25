package com.dw.weixin.sdk.request.oauth;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.oauth.OAuthGetAccessTokenByCodeResponse;

/**
 * 通过code换取accessToken
 * 
 * @author kobe
 * */
public class OAuthGetAccessTokenByCodeRequest implements WxRequest<OAuthGetAccessTokenByCodeResponse>{

	private String appid;//公众号的appid
	private String secret;//密钥
	private String code;//填写第一步获取的code参数
	private String grant_type="authorization_code";//填
	
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.OAUTH2_ACCESS_TOKEN_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.appid, "appid");
		RequestCheckUtils.checkNotEmpty(this.secret, "secret");
		RequestCheckUtils.checkNotEmpty(this.code, "code");
	}

	@Override
	public Class<OAuthGetAccessTokenByCodeResponse> getResponseClass() {
		return OAuthGetAccessTokenByCodeResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("appid", this.appid);
		map.put("secret", this.secret);
		map.put("code", this.code);
		map.put("grant_type", this.grant_type);
		return map;
	}

	@Override
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.GET;
	}

	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.THIRD_ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId() {
		return null;
	}
	
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
