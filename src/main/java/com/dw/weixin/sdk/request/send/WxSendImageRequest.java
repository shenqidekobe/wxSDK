package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendImage;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxSendRequest;

/**
 * 发送图片消息的请求数据对象
 * */
public class WxSendImageRequest  extends WxSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private WxSendImage image;


	public WxSendImage getImage() {
		return image;
	}

	public void setImage(WxSendImage image) {
		this.image = image;
	}

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.image.toString();
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		// TODO Auto-generated method stub
		super.check();
	}
	
}
