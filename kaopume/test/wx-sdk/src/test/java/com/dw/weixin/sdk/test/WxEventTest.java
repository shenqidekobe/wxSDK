package com.dw.weixin.sdk.test;

import org.junit.Test;

import com.dw.weixin.sdk.XStreamUtil;
import com.dw.weixin.sdk.response.event.WxEventSubscribeResponse;
import com.dw.weixin.sdk.response.third.ThirdTicketUnauthorizedResponse;

/**
 * 接收微信事件推送测试
 * */
public class WxEventTest {

	/**
	 * 接收用户关注事件
	 * */
	@Test
	public void testSubscriber(){
		String xml="<xml>"+
					"<ToUserName><![CDATA[toUser]]></ToUserName>"+
					"<FromUserName><![CDATA[FromUser]]></FromUserName>"+
					"<CreateTime>123456789</CreateTime>"+
					"<MsgType><![CDATA[event]]></MsgType>"+
					"<Event><![CDATA[subscribe]]></Event>"+
					"</xml>";
		
		WxEventSubscribeResponse request=XStreamUtil.fromXml(xml, WxEventSubscribeResponse.class);
		
		System.out.println(request.getCreateTime());
	}
	
	/**
	 * 接收推送的ticket
	 * */
	@Test
	public void testComponentVerifyTicket(){
		String xml="<xml>"+
					"<AppId>123456789</AppId>"+
					"<CreateTime>1413192605</CreateTime>"+
					"<InfoType>component_verify_ticket</InfoType>"+
					"<ComponentVerifyTicket>888888888</ComponentVerifyTicket>"+
					"</xml>";
		ThirdTicketUnauthorizedResponse rsp=XStreamUtil.fromXml(xml, ThirdTicketUnauthorizedResponse.class);
		System.out.println(rsp.getAuthorizerAppid());
	}
}
