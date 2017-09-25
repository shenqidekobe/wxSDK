package com.dw.weixin.sdk.request.oper;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxGroupsGetResponse;

/**
 * 获取用户分组请求
 * */
public class WxGroupsGetRequest extends WxOperRequest<WxGroupsGetResponse> {
	
	private static final long serialVersionUID = 3625934592281615904L;
	
	@Override
	public void check() throws WeixinSDKRuleException {
	}
	
	@Override
	public Class<WxGroupsGetResponse> getResponseClass() {
		return WxGroupsGetResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		HashMap<String, String> txtParams = new HashMap<String, String>();
		return txtParams;
	}

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.FIND_GROUP_URL;
	};
	
	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.GET;
	};
	
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}
}
