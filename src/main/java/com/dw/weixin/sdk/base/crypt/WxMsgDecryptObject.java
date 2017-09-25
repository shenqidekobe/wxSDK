package com.dw.weixin.sdk.base.crypt;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 微信消息解密Object
 *  * encrypt:加密后的密文
 *	* msgSignature:加密后的消息签名字符串
 *  * timestamp:时间戳,加密时的时间戳
 *	* nonceStr:随机字符串,加密时的随机字符串
 *	
 * */
public class WxMsgDecryptObject extends WxObject{

	private static final long serialVersionUID = -8789641310206735118L;
	
	private String encrypt;
	
	private String msgSignature;
	
	private String timestamp;
	
	private String nonceStr;
	
	public WxMsgDecryptObject(){}

	public WxMsgDecryptObject(String encrypt, String msgSignature,
			String timestamp, String nonceStr) {
		this.encrypt = encrypt;
		this.msgSignature = msgSignature;
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getMsgSignature() {
		return msgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
}
