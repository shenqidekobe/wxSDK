package com.dw.weixin.sdk.response.oper;

import java.util.List;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.oper.WxUserObject;

/**
 * 批量获取关注者的详细信息的返回对象信息
 * */
public class WxUserListInfoResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;
	
	private List<WxUserObject> user_info_list;
	
	public List<WxUserObject> getUser_info_list() {
		return user_info_list;
	}

	public void setUser_info_list(List<WxUserObject> user_info_list) {
		this.user_info_list = user_info_list;
	}
	

}