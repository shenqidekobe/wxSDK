package com.dw.weixin.sdk.request.third;

import java.util.HashMap;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConstanst.REQUEST_METHOD;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 网页授权
 * 代公众号授权发起获取code的请求
 * 
 * @author kobe
 * */
public class ThirdOAuthGetCodeRequest implements WxRequest<WxResponse>{

	private String appid;//公众号的appid
	private String redirect_uri;//重定向地址，需要urlencode，这里填写的应是服务开发方的回调地址
	private String response_type="code";//填code
	private String scope;//	授权作用域，拥有多个作用域用逗号（,）分隔
	private String state;//	重定向后会带上state参数，开发者可以填写任意参数值，最多128字节
	private String component_appid;//服务方的appid
	
	
	
	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.OAUTH2_CODE_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.appid, "appid");
		RequestCheckUtils.checkNotEmpty(this.redirect_uri, "redirect_uri");
		RequestCheckUtils.checkNotEmpty(this.scope, "scope");
		RequestCheckUtils.checkNotEmpty(this.component_appid, "component_appid");
	}

	@Override
	public Class<WxResponse> getResponseClass() {
		return WxResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("appid", this.appid);
		map.put("redirect_uri", this.redirect_uri);
		map.put("response_type", this.response_type);
		map.put("scope", this.scope);
		map.put("state", this.state);
		map.put("component_appid", this.component_appid);
		return map;
	}

	@Override
	public String getApiMethodRequestType() {
		return REQUEST_METHOD.GET;
	}

	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.NO_ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString();
	}

	@Override
	public Integer getApiFuncInfoId() {
		return null;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getResponse_type() {
		return response_type;
	}

	public void setResponse_type(String response_type) {
		this.response_type = response_type;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComponent_appid() {
		return component_appid;
	}

	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

}
