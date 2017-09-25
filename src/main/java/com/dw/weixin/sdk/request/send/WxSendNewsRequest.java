package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendNews;
import com.dw.weixin.sdk.base.send.WxSendNewsArticles;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 发送图文消息的请求数据对象
 * */
public class WxSendNewsRequest  extends WxSendRequest {
	private static final long serialVersionUID = 3622502979765940119L;
	
	private WxSendNews news;
	
	private Integer ArticleCount;//图文条数，最多十条
	private WxSendNewsArticles article;//单条图文消息

	public WxSendNews getNews() {
		return news;
	}

	public void setNews(WxSendNews news) {
		this.news = news;
	}

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.news.toString();
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}

	public Integer getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}

	public WxSendNewsArticles getArticle() {
		return article;
	}

	public void setArticle(WxSendNewsArticles article) {
		this.article = article;
	}

}
