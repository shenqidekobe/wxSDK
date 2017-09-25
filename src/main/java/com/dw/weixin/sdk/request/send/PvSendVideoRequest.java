package com.dw.weixin.sdk.request.send;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.base.send.PvSendVideo;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.PvSendRequest;

@SuppressWarnings({"rawtypes"})
public class PvSendVideoRequest  extends PvSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private PvSendVideo Video;

	public PvSendVideoRequest() {
		setMsgType(WxEnumTransform.MSG_TYPE.video.toString());
	}
	
	public PvSendVideo getVideo() {
		return Video;
	}

	public void setVideo(PvSendVideo video) {
		Video = video;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		mapClass.put("Video", this.Video.getClass());
		return mapClass;
	}
}
