package com.dw.weixin.sdk.openapi;

import java.util.Map;

import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.exception.WeixinSDKException;

/**
 * 微信SDK访问入口
 * */
public interface IWeixinBasisAPI extends IWeixinAPI{
	
	/**
	 * 发送请求到微信服务器
	 * 
	 * @param WxRequest:请求参数
	 * 
	 * @return WxResponse
	 * */
	WxResponse sendReq(WxRequest<?> req)throws WeixinSDKException;
	
	/**
	 * 发送请求到微信服务器
	 * 
	 * @param WxRequest:请求参数
	 * @param authorizerAppId:代公众号ID
	 * 
	 * @return WxResponse
	 * */
	WxResponse sendReq(WxRequest<?> req,String authorizerAppId)throws WeixinSDKException;
	
	
	/**
	 * JS-SDK签名验证
	 * 
	 * @param appId:帐号ID
	 * @param url:验证url
	 * 
	 * @return Map<String,String>
	 * */
	Map<String,String> checkJSAPISignature(String appId,String url)throws WeixinSDKException;
	

}
