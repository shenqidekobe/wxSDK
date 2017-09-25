package com.dw.weixin.sdk.request.send;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.base.send.PvSendVoice;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.PvSendRequest;

@SuppressWarnings({"rawtypes"})
public class PvSendVoiceRequest  extends PvSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private PvSendVoice Voice;

	public PvSendVoiceRequest() {
		setMsgType(WxEnumTransform.MSG_TYPE.voice.toString());
	}
	
	public PvSendVoice getVoice() {
		return Voice;
	}

	public void setVoice(PvSendVoice voice) {
		Voice = voice;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		mapClass.put("Voice", this.Voice.getClass());
		return mapClass;
	}
}
