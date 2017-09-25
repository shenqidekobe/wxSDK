package com.dw.weixin.sdk.base.thrid;

import java.util.List;
import java.util.Map;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 第三方使用的授权信息
 * */
public class ThridAuthorizationObject extends WxObject{

	private static final long serialVersionUID = -7118955701707655897L;
	
	private String appid;//授权方appid
	
	private List<Map<String,Map<String,Integer>>> func_info;//公众号授权给开发者的权限集列表
	
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public List<Map<String,Map<String,Integer>>> getFunc_info() {
		return func_info;
	}
	public void setFunc_info(List<Map<String,Map<String,Integer>>> func_info) {
		this.func_info = func_info;
	}

}
