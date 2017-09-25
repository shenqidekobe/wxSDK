package com.dw.weixin.sdk.request.oauth;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.oauth.OAuthGetUserInfoResponse;

/**
 * 代公众号授权发起获取用户基本信息的请求
 * 
 * @author kobe
 * */
public class OAuthGetUserInfoRequest implements WxRequest<OAuthGetUserInfoResponse>{

	private String access_token;//网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	private String openid;//用户的唯一标识
	private String lang=WxEnumTransform.LANG_TYPE.zh_CN.name();//返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.OAUTH2_USERINFO_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.access_token, "access_token");
		RequestCheckUtils.checkNotEmpty(this.openid, "openid");
	}

	@Override
	public Class<OAuthGetUserInfoResponse> getResponseClass() {
		return OAuthGetUserInfoResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("access_token", this.access_token);
		map.put("openid", this.openid);
		map.put("lang", this.lang);
		return map;
	}

	@Override
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.GET;
	}

	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.NO_ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId() {
		return null;
	}

	
	
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
