package com.dw.weixin.sdk.base.oper;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 二维码详细信息
 */
public class WxQrCodeActionInfo  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	/**场景*/
	private WxQrCodeScene scene;
	
	public WxQrCodeScene getScene() {
		return scene;
	}
	public void setScene(WxQrCodeScene scene) {
		this.scene = scene;
	}
}
