package com.dw.weixin.sdk.request.template;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.template.GetTemplateIdRequestResponse;

/**
 * 获取模版ID
 * */
public class GetTemplateIdRequest implements WxRequest<GetTemplateIdRequestResponse>{
	
	private String template_id_short;//模板库中模板的编号，
	
	public String getTemplate_id_short() {
		return template_id_short;
	}

	public void setTemplate_id_short(String template_id_short) {
		this.template_id_short = template_id_short;
	}

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.GET_TEMPLATE_ID_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.template_id_short, "template_id_short");
	}

	@Override
	public Class<GetTemplateIdRequestResponse> getResponseClass() {
		return GetTemplateIdRequestResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("template_id_short", this.template_id_short);
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
