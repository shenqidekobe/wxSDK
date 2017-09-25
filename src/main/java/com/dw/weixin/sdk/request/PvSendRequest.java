package com.dw.weixin.sdk.request;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 公众号发送消息基类
 * @author kobe
 */
@SuppressWarnings("rawtypes")
public abstract class PvSendRequest implements WxXmlRequest<Class>,Serializable {

	private static final long serialVersionUID = -997898411198741865L;
	
	/**开发者微信号*/
	private String ToUserName;
	/**发送方帐号（一个OpenID）*/
	private String FromUserName;
	/**消息创建时间 （整型）*/
	private Long CreateTime;
	/**消息类型*/
	private String MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public  String getMsgType() {
		return MsgType;
	}
	protected void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public void check() throws WeixinSDKRuleException{}
	
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
		return null;
	}
	@Override
	public String getApiMethodRequestType() {
		return null;
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
