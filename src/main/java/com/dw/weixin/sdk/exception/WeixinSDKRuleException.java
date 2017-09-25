package com.dw.weixin.sdk.exception;

public class WeixinSDKRuleException extends WeixinSDKException {
	private static final long serialVersionUID = -7787145910600194272L;

	public WeixinSDKRuleException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}
}