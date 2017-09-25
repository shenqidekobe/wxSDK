package com.dw.weixin.sdk.response.other;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取微信JS-SDK的ticket返回对象
 * */
public class JsApiTicketResponse extends WxResponse{

	private static final long serialVersionUID = 2860168641260044990L;
	
	private String ticket;//返回的ticket
	
	private Integer expires_in;//有效期

	
	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
}
