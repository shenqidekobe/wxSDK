package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号发送音乐消息
 */
public class WxSendMusic  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	private String title;
	
	private String description;

	private String musicurl;
	
	private String hqmusicurl;
	
	private String thumb_media_id;

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

	public String getMusicurl() {
		return musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	public String getHqmusicurl() {
		return hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	
}
