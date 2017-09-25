package com.dw.weixin.sdk.response.oper;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.oper.WxGroup;

/**
 * 创建用户分组返回对象信息
 * */
public  class WxGroupCreateResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;

	private WxGroup group;

	public WxGroup getGroup() {
		return group;
	}

	public void setGroup(WxGroup group) {
		this.group = group;
	}

}