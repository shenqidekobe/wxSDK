package com.dw.weixin.sdk.request.template;

import java.util.Map;

import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 微信模版消息发送
 * */
public class WxTemplateMsgRequest extends WxSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private String template_id;//模板ID
	private String url;//模板跳转链接 非必填
	private Map<String,String> miniprogram;//跳小程序所需数据，不需跳小程序可不用传该数据
	private Map<String, Map<String,String>> data;
	
	@Override
	public String getMsgtype() {
		return null;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getMiniprogram() {
		return miniprogram;
	}

	public void setMiniprogram(Map<String, String> miniprogram) {
		this.miniprogram = miniprogram;
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.SEND_TEMPLATE_MSG_URL;
	}
	
}
