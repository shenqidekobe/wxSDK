package com.dw.weixin.sdk.response.receive;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.WxReceiveResponse;
/**
 * 接收链接消息
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxReceiveLinkResponse  extends WxReceiveResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	/**消息标题*/
	private String  Title;
	/**消息描述*/
	private String  Description;
	/**消息链接*/
	private Integer  Url;
	
	public WxReceiveLinkResponse() {
		setMsgType(WxEnumTransform.MSG_TYPE.link.toString());
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
	public Integer getUrl() {
		return Url;
	}
	public void setUrl(Integer url) {
		Url = url;
	}
	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}
	
}
