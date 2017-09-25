package com.dw.weixin.sdk.response.event;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.response.WxEventResponse;

/**
 * 扫描带参数二维码事件
 * Event :  用户未关注时subscribe,用户已关注时SCAN
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxEventQRCodeSubscribeResponse  extends WxEventResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;

	/**事件KEY值  
	 * 未关注时:qrscene_为前缀，后面为二维码的参数值
	 * 已关注时:是一个32位无符号整数，即创建二维码时的二维码scene_id
	 * */
	private String EventKey;
	
	/**二维码的ticket，可用来换取二维码图片*/
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}
}
