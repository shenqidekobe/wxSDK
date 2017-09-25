package com.dw.weixin.sdk.request.oper;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.request.WxOperRequest;
import com.dw.weixin.sdk.response.oper.WxUserInfoGetResponse;

/**
 * 按openid获取用户信息请求
 * */
public class WxUserInfoGetRequest extends WxOperRequest<WxUserInfoGetResponse>{
	
	private static final long serialVersionUID = 2534401263806640203L;

	/**普通用户的标识，对当前公众号唯一*/
	private String openid;
	
	/**返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语*/
	private String lang=WxEnumTransform.LANG_TYPE.zh_CN.toString();
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		lang = WxEnumTransform.LANG_TYPE.zh_CN.toString();
		return lang;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.openid, "openid");
	}
	

	@Override
	public Class<WxUserInfoGetResponse> getResponseClass() {
		return WxUserInfoGetResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		HashMap<String, String> txtParams = new HashMap<String, String>();
		txtParams.put("openid", String.valueOf(this.openid));
		txtParams.put("lang", this.lang);
		return txtParams;
	};
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.FIND_USERINFO_URL;
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
