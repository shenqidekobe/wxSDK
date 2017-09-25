package com.dw.weixin.sdk.cache.base;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信账号对象
 * */
public class WxAccountObject implements Serializable{

	private static final long serialVersionUID = 1615806796316802314L;
	
	/**
	 * 存储的帐号类型{第三方平台下的公众号，微信公众号}
	 * */
	public enum ACCOUNT_TYPE{
		THIRD_PLATFORM,WECHAT_PUBLIC
	}
	
	private String token;//token内容
	private Date createTime;//token的存储时间
	private ACCOUNT_TYPE accountType;//账号类型
	
	private String jsAPITicket;//JS-SDK的ticket
	private Date jsTicketCreateTime;//JS-SDK的ticket的存储时间
	
	private String accountAppSecret;//帐号的密钥
	private String accountToken;//当前帐号定义的token
	private String encodingAesKey;//当前帐号定义的加密key
	private Map<String, WxAuthAccountObject> authAppMap=new HashMap<String, WxAuthAccountObject>();//当前第三方平台已授权成功的公众号
	
	public WxAccountObject(){}
	
	public WxAccountObject(ACCOUNT_TYPE accountType){
		this.accountType=accountType;
	}
	
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public ACCOUNT_TYPE getAccountType() {
		return accountType;
	}
	public void setAccountType(ACCOUNT_TYPE accountType) {
		this.accountType = accountType;
	}
	public String getJsAPITicket() {
		return jsAPITicket;
	}
	public void setJsAPITicket(String jsAPITicket) {
		this.jsAPITicket = jsAPITicket;
	}
	public Date getJsTicketCreateTime() {
		return jsTicketCreateTime;
	}
	public void setJsTicketCreateTime(Date jsTicketCreateTime) {
		this.jsTicketCreateTime = jsTicketCreateTime;
	}
	public String getAccountAppSecret() {
		return accountAppSecret;
	}

	public void setAccountAppSecret(String accountAppSecret) {
		this.accountAppSecret = accountAppSecret;
	}

	public String getAccountToken() {
		return accountToken;
	}

	public void setAccountToken(String accountToken) {
		this.accountToken = accountToken;
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
