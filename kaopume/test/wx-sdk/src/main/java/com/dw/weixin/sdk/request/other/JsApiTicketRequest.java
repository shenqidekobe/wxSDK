package com.dw.weixin.sdk.request.other;

import java.util.Map;

import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.other.JsApiTicketResponse;

/**
 * 获取微信JS-SDK的ticket请求
 * */
public class JsApiTicketRequest implements WxRequest<JsApiTicketResponse>{
	
	private String type="jsapi";

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.JS_TICKET_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
	}

	@Override
	public Class<JsApiTicketResponse> getResponseClass() {
		return JsApiTicketResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.POST;
	}
	
	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId(){
		return null;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
