package com.dw.weixin.sdk.request.oper;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxUserRelationListGetResponse;

/**
 * 查询用户列表请求
 * */
public class WxUserRelationListGetRequest extends WxOperRequest<WxUserRelationListGetResponse>{
	
	private static final long serialVersionUID = -5950186332370891900L;
	
	/**第一个拉取的OPENID，不填默认从头开始拉取*/
	private String next_openid;
	
	public String getNext_openid() {
		return next_openid;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
	}
	
	@Override
	public Class<WxUserRelationListGetResponse> getResponseClass() {
		return WxUserRelationListGetResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		HashMap<String, String> txtParams = new HashMap<String, String>();
		txtParams.put("next_openid", String.valueOf(this.next_openid));
		return txtParams;
	};
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.FIND_USERLIST_URL;
	};
	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.GET;
	};
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}
}
