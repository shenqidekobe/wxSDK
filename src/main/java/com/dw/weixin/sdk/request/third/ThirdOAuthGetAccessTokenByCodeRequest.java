package com.dw.weixin.sdk.request.third;

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
 * 代公众号授权发起获取access_token的请求
 * 
 * @author kobe
 * */
public class ThirdOAuthGetAccessTokenByCodeRequest implements WxRequest<OAuthGetAccessTokenByCodeResponse>{

	private String appid;//公众号的appid
	private String code;//填写第一步获取的code参数
	private String grant_type="authorization_code";//填
	private String component_appid;//服务方的appid
	private String component_access_token;//服务开发方的access_token
	
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.OAUTH2_THIRD_ACCESS_TOKEN_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.appid, "appid");
		RequestCheckUtils.checkNotEmpty(this.code, "code");
		RequestCheckUtils.checkNotEmpty(this.component_appid, "component_appid");
	}

	@Override
	public Class<OAuthGetAccessTokenByCodeResponse> getResponseClass() {
		return OAuthGetAccessTokenByCodeResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("appid", this.appid);
		map.put("code", this.code);
		map.put("grant_type", this.grant_type);
		map.put("component_appid", this.component_appid);
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

	public String getComponent_appid() {
		return component_appid;
	}

	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

	public String getComponent_access_token() {
		return component_access_token;
	}

	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

}
