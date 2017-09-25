package com.dw.weixin.sdk.request;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 公众号发送消息基类
 * @author kobe
 */
public abstract class WxSendRequest implements WxRequest<WxResponse>,Serializable {

	private static final long serialVersionUID = -5510972167506715897L;
	
	/**发送给用户*/
	private String touser;
	/**消息类型
	private String msgtype;*/
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public abstract String getMsgtype();
	
	public void check() throws WeixinSDKRuleException{
		RequestCheckUtils.checkNotEmpty(this.touser, "touser");
	};
	
	@Override
	public Class<WxResponse> getResponseClass() {
		return WxResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		return null;
	}
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.SEND_URL;
	}
	@Override
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.POST;
	};
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
	
}
