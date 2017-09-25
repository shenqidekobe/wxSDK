package com.dw.weixin.sdk.openapi.factory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.cache.base.WxAuthAccountObject;

/**
 * 微信API初始化对象
 * */
public class WeixinAPInitObject implements Serializable{
	
	private static final long serialVersionUID = 6252960683363252110L;
	private String appId;//初始化账号ID
	private String appSecret;//账号密钥
	private String appToken;//帐号定义的token
	private String encodingAesKey;//当前帐号定义的加密key
	
	private Map<String, WxAuthAccountObject> authAppMap=new HashMap<String, WxAuthAccountObject>();//已授权给当前第三方平台的公众号map(公众号ID为key，公众号授权码为value)

	
	public WeixinAPInitObject(){}
	public WeixinAPInitObject(String thirdAppId, String thirdAppSecret,String token){
		this(thirdAppId, thirdAppSecret, token, null, null);
	}
	public WeixinAPInitObject(String appId, String appSecret,
			String appToken, String encodingAesKey, Map<String, WxAuthAccountObject> authAppMap) {
		this.appId = appId;
		this.appSecret = appSecret;
		this.appToken = appToken;
		this.encodingAesKey = encodingAesKey;
		this.authAppMap = authAppMap;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getAppToken() {
		return appToken;
	}
	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}
	public String getEncodingAesKey() {
		return encodingAesKey;
	}
	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}
	public Map<String, WxAuthAccountObject> getAuthAppMap() {
		return authAppMap;
	}
	public void setAuthAppMap(Map<String, WxAuthAccountObject> authAppMap) {
		this.authAppMap = authAppMap;
	}
}
