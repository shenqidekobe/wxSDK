package com.dw.weixin.sdk.base.oper;

import com.dw.weixin.sdk.base.WxObject;



/**
 * 用户分组
 */
public class WxGroup  extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;
	/**分组id，由微信分配*/
	private Long id;
	/**分组名字，UTF8编码*/
	private String name;
	/**分组内用户数量*/
	private Integer count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
