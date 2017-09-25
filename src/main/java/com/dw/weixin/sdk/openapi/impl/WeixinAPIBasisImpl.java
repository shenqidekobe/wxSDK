package com.dw.weixin.sdk.openapi.impl;

import java.util.Map;

import com.dw.weixin.sdk.DefaultSyncWxClient;
import com.dw.weixin.sdk.WxCheckArithmetic;
import com.dw.weixin.sdk.base.SyncWxClient;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.cache.WxAccountPoolManager;
import com.dw.weixin.sdk.exception.WeixinSDKException;
import com.dw.weixin.sdk.openapi.IWeixinBasisAPI;

/**
 * 微信API的基础实现
 * */
public class WeixinAPIBasisImpl extends WeixinBaseAPI implements IWeixinBasisAPI{

	@Override
	public WxResponse sendReq(WxRequest<?> req,String authorizerAppId)throws WeixinSDKException {
		SyncWxClient client=new DefaultSyncWxClient(authorizerAppId);
		return client.execute(req);
	}

	@Override
	public Map<String,String> checkJSAPISignature(String appId,String url)throws WeixinSDKException{
		String jsapiTicket=WxAccountPoolManager.produceJsSDKTicket(appId);
		return WxCheckArithmetic.checkJsSDKSign(jsapiTicket, url);
	}

	@Override
	public WxResponse sendReq(WxRequest<?> req) throws WeixinSDKException {
		return sendReq(req,null);
	}

}
