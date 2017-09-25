package com.dw.weixin.sdk.response.template;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取模版ID返回的数据
 * */
public class GetTemplateIdRequestResponse extends WxResponse{

	private static final long serialVersionUID = 4419660849137032866L;


	private String template_id;


	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
}
