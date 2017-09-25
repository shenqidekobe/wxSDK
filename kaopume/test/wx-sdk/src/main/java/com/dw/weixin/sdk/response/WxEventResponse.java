package com.dw.weixin.sdk.response;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxXmlRequest;

/**
 * 在微信用户和公众号产生交互的过程中，用户的某些操作会使得微信服务器通过事件推送的形式通知到开发者在开发者中心处设置的服务器地址，
 * 从而开发者可以获取到该信息。其中，某些事件推送在发生后，是允许开发者回复用户的，某些则不允许
 * 
 * 接收微信服务器的事件推送的结果基类
 * 关于重试的消息排重，推荐使用FromUserName + CreateTime 排重。
 * @author kobe
 */
@SuppressWarnings("rawtypes")
public abstract class WxEventResponse implements WxXmlRequest<Class>,Serializable {

	private static final long serialVersionUID = -997898411198741865L;
	
	/**开发者微信号*/
	private String ToUserName;
	/**发送方帐号（一个OpenID）*/
	private String FromUserName;
	/**消息创建时间 （整型）*/
	private Long CreateTime;
	/**消息类型*/
	private String MsgType;
	/**事件类型*/
	private String Event;
	
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
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
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
