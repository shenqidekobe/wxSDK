package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号发送语音消息
 */
public class WxSendVoice  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	/**发送语音消息*/
	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

}
