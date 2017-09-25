package com.dw.weixin.sdk.response;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxXmlRequest;

/**
 * 第三方平台接收微信服务器推送的消息基类
 * @author kobe
 */
@SuppressWarnings("rawtypes")
public abstract class ThirdReceiveResponse implements WxXmlRequest<Class>,Serializable {

	private static final long serialVersionUID = -997898411198741865L;
	
	private String AppId;//第三方平台appid
	private Long CreateTime;//时间戳
	private String InfoType;//component_verify_ticket、unauthorized
	
	public String getAppId() {
		return AppId;
	}

	public void setAppId(String appId) {
		AppId = appId;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getInfoType() {
		return InfoType;
	}

	public void setInfoType(String infoType) {
		InfoType = infoType;
	}

	public void check() throws WeixinSDKRuleException{}
	
	@Override
	public Class<WxResponse> getResponseClass() {
		return WxResponse.class;
	}
	@Override
	public Map<String, String> getTextParams() {
		return null;
	};
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}
	
	@Override
	public String getApiMethodUrl() {
		return null;
	}
	@Override
	public String getApiMethodRequestType() {
		return null;
	};
	@Override
	public String getAccessTokenParamName() {
		return null;
	}
	@Override
	public Integer getApiFuncInfoId(){
		//从属消息菜单权限集
		return WxConstanst.FUNCINFO_ID.MSGANDMENU_FUNC_ID;
	}
	
}
