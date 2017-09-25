package com.dw.weixin.sdk.request.oper;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.oper.WxQrCodeActionInfo;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxQrCodeCreateResponse;

/**
 * 获取创建二维码的请求
 * */
public class WxQrCodeCreateRequest extends WxOperRequest<WxQrCodeCreateResponse>{
	
	private static final long serialVersionUID = -4456266401235538404L;
	
	/**该二维码有效时间，以秒为单位。 最大不超过1800。*/
	private Integer expire_seconds;
	/**二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久*/
	private String action_name;
	/**二维码详细信息*/
	private WxQrCodeActionInfo action_info;
	
	public Integer getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public WxQrCodeActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(WxQrCodeActionInfo action_info) {
		this.action_info = action_info;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.action_name, "action_name");
	}
	
	@Override
	public Class<WxQrCodeCreateResponse> getResponseClass() {
		return WxQrCodeCreateResponse.class;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.CREATE_QRCODE_URL;
	}

	@Override
	public Integer getApiFuncInfoId(){
		return WxConstanst.FUNCINFO_ID.MSGANDMENU_FUNC_ID;
	}
}
