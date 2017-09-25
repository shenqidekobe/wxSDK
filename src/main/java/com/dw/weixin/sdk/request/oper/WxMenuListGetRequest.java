package com.dw.weixin.sdk.request.oper;

import java.util.Map;

import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxMenuListGetResponse;

/**
 * 获取自定义菜单请求
 * */
public class WxMenuListGetRequest extends WxOperRequest<WxMenuListGetResponse>{
	
	private static final long serialVersionUID = -2082293270336452256L;
	
	@Override
	public void check() throws WeixinSDKRuleException {
		
	}
	
	@Override
	public Class<WxMenuListGetResponse> getResponseClass() {
		return WxMenuListGetResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	};
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.FIND_MENU_URL;
	};
	
	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.GET;
	};
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.MSGANDMENU_FUNC_ID;
	}
}
