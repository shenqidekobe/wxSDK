package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendText;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.request.MassOpenIDSendRequest;

/**
 * 按openID群发文本消息
 * */
public class MassOpenIDSendTextRequest extends MassOpenIDSendRequest {

	private static final long serialVersionUID = 5228114135052541100L;

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
