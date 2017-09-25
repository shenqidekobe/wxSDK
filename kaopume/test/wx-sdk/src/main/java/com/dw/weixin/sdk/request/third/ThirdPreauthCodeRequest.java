package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.ThirdPreauthCodeResponse;

/**
 * 获取第三方的预授权码请求
 * */
public class ThirdPreauthCodeRequest extends WxThirdRequest<ThirdPreauthCodeResponse>{
	
	private static final long serialVersionUID = -3733129448990848031L;

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_AUTHCODE_URL;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public Class<ThirdPreauthCodeResponse> getResponseClass() {
		return ThirdPreauthCodeResponse.class;
	}

}
