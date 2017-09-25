package com.dw.weixin.sdk.request.template;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.template.GetTemplateListRequestResponse;

/**
 * 获取模版列表
 * */
public class GetTemplateListRequest implements WxRequest<GetTemplateListRequestResponse>{
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.GET_TEMPLATE_ID_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
	}

	@Override
	public Class<GetTemplateListRequestResponse> getResponseClass() {
		return GetTemplateListRequestResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> map=new HashMap<String, String>();
		return map;
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
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.GET;
	}

	@Override
	public Integer getApiFuncInfoId() {
		return null;
	}

	
}
