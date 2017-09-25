package com.dw.weixin.sdk.openapi.impl;

import org.apache.commons.lang3.StringUtils;

import com.dw.weixin.sdk.cache.WxAccountPoolManager;
import com.dw.weixin.sdk.cache.base.WxAccountObject;
import com.dw.weixin.sdk.cache.base.WxAccountObject.ACCOUNT_TYPE;
import com.dw.weixin.sdk.cache.base.WxAuthAccountObject;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKException;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.openapi.IWeixinAPI;
import com.dw.weixin.sdk.openapi.factory.WeixinAPInitObject;

/**
 * 微信API基础参数初始化
 * */
public class WeixinBaseAPI  implements IWeixinAPI{
	
	/**
	 * 调用微信SDK-API初始化
	 * */
	@Override
	public void init(WxEnumTransform.CALL_API_WAY apiWay,WeixinAPInitObject initObject)throws WeixinSDKException{
		if(initObject==null){
			throw new WeixinSDKRuleException("initObject is null", "微信SDK初始化对象未定义。");
		}
		String appId=initObject.getAppId();
		if(StringUtils.isEmpty(appId)){
			throw new WeixinSDKRuleException("appId is null", "微信SDK初始化帐号ID未定义。");
		}
		if(StringUtils.isEmpty(initObject.getAppToken())||StringUtils.isEmpty(initObject.getEncodingAesKey())
				||StringUtils.isEmpty(initObject.getAppSecret())){
			throw new WeixinSDKRuleException("initObject property is null", "微信SDK初始化对象属性存在错误。");
		}
		WxConstanst.CURRENT_SDK_APPID=appId;
		if(WxEnumTransform.CALL_API_WAY.THIRD_PROXY.equals(apiWay)){
			WxConstanst.IS_THIRD_PLATFORM=true;
			
			WxAccountObject account=new WxAccountObject(ACCOUNT_TYPE.THIRD_PLATFORM);
			account.setAccountToken(initObject.getAppToken());
			account.setAccountAppSecret(initObject.getAppSecret());
			account.setEncodingAesKey(initObject.getEncodingAesKey());
			account.setAuthAppMap(initObject.getAuthAppMap());
			WxAccountPoolManager.init(appId, account);
		}else{
			WxConstanst.IS_THIRD_PLATFORM=false;
			WxAccountObject account=new WxAccountObject(ACCOUNT_TYPE.WECHAT_PUBLIC);
			account.setAccountToken(initObject.getAppToken());
			account.setAccountAppSecret(initObject.getAppSecret());
			account.setEncodingAesKey(initObject.getEncodingAesKey());
			WxAccountPoolManager.init(appId, account);
		}
	}
	
	@Override
	public void setComponentVerifyTicket(String verifyTicket)throws WeixinSDKException{
		WxConstanst.CURRENT_THIRD_PLATFORM_VERIFY_TICKET=verifyTicket;
	}

	@Override
	public void addAppToThird(String appId, WxAuthAccountObject authApp) throws WeixinSDKException{
		WxAccountPoolManager.addThirdToApp(appId, authApp);
	}

	@Override
	public void removeAppAsThird(String appId) throws WeixinSDKException{
		WxAccountPoolManager.removeThirdToApp(appId);
	}

}
