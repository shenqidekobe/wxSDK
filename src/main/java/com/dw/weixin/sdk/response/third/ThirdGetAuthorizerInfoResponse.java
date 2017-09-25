package com.dw.weixin.sdk.response.third;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.thrid.ThridAuthorizationObject;
import com.dw.weixin.sdk.base.thrid.ThridAuthorizerObject;

/**
 * 获取授权方账户信息的返回对象
 * */
public class ThirdGetAuthorizerInfoResponse extends WxResponse{

	private static final long serialVersionUID = -5540730616867712500L;
	
	private ThridAuthorizerObject authorizer_info;
	
	private ThridAuthorizationObject authorization_info;

	public ThridAuthorizerObject getAuthorizer_info() {
		return authorizer_info;
	}

	public void setAuthorizer_info(ThridAuthorizerObject authorizer_info) {
		this.authorizer_info = authorizer_info;
	}

	public ThridAuthorizationObject getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(ThridAuthorizationObject authorization_info) {
		this.authorization_info = authorization_info;
	}
	
}
