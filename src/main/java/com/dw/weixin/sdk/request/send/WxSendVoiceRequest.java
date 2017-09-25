package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendVoice;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 发送语音消息的请求数据对象
 * */
public class WxSendVoiceRequest  extends WxSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private WxSendVoice voice;

	public WxSendVoice getVoice() {
		return voice;
	}

	public void setVoice(WxSendVoice voice) {
		this.voice = voice;
	}

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.voice.toString();
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	
}
