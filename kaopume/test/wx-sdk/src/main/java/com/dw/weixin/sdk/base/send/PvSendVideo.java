package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 被动发送视频
 *
 */
public class PvSendVideo extends WxObject{

	private static final long serialVersionUID = 6526063680852888595L;
	/**视频消息的标题*/
	private String Title;
	/**视频消息的描述*/
	private String Description;
	
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
