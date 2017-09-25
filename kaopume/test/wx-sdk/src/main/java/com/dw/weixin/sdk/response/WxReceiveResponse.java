package com.dw.weixin.sdk.response;

import java.io.Serializable;
import java.util.Map;

import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxXmlRequest;

/**
 * ​当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
 * 
 * 接收微信服务器推送过来的消息基类
 * @author kobe
 */
@SuppressWarnings("rawtypes")
public abstract class WxReceiveResponse implements WxXmlRequest<Class>,Serializable {

	private static final long serialVersionUID = -997898411198741865L;
	
	/**开发者微信号*/
	private String ToUserName;
	/**发送方帐号（一个OpenID）*/
	private String FromUserName;
	/**消息创建时间 （整型）*/
	private Long CreateTime;
	/**消息类型*/
	private String MsgType;
	/**消息id，64位整型*/
	private Long MsgId;	
	
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
	
	public Long getMsgId() {
		return MsgId;
	}
	public void setMsgId(Long msgId) {
		MsgId = msgId;
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
		return null;
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
