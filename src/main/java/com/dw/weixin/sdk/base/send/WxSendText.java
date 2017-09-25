package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号发送文本消息
 */
public class WxSendText  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	/**发送消息文本*/
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
