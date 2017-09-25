package com.dw.weixin.sdk.response.oper;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 创建二维码ticket的返回对象信息
 * */
public  class WxQrCodeCreateResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;

	/**获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。*/
	private String ticket;
	/**二维码的有效时间，以秒为单位。最大不超过1800。*/
	private String expire_seconds;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

}