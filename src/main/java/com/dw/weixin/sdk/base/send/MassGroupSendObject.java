package com.dw.weixin.sdk.base.send;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 按组群发消息对象
 * */
public class MassGroupSendObject extends WxObject{

	private static final long serialVersionUID = -8917688575655726041L;
	
	private Boolean is_to_all;
	
	private String group_id;

	public Boolean getIs_to_all() {
		return is_to_all;
	}

	public void setIs_to_all(Boolean is_to_all) {
		this.is_to_all = is_to_all;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	
}
