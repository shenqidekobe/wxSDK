package com.dw.weixin.sdk.cache;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.dw.weixin.sdk.HttpClientUtil;
import com.dw.weixin.sdk.cache.base.WxAccountObject;
import com.dw.weixin.sdk.cache.base.WxAuthAccountObject;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKException;

import flexjson.JSONDeserializer;

/**
 * 根据缓存池生产微信服务相关的token信息
 * */
public class WxAccountPoolManager {
	
	private static Logger logger=LoggerFactory.getLogger(WxAccountPoolManager.class);
	
	public static final Integer ACCESS_TOKEN_EXPIRE=30;//token过期时间
	public static final Integer AUTH_CODE_EXPIRE=15;//授权码过期时间
	public static final Integer AUTHORIZER_REFRESH_TOKEN_EXIPRE=20;//刷新令牌过期时间
	public static final Integer JSAPI_TICKET_EXPIRE=30;//JSAPI-TICKET过期时间
	
	private static WxAccountPool cache=new WxAccountPool();
	
	/**
	 * 初始化一个第三方平台帐号
	 * 
	 * @param thirdAppId
	 * @param account
	 * */
	public static synchronized void init(String thirdAppId,WxAccountObject account){
		if(thirdAppId==null||account==null)
			return;
		cache.init(thirdAppId, account);
	}
	
	/**
	 * 往第三方帐号中增加一个授权公众号的授权码
	 * 
	 * @param appId
	 * @param authCode
	 * */
	public static synchronized void addThirdToApp(String appId,WxAuthAccountObject authApp){
		if(appId==null||authApp==null)
			return;
		cache.addThirdToApp(appId, authApp);
	}
	
	/**
	 * 往第三方帐号中移除一个授权公众号的授权码
	 * 
	 * @param appId
	 * */
	public static synchronized void removeThirdToApp(String appId){
		if(appId==null)
			return;
		cache.removeThirdToApp(appId);
	}
	
	/**
	 * 判断已授权公众号是否拥有某权限集
	 * 
	 * @param appId
	 * @param funcId
	 * 
	 * @return true/false
	 * */
	public static synchronized boolean judgeAuthAppFuncId(String appId,Integer funcId){
		if(appId==null||funcId==null)
			return false;
		return cache.judgeAuthAppFuncId(appId, funcId);
	}
	
	/**
	 * 根据缓存key获取缓存对象
	 * 
	 * @param key
	 * 
	 * @return WxAccountObject
	 * */
	public static synchronized WxAccountObject getObject(String key){
		if(key==null)
			return null;
		return cache.getValue(key);
	}
	
	/**
	 * 获取微信公众号的accessToken
	 * 
	 * @param appId
	 * 
	 * @return accessToken
	 * */
	public static synchronized String produceAccessToken(String appId)throws WeixinSDKException{
		String token=null;
		appId=StringUtils.isEmpty(appId)?WxConstanst.CURRENT_SDK_APPID:appId;
		WxAccountObject obj=cache.getValue(appId);
		String appSecret=obj.getAccountAppSecret();
		if (obj.getCreateTime()!=null) {
			if (calculateDateExpire(obj.getCreateTime(),ACCESS_TOKEN_EXPIRE)
					&& StringUtils.isNotEmpty(obj.getToken())) {
				logger.debug("从缓存中获取公众号ACCESS_TOKEN:"+obj.getToken());
				return obj.getToken();
			} 
		}
		String requestUrl=WxApiMethodName.ACCESS_TOKEN_URL;
		String params = "?grant_type=client_credential&appid=" + appId+ "&secret=" + appSecret;
		Map<String, Object> map = executeReq(requestUrl+params,null);
		if (map != null) {
			if (map.get("errcode") != null) {
				throw new WeixinSDKException("获取ACCESS_TOKEN失败."+map.get("errcode"));
			}
			token = map.get("access_token").toString();
		}
		obj.setToken(token);
		obj.setCreateTime(new Date());
		cache.add(appId, obj);
		return token;
	}
	
