package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 被动发送图片
 */
public class PvSendImage extends WxObject{

	private static final long serialVersionUID = -7903248512264889849L;
	
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
