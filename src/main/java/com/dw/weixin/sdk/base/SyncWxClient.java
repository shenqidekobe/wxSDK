package com.dw.weixin.sdk.base;

import com.dw.weixin.sdk.exception.WeixinSDKException;

public abstract interface SyncWxClient {
	
	public abstract <T extends WxResponse> T execute(WxRequest<T> paramRequest) throws WeixinSDKException;;
	
}