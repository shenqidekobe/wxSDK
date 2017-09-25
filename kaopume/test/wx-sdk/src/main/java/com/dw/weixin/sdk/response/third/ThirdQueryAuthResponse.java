package com.dw.weixin.sdk.response.third;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.thrid.ThridAuthInfoObject;

/**
 * 使用授权码换取公众号的授权信息的返回对象
 * */
public class ThirdQueryAuthResponse extends WxResponse{

	private static final long serialVersionUID = -8083255046023909533L;
	
	private ThridAuthInfoObject authorization_info;//授权方信息

	public ThridAuthInfoObject getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(ThridAuthInfoObject authorization_info) {
		this.authorization_info = authorization_info;
	}
	
}
