package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.ThirdGetAuthorizerInfoResponse;

/**
 * 获取授权方信息的请求
 * */
public class ThirdGetAuthorizerInfoRequest extends WxThirdRequest<ThirdGetAuthorizerInfoResponse>{
	
	private static final long serialVersionUID = 7619740984640013579L;
	
	private String authorizer_appid;//授权方appid

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_ACCOUNTINFO_URL;
	}
	
	@Override
	public Class<ThirdGetAuthorizerInfoResponse> getResponseClass() {
		return ThirdGetAuthorizerInfoResponse.class;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.authorizer_appid, "authorizer_appid");
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	public String getAuthorizer_appid() {
		return authorizer_appid;
	}

	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

}
