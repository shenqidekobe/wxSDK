package com.dw.weixin.sdk.base.oper;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 带参数二维码场景
 */
public class WxQrCodeScene  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	/**场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）*/
	private Long scene_id;
	
	public Long getScene_id() {
		return scene_id;
	}
	public void setScene_id(Long scene_id) {
		this.scene_id = scene_id;
	}

}
