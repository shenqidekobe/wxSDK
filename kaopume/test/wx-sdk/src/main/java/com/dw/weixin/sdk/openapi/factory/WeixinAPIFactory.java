package com.dw.weixin.sdk.openapi.factory;

import com.dw.weixin.sdk.constants.WxConfiguration;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKException;
import com.dw.weixin.sdk.openapi.IWeixinBasisAPI;
import com.dw.weixin.sdk.openapi.impl.WeixinAPIBasisImpl;


/**
 * 微信api的调用工厂，每次调用时都实例化一个新对象
 * 首先初始化，传递第三方平台的appID和appSecret
 * 再传入第三方平台配置的token和encodingAesKey
 * 再传入第三天平台已经接入的公众号Map<appID,authorizationCode>
 * */
public class WeixinAPIFactory {
	
	/**
	 * 创建-调用微信基础功能的API
	 * 
	 * @param apiWay
	 * @param accessToken
	 * 
	 * @return IWeixinBasisAPI
	 * */
	public static IWeixinBasisAPI createIWeixinAPI(WxEnumTransform.CALL_API_WAY apiWay,WeixinAPInitObject initObject)throws WeixinSDKException{
		if(apiWay==null){
			apiWay=WxEnumTransform.CALL_API_WAY.THIRD_PROXY;
		}
		new WxConfiguration();
		IWeixinBasisAPI weixinAPI=new WeixinAPIBasisImpl();
		weixinAPI.init(apiWay, initObject);
		return weixinAPI;
	}

}
