package com.dw.weixin.sdk.response.oper;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.oper.WxUserRelation;

/**
 * 获取关注者列表的返回对象信息
 * */
public class WxUserRelationListGetResponse extends WxResponse {
	
	private static final long serialVersionUID = 4685806311384022039L;

	private Long total;

	private Integer count;
	
	private WxUserRelation data;
	
	private String next_openid;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public WxUserRelation getData() {
		return data;
	}

	public void setData(WxUserRelation data) {
		this.data = data;
	}

	public String getNext_openid() {
		return next_openid;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	
}