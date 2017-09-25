package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 被动发送图文消息对象
 */
public class PvSendNewsArticles extends WxObject{
	
	private static final long serialVersionUID = 3060830614246697782L;

	/**图文消息标题*/
	private String Title;
	/**图文消息描述*/
	private String Description;
	/**图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200*/
	private String Url;
	/**点击图文消息跳转链接*/
	private String PicUrl;

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

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