	/**
	 * 生产微信第三方平台的accessToken
	 * 
	 * @param thirdAppId
	 * @param thirdAppSecret
	 * @param verifyTicket
	 * 
	 * @return accessToken
	 * */
	public static synchronized String produceThirdAccessToken()throws WeixinSDKException{
		String token=null;
		String thirdAppId=WxConstanst.CURRENT_SDK_APPID;
		WxAccountObject obj=cache.getValue(thirdAppId);
		String thirdAppSecret=obj.getAccountAppSecret();
		String verifyTicket=WxConstanst.CURRENT_THIRD_PLATFORM_VERIFY_TICKET;
		if (obj.getCreateTime()!=null) {
			if (calculateDateExpire(obj.getCreateTime(),ACCESS_TOKEN_EXPIRE)
					&& StringUtils.isNotEmpty(obj.getToken())) {
				logger.debug("从缓存中获取第三方平台ACCESS_TOKEN:"+obj.getToken());
				return obj.getToken();
			} 
		}
		if(StringUtils.isEmpty(verifyTicket)){
			throw new WeixinSDKException("未收到微信服务器推送的verifyTicket.");
		}
		String requestUrl=WxApiMethodName.THRID_ACCESS_TOKEN_URL;
		Map<String,String> formparams = new HashMap<String, String>();
		formparams.put("component_appid", thirdAppId);  
		formparams.put("component_appsecret", thirdAppSecret); 
		formparams.put("component_verify_ticket",verifyTicket ); 
	    
		Map<String, Object> map = executeReq(requestUrl, formparams);
		if (map != null) {
			if (map.get("errcode") != null) {
				throw new WeixinSDKException("获取component_access_token失败."+map.toString());
			}
			token = map.get("component_access_token").toString();
		}
		obj.setToken(token);
		obj.setCreateTime(new Date());
		cache.add(thirdAppId, obj);
		return token;
	}
	
	/**
	 * 根据授权码生产已授权公众号的authorizerAccessToken
	 * 
	 * @param authorizerAppId
	 * 
	 * @return authorizerAccessToken
	 * */
	@SuppressWarnings("unchecked")
	public static synchronized String produceAuthorizerAccessTokenByAuthCode(String authorizerAppId)throws WeixinSDKException{
		String token=null;
		String thirdAppId=WxConstanst.CURRENT_SDK_APPID;
		WxAccountObject obj=cache.getValue(thirdAppId);
		Map<String, WxAuthAccountObject> authAppMap=obj.getAuthAppMap();
		WxAuthAccountObject authApp=authAppMap.get(authorizerAppId);
		String authorizationCode=authApp.getAuthCode();
		if (authApp.getCreateTokenTime()!=null) {
			if (calculateDateExpire(authApp.getCreateTokenTime(),ACCESS_TOKEN_EXPIRE)
					&& StringUtils.isNotEmpty(authApp.getAuthorizerAccessToken())) {
				logger.debug("从缓存中获取authorizerAccessToken:"+authApp.getAuthorizerAccessToken());
				return authApp.getAuthorizerAccessToken();
			} 
		}
		//验证授权code是否已过期，过期则开始从刷新令牌中获取authorizerAccessToken
		if (authApp.getAuthCreateTime()!=null) {
			if (!calculateDateExpire(authApp.getAuthCreateTime(),AUTH_CODE_EXPIRE)
					&& StringUtils.isNotEmpty(authApp.getAuthCode())) {
				return produceAuthorizerAccessTokenByRefreshToken(authorizerAppId);//从刷新令牌中获取
			} 
		}
		if(StringUtils.isEmpty(obj.getToken())){
			String asToekn=produceThirdAccessToken();
			obj.setToken(asToekn);
		}
		
		String requestUrl=WxApiMethodName.THRID_AUTHINFO_URL+
				"?"+WxConstanst.ACCESS_TOKEN_NAMES.THIRD_ACCESS_TOKEN+"="+obj.getToken();
		Map<String,String> formparams = new HashMap<String, String>();
		formparams.put("component_appid", thirdAppId);  
		formparams.put("authorization_code", authorizationCode); 
	    String authorizerRefreshToken=null;
	    
		Map<String, Object> map = executeReq(requestUrl, formparams);
		if (map != null) {
			if (map.get("errcode") != null) {
				throw new WeixinSDKException("获取authorizer_access_token失败."+map.get("errmsg"));
			}
			Map<String,String> subMap=(Map<String, String>) map.get("authorization_info");
			token = subMap.get("authorizer_access_token");
			authorizerRefreshToken=subMap.get("authorizer_refresh_token");
		}
		authApp.setAuthorizerAccessToken(token);
		authApp.setCreateTokenTime(new Date());
		authApp.setAuthorizerRefreshToken(authorizerRefreshToken);
		authApp.setCreateRefreshTokenTime(new Date());
		authAppMap.put(authorizerAppId, authApp);
		obj.setAuthAppMap(authAppMap);
		cache.add(thirdAppId, obj);
		return token;
	}
	
