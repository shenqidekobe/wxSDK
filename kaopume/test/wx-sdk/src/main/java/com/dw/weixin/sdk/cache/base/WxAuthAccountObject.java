package com.dw.weixin.sdk.cache.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 微信已授权给第三方平台的帐号对象
 * */
public class WxAuthAccountObject implements Serializable{
	
	private static final long serialVersionUID = -8796571968383241543L;
	
	private String authorizerAccessToken;//授权公众号的accessToken
	private Date createTokenTime;//授权公众号accessToken创建时间
	
	private String authCode;//授权方的授权码
	private Date authCreateTime; //刷新令牌的存储时间
	
	private String authorizerRefreshToken;//授权方的刷新令牌
	private Date createRefreshTokenTime;//授权方的刷新令牌创建时间
	
	private List<Integer> funcList=new ArrayList<Integer>();//授权给第三方平台的权限集

	
	public WxAuthAccountObject(){}
	public WxAuthAccountObject(String authCode) {
		this.authCode = authCode;
	}
	public WxAuthAccountObject(String authCode, String authorizerRefreshToken,
			Date authCreateTime, List<Integer> funcList) {
		this.authCode = authCode;
		this.authorizerRefreshToken = authorizerRefreshToken;
		this.authCreateTime = authCreateTime;
		this.funcList = funcList;
	}
	
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}
	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}
	public Date getCreateTokenTime() {
		return createTokenTime;
	}
	public void setCreateTokenTime(Date createTokenTime) {
		this.createTokenTime = createTokenTime;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	public Date getAuthCreateTime() {
		return authCreateTime;
	}
	public void setAuthCreateTime(Date authCreateTime) {
		this.authCreateTime = authCreateTime;
	}
	public Date getCreateRefreshTokenTime() {
		return createRefreshTokenTime;
	}
	public void setCreateRefreshTokenTime(Date createRefreshTokenTime) {
		this.createRefreshTokenTime = createRefreshTokenTime;
	}
	public List<Integer> getFuncList() {
		return funcList;
	}
	public void setFuncList(List<Integer> funcList) {
		this.funcList = funcList;
	}
}
