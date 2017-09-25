package com.dw.weixin.sdk.response.oper;

import java.util.List;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.oper.WxGroup;

/**
 * 查询所有分组的返回对象信息
 */
public  class WxGroupsGetResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;

	private List<WxGroup> groups;

	public List<WxGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<WxGroup> groups) {
		this.groups = groups;
	}

}