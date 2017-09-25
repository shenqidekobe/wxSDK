package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendMusic;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 发送音乐消息的请求数据对象
 * */
public class WxSendMusicRequest  extends WxSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private WxSendMusic music;

	public WxSendMusic getMusic() {
		return music;
	}

	public void setMusic(WxSendMusic music) {
		this.music = music;
	}

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.music.toString();
	}


	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	
}
