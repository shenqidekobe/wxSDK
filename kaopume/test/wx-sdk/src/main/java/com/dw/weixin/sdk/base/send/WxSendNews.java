package com.dw.weixin.sdk.base.send;

import java.util.List;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号发送图文消息
 */
public class WxSendNews  extends WxObject{

	private static final long serialVersionUID = -8290081705863602720L;
	
	/**发送图文消息列表*/
	private List<WxSendNewsArticles> articles;

	public List<WxSendNewsArticles> getArticles() {
		return articles;
	}

	public void setArticles(List<WxSendNewsArticles> articles) {
		this.articles = articles;
	}

}
