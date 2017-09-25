package com.dw.weixin.sdk.base.oper;

import com.dw.weixin.sdk.base.WxObject;
import com.dw.weixin.sdk.constants.WxEnumTransform;


/**
 * 公众号关注者列表
 */
public class WxUserListInfo extends WxObject{

	private static final long serialVersionUID = 2381597715441400907L;

	/**普通用户的标识，对当前公众号唯一*/
	private String openid;
	
	/**返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语*/
	private String lang=WxEnumTransform.LANG_TYPE.zh_CN.toString();
	
	
	public WxUserListInfo(){}
	public WxUserListInfo(String openid) {
		this.openid = openid;
	}

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

}
