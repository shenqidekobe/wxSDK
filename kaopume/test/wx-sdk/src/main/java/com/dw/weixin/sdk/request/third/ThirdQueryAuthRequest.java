package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.ThirdQueryAuthResponse;

/**
 * 使用授权码换取公众号的授权信息的请求
 * */
public class ThirdQueryAuthRequest extends WxThirdRequest<ThirdQueryAuthResponse>{
	

	private static final long serialVersionUID = -6145251234205486330L;
	
	private String authorization_code;//授权code,会在授权成功时返回给第三方平台


	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_AUTHINFO_URL;
	}
	
	@Override
	public Class<ThirdQueryAuthResponse> getResponseClass() {
		return ThirdQueryAuthResponse.class;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.authorization_code, "authorization_code");
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	public String getAuthorization_code() {
		return authorization_code;
	}

	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}

}
