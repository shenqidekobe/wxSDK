package com.dw.weixin.sdk.request.send;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dw.weixin.sdk.base.send.PvSendNewsArticles;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.PvSendRequest;
/**
 * 被动发送图文消息接口类
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class PvSendNewsRequest  extends PvSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	/**图文消息个数，限制为10条以内*/
	private Integer ArticleCount;
	
	/**多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应*/
	private List<PvSendNewsArticles> Articles;
	
	public Integer getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}
	public List<PvSendNewsArticles> getArticles() {
		return Articles;
	}
	public void setArticles(List<PvSendNewsArticles> articles) {
		Articles = articles;
	}


	public PvSendNewsRequest() {
		setMsgType(WxEnumTransform.MSG_TYPE.news.toString());
	}


	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		mapClass.put("item", PvSendNewsArticles.class);
		return mapClass;
	}
}
