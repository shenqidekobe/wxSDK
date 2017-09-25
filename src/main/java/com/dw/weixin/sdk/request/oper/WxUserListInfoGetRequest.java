package com.dw.weixin.sdk.request.oper;

import java.util.List;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.oper.WxUserListInfo;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxUserListInfoResponse;

/**
 * 批量按openid获取用户信息请求
 * */
public class WxUserListInfoGetRequest extends WxOperRequest<WxUserListInfoResponse>{
	
	private static final long serialVersionUID = 2534401263806640203L;

	private List<WxUserListInfo> user_list;

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.user_list, "user_list");
	}
	

	@Override
	public Class<WxUserListInfoResponse> getResponseClass() {
		return WxUserListInfoResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	};
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.FIND_USERINFO_LIST_URL;
	};
	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.POST;
	};
	
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}


	public List<WxUserListInfo> getUser_list() {
		return user_list;
	}
	public void setUser_list(List<WxUserListInfo> user_list) {
		this.user_list = user_list;
	}
	
}
