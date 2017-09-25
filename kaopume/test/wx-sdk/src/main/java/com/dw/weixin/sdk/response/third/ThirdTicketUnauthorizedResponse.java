package com.dw.weixin.sdk.response.third;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.response.ThirdReceiveResponse;

/**
 * 接收微信服务器推送的component_verify_ticket和取消授权通知
 * 
 * 在公众号第三方平台创建审核通过后，微信服务器会向其“授权事件接收URL”每隔10分钟定时推送component_verify_ticket。
 * 当授权方（即授权公众号）在公众平台的授权管理中，取消了对第三方平台方的授权托管后，微信服务器会向第三方平台方的授权事件接收URL（创建第三方平台时填写）推送取消授权通知。
 * 第三方平台方在收到ticket推送后也需进行解密，接收到后必须直接返回字符串success。
 * 
 * @author kobe
 * */
@SuppressWarnings("rawtypes")
public class ThirdTicketUnauthorizedResponse extends ThirdReceiveResponse {

	
	private static final long serialVersionUID = -66172522189700877L;
	
	private String ComponentVerifyTicket;//Ticket内容
	private String AuthorizerAppid;//取消授权的公众号ID
	

	public String getComponentVerifyTicket() {
		return ComponentVerifyTicket;
	}
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		ComponentVerifyTicket = componentVerifyTicket;
	}
	public String getAuthorizerAppid() {
		return AuthorizerAppid;
	}
	public void setAuthorizerAppid(String authorizerAppid) {
		AuthorizerAppid = authorizerAppid;
	}
	
	
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}
}
