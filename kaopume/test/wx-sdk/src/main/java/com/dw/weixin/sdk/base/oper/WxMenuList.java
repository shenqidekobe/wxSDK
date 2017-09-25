package com.dw.weixin.sdk.base.oper;

import java.util.List;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 公众号创建菜单
 */
public class WxMenuList  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	private List<WxMenuButton> button;

	public  List<WxMenuButton> getButton() {
		return button;
	}

	public void setButton( List<WxMenuButton> button) {
		this.button = button;
	}
	
}
