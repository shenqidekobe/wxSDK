package com.dw.weixin.sdk.exception;

public class WeixinSDKException extends Exception {
	private static final long serialVersionUID = -238091758285157331L;
	private String errCode;
	private String errMsg;

	public WeixinSDKException() {
	}

	public WeixinSDKException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeixinSDKException(String message) {
		super(message);
	}

	public WeixinSDKException(Throwable cause) {
		super(cause);
	}

	public WeixinSDKException(String errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public String getErrMsg() {
		return this.errMsg;
	}
}