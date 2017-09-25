package com.dw.weixin.sdk.request.third;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxThirdRequest;
import com.dw.weixin.sdk.response.third.ThirdSetAuthorizerOptionResponse;

/**
 * 设置授权方的选项信息的请求
 * 
 *  location_report(地理位置上报选项)	0	无上报 1	进入会话时上报 2	每5s上报
 *  voice_recognize（语音识别开关选项）0	关闭语音识别 1开启语音识别
 *  customer_service（客服开关选项）	0	关闭多客服 1	开启多客服
 * */
public class ThirdSetAuthorizerOptionRequest extends WxThirdRequest<ThirdSetAuthorizerOptionResponse>{
	
	
	private static final long serialVersionUID = -1807847851533700349L;

	private String authorizer_appid;//授权公众号appid
	
	private String option_name;//选项名称
	
	private String option_value;//选项值

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.THRID_SETOPTIN_URL;
	}
	
	@Override
	public Class<ThirdSetAuthorizerOptionResponse> getResponseClass() {
		return ThirdSetAuthorizerOptionResponse.class;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.authorizer_appid, "authorizer_appid");
		RequestCheckUtils.checkNotEmpty(this.option_name, "option_name");
		RequestCheckUtils.checkNotEmpty(this.option_value, "option_value");
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

	public String getOption_value() {
		return option_value;
	}

	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}

}
