package com.dw.weixin.sdk.request.oper;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxUserGroupResponse;

/**
 * 查询用户所在分组
 * @author kobe
 */
public class WxUserGroupRequest extends WxOperRequest<WxUserGroupResponse>{
	
	private static final long serialVersionUID = -7296652071731608456L;
	
	/**用户的OpenID*/
	private String openid;
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.openid, "openid");
	}
	
	@Override
	public Class<WxUserGroupResponse> getResponseClass() {
		return WxUserGroupResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.FIND_USERGROUP_URL;
	};
	
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}
}
