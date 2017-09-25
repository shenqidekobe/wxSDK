package com.dw.weixin.sdk.request.oper;

import java.util.Map;

import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxMenuDeleteGetResponse;

/**
 * 删除自定义菜单请求
 * */
public class WxMenuDeleteGetRequest extends WxOperRequest<WxMenuDeleteGetResponse>{
	
	private static final long serialVersionUID = -1982516092341375477L;
	
	@Override
	public void check() throws WeixinSDKRuleException {
		
	}
	
	@Override
	public Class<WxMenuDeleteGetResponse> getResponseClass() {
		return WxMenuDeleteGetResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	};
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.REMOVE_MENU_URL;
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
