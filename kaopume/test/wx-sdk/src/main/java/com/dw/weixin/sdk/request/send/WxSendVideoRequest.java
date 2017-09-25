package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendVideo;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 发送视频消息的请求数据对象
 * */
public class WxSendVideoRequest  extends WxSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private WxSendVideo video;

	public WxSendVideo getVideo() {
		return video;
	}

	public void setVideo(WxSendVideo video) {
		this.video = video;
	}

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.video.toString();
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	
}
