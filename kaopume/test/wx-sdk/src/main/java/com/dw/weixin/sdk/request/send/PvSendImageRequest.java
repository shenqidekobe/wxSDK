package com.dw.weixin.sdk.request.send;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.base.send.PvSendImage;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.PvSendRequest;

@SuppressWarnings({"rawtypes"})
public class PvSendImageRequest  extends PvSendRequest {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	private PvSendImage Image;

	public PvSendImageRequest() {
		setMsgType(WxEnumTransform.MSG_TYPE.image.toString());
	}

	public PvSendImage getImage() {
		return Image;
	}

	public void setImage(PvSendImage image) {
		Image = image;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}

	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		mapClass.put("Image", this.Image.getClass());
		return mapClass;
	}

}
