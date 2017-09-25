package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号发送图文消息子对象
 */
public class WxSendNewsArticles extends WxObject{
	
	private static final long serialVersionUID = 3060830614246697782L;

	private String title;

	private String description;
	
	private String url;
	
	private String picurl;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
	
}
