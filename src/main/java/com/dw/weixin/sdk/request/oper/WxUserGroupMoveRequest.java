package com.dw.weixin.sdk.request.oper;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxUserGroupMoveResponse;

/**
 * 移动用户分组
 * @author kobe
 */
public class WxUserGroupMoveRequest extends WxOperRequest<WxUserGroupMoveResponse>{
	
	private static final long serialVersionUID = -2569889298508783832L;
	
	/**用户唯一标识符*/
	private String openid;
	/**分组id*/
	private Long to_groupid;
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Long getTo_groupid() {
		return to_groupid;
	}

	public void setTo_groupid(Long to_groupid) {
		this.to_groupid = to_groupid;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.openid, "openid");
		RequestCheckUtils.checkNotEmpty(this.to_groupid, "to_groupid");
	}
	
	@Override
	public Class<WxUserGroupMoveResponse> getResponseClass() {
		return WxUserGroupMoveResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.MEMBER_USER_URL;
	};
	
	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.USER_FUNC_ID;
	}
}
