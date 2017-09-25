package com.dw.weixin.sdk.request.oper;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.oper.WxGroup;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxGroupUpdateResponse;

/**
 * 修改用户分组请求
 * */
public class WxGroupUpdateRequest extends WxOperRequest<WxGroupUpdateResponse>{
	
	private static final long serialVersionUID = 7055734655710729663L;
	
	private WxGroup group;
	
	public WxGroup getGroup() {
		return group;
	}

	public void setGroup(WxGroup group) {
		this.group = group;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.group.getId(), "group.id");
		RequestCheckUtils.checkNotEmpty(this.group.getName(), "group.name");
	}
	
	@Override
	public Class<WxGroupUpdateResponse> getResponseClass() {
		return WxGroupUpdateResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.UPDATE_GROUP_URL;
	};
	
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}
	
}
