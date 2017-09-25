package com.dw.weixin.sdk.base.check;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 微信JS-SDK验证对象
 * */
public class WxJsSDKObject extends WxObject{
	
	private static final long serialVersionUID = -8660041368163900552L;
	private String appId;
    private String timestamp;
    private String nonce;
    private String signature;
    
    
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
