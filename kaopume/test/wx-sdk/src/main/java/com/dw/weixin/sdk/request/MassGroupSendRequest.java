package com.dw.weixin.sdk.request;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.base.send.MassGroupSendObject;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 按群组群发消息基类
 * */
public abstract class MassGroupSendRequest implements WxRequest<WxResponse>,Serializable {

	private static final long serialVersionUID = -2381607270365244228L;
	
	private MassGroupSendObject filter;

	public abstract String getMsgtype();
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.SEND_MASS_GROUP_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.filter, "filter");
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
		//从属消息菜单权限集
		return WxConstanst.FUNCINFO_ID.MSGANDMENU_FUNC_ID;
	}

	public MassGroupSendObject getFilter() {
		return filter;
	}

	public void setFilter(MassGroupSendObject filter) {
		this.filter = filter;
	}

}
