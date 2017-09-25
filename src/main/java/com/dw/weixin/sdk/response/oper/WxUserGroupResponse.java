package com.dw.weixin.sdk.response.oper;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 查询用户所在分组的返回对象相信
 */
public  class WxUserGroupResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;

	private String groupid;

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

}