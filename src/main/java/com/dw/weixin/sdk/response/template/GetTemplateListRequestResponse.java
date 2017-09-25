package com.dw.weixin.sdk.response.template;

import java.util.List;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 获取模版ID返回的数据
 * */
public class GetTemplateListRequestResponse extends WxResponse{

	private static final long serialVersionUID = 4419660849137032866L;


	private List<Object> template_list;

	public List<Object> getTemplate_list() {
		return template_list;
	}
	public void setTemplate_list(List<Object> template_list) {
		this.template_list = template_list;
	}

	
}
