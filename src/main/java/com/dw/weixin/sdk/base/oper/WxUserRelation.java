package com.dw.weixin.sdk.base.oper;

import java.util.List;

import com.dw.weixin.sdk.base.WxObject;


/**
 * 批量用户信息
 */
public class WxUserRelation  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	
	private List<String> openid;

	public List<String> getOpenid() {
		return openid;
	}

	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}
	
}
