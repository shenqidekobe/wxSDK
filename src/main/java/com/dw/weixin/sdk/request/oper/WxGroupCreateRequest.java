package com.dw.weixin.sdk.request.oper;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.oper.WxGroup;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxGroupCreateResponse;

/**
 * 创建用户分组请求
 * */
public class WxGroupCreateRequest extends WxOperRequest<WxGroupCreateResponse>{
	
	private static final long serialVersionUID = -8171880566180471186L;
	
	private WxGroup group;
	
	public WxGroup getGroup() {
		return group;
	}

	public void setGroup(WxGroup group) {
		this.group = group;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.group.getName(), "group.name");
	}
	
	@Override
	public Class<WxGroupCreateResponse> getResponseClass() {
		return WxGroupCreateResponse.class;
	}
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.CREATE_GROUP_URL;
	}
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}
}
