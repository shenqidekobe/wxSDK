package com.dw.weixin.sdk.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 按OPENID群发消息基类
 * */
public abstract class MassOpenIDSendRequest implements WxRequest<WxResponse>,Serializable {

	private static final long serialVersionUID = -2381607270365244228L;
	
	private List<String> touser;

	public abstract String getMsgtype();
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.SEND_MASS_GROUP_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.touser, "touser");
	}

	@Override
	public Class<WxResponse> getResponseClass() {
		return WxResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.POST;
	}
	
	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	@Override
	public Integer getApiFuncInfoId(){
		//从属菜单权限集
		return WxConstanst.FUNCINFO_ID.MSGANDMENU_FUNC_ID;
	}

	public List<String> getTouser() {
		return touser;
	}

	public void setTouser(List<String> touser) {
		this.touser = touser;
	}
	
}
