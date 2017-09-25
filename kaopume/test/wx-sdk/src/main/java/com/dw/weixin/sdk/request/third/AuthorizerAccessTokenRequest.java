package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.AuthorizerAccessTokenResponse;

/**
 * 获取第三方平台的token请求
 * */
public class AuthorizerAccessTokenRequest extends WxThirdRequest<AuthorizerAccessTokenResponse>{
	
	private static final long serialVersionUID = 2131803966324056457L;

	private String component_appsecret;//第三方平台appsecret
	
	private String component_verify_ticket;//微信后台推送的ticket，此ticket会定时推送，具体请见本页末尾的推送说明

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_ACCESS_TOKEN_URL;
	}
	
	@Override
	public Class<AuthorizerAccessTokenResponse> getResponseClass() {
		return AuthorizerAccessTokenResponse.class;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.component_appsecret, "component_appsecret");
		RequestCheckUtils.checkNotEmpty(this.component_verify_ticket, "component_verify_ticket");
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.POST;
	}
	
	@Override
	public String getAccessTokenParamName() {
		return null;
	}

	public String getComponent_appsecret() {
		return component_appsecret;
	}

	public void setComponent_appsecret(String component_appsecret) {
		this.component_appsecret = component_appsecret;
	}

	public String getComponent_verify_ticket() {
		return component_verify_ticket;
	}

	public void setComponent_verify_ticket(String component_verify_ticket) {
		this.component_verify_ticket = component_verify_ticket;
	}
	
}
