package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号发送视频消息
 */
public class WxSendVideo  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	/**发送视频消息*/
	private String media_id;
	
	private String title;
	
	private String description;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
