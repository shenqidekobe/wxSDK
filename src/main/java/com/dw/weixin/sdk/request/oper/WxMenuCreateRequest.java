package com.dw.weixin.sdk.request.oper;

import java.util.List;
import java.util.Map;

import com.dw.weixin.sdk.base.oper.WxMenuButton;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxMenuCreateResponse;

/**
 * 创建自定义菜单请求
 * */
public class WxMenuCreateRequest extends WxOperRequest<WxMenuCreateResponse>{
	
	private static final long serialVersionUID = -4236013247054234322L;
	
	private List<WxMenuButton> button;
	
	public List<WxMenuButton> getButton() {
		return button;
	}

	public void setButton(List<WxMenuButton> button) {
		this.button = button;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		
	}
	
	@Override
	public Class<WxMenuCreateResponse> getResponseClass() {
		return WxMenuCreateResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	};
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.CREATE_MENU_URL;
	};
	
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.MSGANDMENU_FUNC_ID;
	}
}
