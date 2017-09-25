package com.dw.weixin.sdk.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.weixin.sdk.cache.base.WxAccountObject;
import com.dw.weixin.sdk.cache.base.WxAuthAccountObject;
import com.dw.weixin.sdk.constants.WxConstanst;

/**
 * 维持外部appID所关联的账号信息,采用hashMap的方式进行存储，以appID为key
 * 其中包括公众号自身的access_token
 * 也包括了第三方平台的authorizer_access_token以及authorizer_access_token
 * */
class WxAccountPool {
	
    private static Logger logger=LoggerFactory.getLogger(WxAccountPool.class);
	
	private static final Integer DEFAULT_MAX_SIZE=50000;
	
	private static Map<String, WxAccountObject> pool = null;
	
	static{
		logger.info("微信SDK帐号缓存池开始初始化...");
		pool=new ConcurrentHashMap<String, WxAccountObject>();
	}
	
	/**
	 * 初始化一个第三方平台帐号信息
	 * */
	public synchronized void init(String thirdAppId,WxAccountObject account){
		if(pool.containsKey(thirdAppId)){
			logger.info("第三方平台ID："+thirdAppId+"已经初始化过了.");
			return;
		}
		this.put(thirdAppId, account);
	}
	
	/**
	 * 向第三方平台里添加一个公众号
	 * */
	public void addThirdToApp(String appId,WxAuthAccountObject authApp){
		String thirdAppId=WxConstanst.CURRENT_SDK_APPID;
		WxAccountObject obj=this.getValue(thirdAppId);
		if(obj==null)
			return;
		Map<String, WxAuthAccountObject> authAppMap=obj.getAuthAppMap();
		authAppMap.put(appId, authApp);
		obj.setAuthAppMap(authAppMap);
		this.put(thirdAppId, obj);
	}
	
	/**
	 * 向第三方平台里移除一个公众号
	 * */
	public void removeThirdToApp(String appId){
		String thirdAppId=WxConstanst.CURRENT_SDK_APPID;
		WxAccountObject obj=this.getValue(thirdAppId);
		if(obj==null)
			return;
		Map<String, WxAuthAccountObject> authAppMap=obj.getAuthAppMap();
		authAppMap.remove(appId);
		obj.setAuthAppMap(authAppMap);
		this.put(thirdAppId, obj);
	}
	
	/**
	 * 判断已授权公众号是否拥有某权限集
	 * */
	public boolean judgeAuthAppFuncId(String appId,Integer funcId){
		String thirdAppId=WxConstanst.CURRENT_SDK_APPID;
		WxAccountObject obj=this.getValue(thirdAppId);
		if(obj==null)
			return false;
		Map<String, WxAuthAccountObject> authAppMap=obj.getAuthAppMap();
		WxAuthAccountObject authApp=authAppMap.get(appId);
		return authApp.getFuncList().contains(funcId);
	}
	
	/**
	 * 获取一个key的value值
	 * */
	public synchronized WxAccountObject getValue(String key){
		if(key==null){
			logger.error("微信SDK未初始化帐号信息");
			return null;
		}
		if(pool.isEmpty()){
			return null;
		}
		return pool.get(key);
	}
	
	/**
	 * 添加一个对象到缓存池中
	 * */
	public void add(String key,WxAccountObject obj){
		this.put(key, obj);
	}
	
	/**
	 * 更新缓存池的对象
	 * */
	public void modify(String key,WxAccountObject obj){
		if(pool.containsKey(key)){
			this.put(key, obj);
		}else{
			add(key, obj);
		}
	}
	
	/**
	 * 从缓存中移除一个元素
	 * */
	public void remove(String key){
		if(!pool.isEmpty()){
			pool.remove(key);
		}
	}
	
	/**
	 * 缓存大小
	 * */
	public Integer size(){
		return pool.size();
	}
	
	/**
	 * 给map put元素
	 * 
	 * */
	private void put(String key,WxAccountObject obj){
		Integer size=this.size();
		if(size<=DEFAULT_MAX_SIZE){
			pool.put(key, obj);
		}
	}
	
}
