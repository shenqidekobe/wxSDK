package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 被动发送语音
 */
public class PvSendVoice extends WxObject{

	private static final long serialVersionUID = 8752097230325075609L;
	
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
