package com.dw.weixin.sdk.response.receive;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.WxReceiveResponse;

/**
 * 接收text消息
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxReceiveTextResponse  extends WxReceiveResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	/**文本消息内容*/
	private String  Content;
	
	public WxReceiveTextResponse() {
		setMsgType(WxEnumTransform.MSG_TYPE.text.toString());
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
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
