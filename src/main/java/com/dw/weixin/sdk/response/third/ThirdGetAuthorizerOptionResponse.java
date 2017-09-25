package com.dw.weixin.sdk.response.third;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取授权方的选项设置信息的返回对象
 * */
public class ThirdGetAuthorizerOptionResponse extends WxResponse{
	
	private static final long serialVersionUID = 5947376135478990660L;

	private String authorizer_appid;//授权公众号appid
	
	private String option_name;//选项名称
	
	private String option_value;//选项值

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
