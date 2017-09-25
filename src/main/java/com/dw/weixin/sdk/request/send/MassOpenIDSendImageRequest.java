package com.dw.weixin.sdk.request.send;

import com.dw.weixin.sdk.base.send.WxSendImage;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.request.MassOpenIDSendRequest;

/**
 * 按openID群发图片消息
 * */
public class MassOpenIDSendImageRequest extends MassOpenIDSendRequest {

	private static final long serialVersionUID = 5228114135052541100L;

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