	/**
	 * 根据刷新令牌生产已授权公众号的authorizerAccessToken
	 * 
	 * @param authorizerAppId
	 * 
	 * @return authorizerAccessToken
	 * */
	public static synchronized String produceAuthorizerAccessTokenByRefreshToken(String authorizerAppId)throws WeixinSDKException{
		String token=null;
		String thirdAppId=WxConstanst.CURRENT_SDK_APPID;
		WxAccountObject obj=cache.getValue(thirdAppId);
		Map<String, WxAuthAccountObject> authAppMap=obj.getAuthAppMap();
		WxAuthAccountObject authApp=authAppMap.get(authorizerAppId);
		String authorizerRefreshToken=authApp.getAuthorizerRefreshToken();
		if (authApp.getCreateTokenTime()!=null) {
			if (calculateDateExpire(authApp.getCreateTokenTime(),ACCESS_TOKEN_EXPIRE)
					&& StringUtils.isNotEmpty(authApp.getAuthorizerAccessToken())) {
				logger.debug("从缓存中获取authorizerAccessToken:"+authApp.getAuthorizerAccessToken());
				return authApp.getAuthorizerAccessToken();
			} 
		}
		String thirdAccessToken=obj.getToken();
		//如果第三方平台accessToken为空或者已经过期
		if(StringUtils.isEmpty(thirdAccessToken)
				||!calculateDateExpire(obj.getCreateTime(),ACCESS_TOKEN_EXPIRE)){
			thirdAccessToken=produceThirdAccessToken();
			logger.debug("thirdAccessToken已过期，重新获取的thirdAccessToken="+thirdAccessToken);
		}
		String requestUrl=WxApiMethodName.THRID_AUTHTOKEN_URL+
				"?"+WxConstanst.ACCESS_TOKEN_NAMES.THIRD_ACCESS_TOKEN+"="+thirdAccessToken;
		Map<String,String> formparams = new HashMap<String, String>();
		formparams.put("component_appid", thirdAppId);  
		formparams.put("authorizer_appid", authorizerAppId); 
		formparams.put("authorizer_refresh_token", authorizerRefreshToken); 
	    HttpEntity entity = HttpClientUtil._executePost(requestUrl, formparams);
		if (entity != null) {
			try {
				String body = EntityUtils.toString(entity);
				JSONDeserializer<Map<String, String>> deserializer = new JSONDeserializer<Map<String, String>>();
				Map<String, String> map = deserializer.deserialize(body);
				if (map != null) {
					if (map.get("errcode") != null) {
						throw new WeixinSDKException("获取authorizer_access_token失败."+map.get("errmsg"));
					}
					token = map.get("authorizer_access_token");
					authorizerRefreshToken=map.get("authorizer_refresh_token");
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		authApp.setAuthorizerAccessToken(token);
		authApp.setCreateTokenTime(new Date());
		authApp.setAuthorizerRefreshToken(authorizerRefreshToken);
		authApp.setCreateRefreshTokenTime(new Date());
		authAppMap.put(authorizerAppId, authApp);
		obj.setAuthAppMap(authAppMap);
		cache.add(thirdAppId, obj);
		return token;
	}
	
	/**
	 * 生产js-sdk签名验证的ticket
	 * 
	 * @param
	 * 
	 * @return ticket
	 * */
	public static synchronized String produceJsSDKTicket(String appId)throws WeixinSDKException{
		String ticket=null;
		WxAccountObject obj=cache.getValue(appId);
		String accessToken=null;
		if (obj!=null&&obj.getJsTicketCreateTime()!=null) {
			accessToken=obj.getToken();
			if (calculateDateExpire(obj.getJsTicketCreateTime(),JSAPI_TICKET_EXPIRE)
					&& StringUtils.isNotEmpty(obj.getJsAPITicket())) {
				logger.debug("从缓存中获取ticket:"+obj.getJsAPITicket());
				return obj.getJsAPITicket();
			} 
		}
		String requestUrl = WxApiMethodName.JS_TICKET_URL;
		String params = "?access_token=" + accessToken + "&type=jsapi";
		CloseableHttpResponse rsp = HttpClientUtil.executeGet(requestUrl + params);
		String jsonStr="";
		try {
			jsonStr = EntityUtils.toString(rsp.getEntity());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);

		for (java.util.Map.Entry<String, Object> entry : jsonObject.entrySet()) {
			if ("ticket".equals(entry.getKey())) {
				ticket = entry.getValue().toString();
				break;
			}
		}
		obj.setJsAPITicket(ticket);
		obj.setJsTicketCreateTime(new Date());
		cache.add(appId, obj);
		return ticket;
	}
	
	/**
	 * 验证时间是否已经过期
	 * 
	 * @param createTime:开始计算时间
	 * @param expireTime:过期时间(分钟)
	 * 
	 * @return true(未过期)false(已过期)
	 * */
	public static boolean calculateDateExpire(Date createTime,Integer expireTime) {
		boolean flag = false;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -expireTime);
		Long ct = calendar.getTime().getTime();
		/** 当前时间减去设置的过期时间，如果它小于等于创建时间则表示未过期 */
		if (ct <= createTime.getTime()) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 处理请求
	 * */
	private static Map<String, Object> executeReq(String requestUrl,Map<String,String> maps){
		HttpEntity entity = null;
		if(maps==null){
			CloseableHttpResponse rsp=HttpClientUtil.executeGet(requestUrl);
			entity=rsp.getEntity();
		}else{
			entity = HttpClientUtil._executePost(requestUrl, maps);
		}
		if (entity != null) {
			try {
				String body = EntityUtils.toString(entity);
				JSONDeserializer<Map<String, Object>> deserializer = new JSONDeserializer<Map<String, Object>>();
				Map<String, Object> map = deserializer.deserialize(body);
				return map;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}
