package com.dw.weixin.sdk.base;

import java.util.Map;

import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 微信请求抽象接口
 * */
public abstract interface WxRequest<T extends WxResponse>  {

	/**
	 * 请求的地址
	 * */
	public abstract String getApiMethodUrl();
	
	/**
	 * 验证请求参数
	 * */
	public abstract void check() throws WeixinSDKRuleException;
	
	/**
	 * 请求返回的类类型
	 * */
	public abstract Class<T> getResponseClass();
	
	/**
	 * 请求额外的特殊参数
	 * */
	public abstract Map<String, String> getTextParams();
	
	/**
	 * 请求的类型
	 * */
	public abstract String getApiMethodRequestType();
	
	/**
	 * 微信请求中的accessToken名
	 * 主要用于区分第三方的接口和微信公众号的接口
	 * */
	public abstract String getAccessTokenParamName();
	
	/**
	 * 请求处理方式
	 * 默认常规http请求，其他还包括上传文件请求和下载文件请求
	 * */
	public abstract String getRequestProcessWay();
	
	/**
	 * 请求接口所属的权限集ID
	 * */
	public abstract Integer getApiFuncInfoId();
}