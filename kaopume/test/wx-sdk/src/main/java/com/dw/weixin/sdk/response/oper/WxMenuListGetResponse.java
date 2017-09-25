package com.dw.weixin.sdk.response.oper;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.oper.WxMenuList;

/**
 * 查询自定义菜单的返回对象信息
 * */
public class WxMenuListGetResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;
	
	private WxMenuList menu;

	public WxMenuList getMenu() {
		return menu;
	}

	public void setMenu(WxMenuList menu) {
		this.menu = menu;
	}
	
}