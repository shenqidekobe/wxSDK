package com.dw.weixin.sdk.request;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 对微信服务发起操作请求的请求基类
 * */
public abstract class WxOperRequest<T extends WxResponse>  implements WxRequest<T>,Serializable {

	private static final long serialVersionUID = -6199183404514110229L;

	@Override
	public String getApiMethodUrl() {
		return null;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.POST;
	};
	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId() {
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}

}
