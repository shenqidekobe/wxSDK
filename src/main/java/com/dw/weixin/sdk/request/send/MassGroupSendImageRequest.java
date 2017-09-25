package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendImage;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.request.MassGroupSendRequest;

/**
 * 按分组群发图片消息
 * */
public class MassGroupSendImageRequest extends MassGroupSendRequest{
	
	private static final long serialVersionUID = 7106472748939593522L;

	private WxSendImage image;

	@Override
	public String getMsgtype() {
		return WxEnumTransform.MSG_TYPE.image.toString();
	}

	public WxSendImage getImage() {
		return image;
	}

	public void setImage(WxSendImage image) {
		this.image = image;
	}

	
}
