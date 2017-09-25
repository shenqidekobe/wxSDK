package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendText;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.request.MassGroupSendRequest;

/**
 * 按分组群发文本消息
 * */
public class MassGroupSendTextRequest extends MassGroupSendRequest{
	
	private static final long serialVersionUID = 7106472748939593522L;

	private WxSendText text;

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.text.toString();
	}

	public WxSendText getText() {
		return text;
	}

	public void setText(WxSendText text) {
		this.text = text;
	}
	
}
