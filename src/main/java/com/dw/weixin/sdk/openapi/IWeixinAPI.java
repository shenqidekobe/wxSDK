package com.dw.weixin.sdk.openapi;

import com.dw.weixin.sdk.cache.base.WxAuthAccountObject;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKException;
import com.dw.weixin.sdk.openapi.factory.WeixinAPInitObject;

/**
 * 微信对外API接口定义
 * 
 * @author kobe
 * */
public abstract interface IWeixinAPI {
	
	
	/**
	 * 接口初始化参数
	 * */
	abstract void init(WxEnumTransform.CALL_API_WAY apiWay,WeixinAPInitObject initObject)throws WeixinSDKException;
	
	/**
	 * 设置第三方平台的component_verify_ticket
	 * */
	abstract void setComponentVerifyTicket(String verifyTicket)throws WeixinSDKException;
	
	/**
	 * 添加一个app到第三方平台
	 * */
	abstract void addAppToThird(String appId,WxAuthAccountObject authApp)throws WeixinSDKException;
	
	/**
	 * 从第三方平台中移除一个app
	 * */
	abstract void removeAppAsThird(String appId)throws WeixinSDKException;
	
	

}