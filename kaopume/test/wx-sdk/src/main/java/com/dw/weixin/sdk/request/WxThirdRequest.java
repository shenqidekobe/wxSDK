package com.dw.weixin.sdk.request;

import java.io.Serializable;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 微信第三方平台请求基类
 * */
public abstract class WxThirdRequest<T extends WxResponse> implements WxRequest<T>,Serializable{

	private static final long serialVersionUID = -2964194901813813257L;
	
	private String component_appid;//第三方平台appid
	
	public void check() throws WeixinSDKRuleException{
		RequestCheckUtils.checkNotEmpty(this.component_appid, "component_appid");
	};
	
	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.POST;
	}
	
	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.THIRD_ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId(){
		return null;
	}

	public String getComponent_appid() {
		return component_appid;
	}

	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}
}
