package com.dw.weixin.sdk.response.event;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.response.WxEventResponse;

/**
 * 关注/取消关注事件
 * Event: 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxEventSubscribeResponse  extends WxEventResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}
}
