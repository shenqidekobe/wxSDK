package com.dw.weixin.sdk.request.send;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.base.send.PvSendMusic;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.PvSendRequest;

@SuppressWarnings({"rawtypes"})
public class PvSendMusicRequest  extends PvSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private PvSendMusic Music;

	public PvSendMusicRequest() {
		setMsgType(WxEnumTransform.MSG_TYPE.music.toString());
	}

	public PvSendMusic getMusic() {
		return Music;
	}

	public void setMusic(PvSendMusic music) {
		Music = music;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}

	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		mapClass.put("Music", this.Music.getClass());
		return mapClass;
	}

}
