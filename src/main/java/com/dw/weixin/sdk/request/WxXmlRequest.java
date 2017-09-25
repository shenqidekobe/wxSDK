package com.dw.weixin.sdk.request;

import java.util.Map;

import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;

public abstract interface WxXmlRequest<C> extends WxRequest<WxResponse>  {

	public abstract Map<String, C> getRequestContainClass();
	
}