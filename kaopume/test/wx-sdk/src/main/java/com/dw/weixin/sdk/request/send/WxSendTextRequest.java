package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendText;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 发送文本消息的请求数据对象
 * */
public class WxSendTextRequest extends WxSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private WxSendText text;

	public WxSendText getText() {
		return text;
	}

	public void setText(WxSendText text) {
		this.text = text;
	}

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.text.toString();
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	
}
