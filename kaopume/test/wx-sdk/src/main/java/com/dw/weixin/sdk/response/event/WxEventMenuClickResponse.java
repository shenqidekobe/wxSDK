package com.dw.weixin.sdk.response.event;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.response.WxEventResponse;

/**
 * 菜单点击事件
 * Event :  CLICK,VIEW
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxEventMenuClickResponse extends WxEventResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;

	/**事件KEY值  
	 * event为CLICK时: 与自定义菜单接口中KEY值对应
	 * event为VIEW时: 置的跳转URL
	 * */
	private String EventKey;
	
	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}
}
