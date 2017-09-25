package com.dw.weixin.sdk.base.crypt;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 微信消息加密Object
 *	 * timestamp:时间戳
 *   * nonceStr:随机字符串
 *   * replyMsg:需加密的消息
 *   
 * */
public class WxMsgEncryptObject extends WxObject{

	private static final long serialVersionUID = 6934900406616725296L;
	
	private String timestamp;
	
	private String nonceStr;
	
	private String replyMsg;
	
	public WxMsgEncryptObject(){}

	public WxMsgEncryptObject(String timestamp, String nonceStr,String replyMsg) {
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
		this.replyMsg=replyMsg;
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

	public String getReplyMsg() {
		return replyMsg;
	}

	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}
}
