package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.ThirdGetAuthorizerOptionResponse;

/**
 * 获取授权方的选项设置信息的请求
 * */
public class ThirdGetAuthorizerOptionRequest extends WxThirdRequest<ThirdGetAuthorizerOptionResponse>{
	
	
	private static final long serialVersionUID = 4876997650105752925L;

	private String authorizer_appid;//授权公众号appid
	
	private String option_name;//选项名称

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_GETOPTION_URL;
	}
	
	@Override
	public Class<ThirdGetAuthorizerOptionResponse> getResponseClass() {
		return ThirdGetAuthorizerOptionResponse.class;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.authorizer_appid, "authorizer_appid");
		RequestCheckUtils.checkNotEmpty(this.option_name, "option_name");
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

	public String getOption_name() {
		return option_name;
	}

	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	
}
