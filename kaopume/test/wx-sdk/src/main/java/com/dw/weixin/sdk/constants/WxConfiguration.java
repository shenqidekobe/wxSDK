package com.dw.weixin.sdk.constants;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;


/**
 * 微信初始配置
 * 
 * @author kobe
 * 
 */
public class WxConfiguration {
	

	public static PropertiesConfiguration bundle = null;
	
	public static final String error_proterties_filename="errorcode.properties";
	
	
	
	static {
		initWeixinAPIProperties("wxapi.properties");
		initWeixinErrorProperties();
	}
	
	
	/**
	 * 加载微信接口地址配置文件
	 * */
	public static void initWeixinAPIProperties(String url){
		PropertiesConfiguration config;
		try {
			config = new PropertiesConfiguration(url);
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			WxConfiguration.bundle = config;
			
			initWechat();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 加载微信错误消息配置文件
	 * */
	public static void initWeixinErrorProperties(){
		Properties prop = new Properties();
		try {
			prop.load(new InputStreamReader(WxConfiguration.class
					.getClassLoader().getResourceAsStream(error_proterties_filename), "UTF-8"));
			Set<Object> keys = prop.keySet();
			for (Object key : keys) {
				WxConstanst.errorMap.put(key.toString(), prop.get(key).toString());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void initWechat(){
		WxApiMethodName.THRID_ACCESS_TOKEN_URL=WxConfiguration.getProperties("third.tokenUrl");
		WxApiMethodName.THRID_AUTHCODE_URL=WxConfiguration.getProperties("third.authcodeUrl");
		WxApiMethodName.THRID_AUTHINFO_URL=WxConfiguration.getProperties("third.authinfoUrl");
		WxApiMethodName.THRID_AUTHTOKEN_URL=WxConfiguration.getProperties("third.authtokenUrl");
		WxApiMethodName.THRID_ACCOUNTINFO_URL=WxConfiguration.getProperties("third.accountinfoUrl");
		WxApiMethodName.THRID_GETOPTION_URL=WxConfiguration.getProperties("third.getoptionUrl");
		WxApiMethodName.THRID_SETOPTIN_URL=WxConfiguration.getProperties("third.setoptionUrl");
		
		WxApiMethodName.OAUTH2_CODE_URL=WxConfiguration.getProperties("oauth2.getCodeUrl");
		WxApiMethodName.OAUTH2_THIRD_ACCESS_TOKEN_URL=WxConfiguration.getProperties("oauth2.third.getAccessTokenUrl");
		WxApiMethodName.OAUTH2_THIRD_REFRESH_TOKEN_URL=WxConfiguration.getProperties("oauth2.third.refreshAccessTokenUrl");
		WxApiMethodName.OAUTH2_ACCESS_TOKEN_URL=WxConfiguration.getProperties("oauth2.getAccessTokenUrl");
		WxApiMethodName.OAUTH2_REFRESH_TOKEN_URL=WxConfiguration.getProperties("oauth2.refreshAccessTokenUrl");
		WxApiMethodName.OAUTH2_USERINFO_URL=WxConfiguration.getProperties("oauth2.getUserInfoUrl");
		
		WxApiMethodName.SEND_URL=WxConfiguration.getProperties("wechat.sendUrl");
		WxApiMethodName.ACCESS_TOKEN_URL=WxConfiguration.getProperties("wechat.tokenUrl");
		WxApiMethodName.JS_TICKET_URL=WxConfiguration.getProperties("wechat.jsticketUrl");
		
		WxApiMethodName.UPLOAD_URL=WxConfiguration.getProperties("wechat.uploadUrl");
		WxApiMethodName.DOWNLOAD_URL=WxConfiguration.getProperties("wechat.downloadUrl");
		
		WxApiMethodName.CREATE_GROUP_URL=WxConfiguration.getProperties("wechat.createGroupUrl");
		WxApiMethodName.UPDATE_GROUP_URL=WxConfiguration.getProperties("wechat.updateGroupUrl");
		WxApiMethodName.FIND_GROUP_URL=WxConfiguration.getProperties("wechat.findGroupUrl");
		WxApiMethodName.FIND_USERGROUP_URL=WxConfiguration.getProperties("wechat.findUserGroupUrl");
		WxApiMethodName.MEMBER_USER_URL=WxConfiguration.getProperties("wechat.memberUserUrl");
		
		WxApiMethodName.FIND_USERINFO_URL=WxConfiguration.getProperties("wechat.findUserInfoUrl");
		WxApiMethodName.FIND_USERINFO_LIST_URL=WxConfiguration.getProperties("wechat.findUserInfoListUrl");
		WxApiMethodName.FIND_USERLIST_URL=WxConfiguration.getProperties("wechat.findUserListUrl");
		
		WxApiMethodName.CREATE_MENU_URL=WxConfiguration.getProperties("wechat.createMenuUrl");
		WxApiMethodName.FIND_MENU_URL=WxConfiguration.getProperties("wechat.findMenuUrl");
		WxApiMethodName.REMOVE_MENU_URL=WxConfiguration.getProperties("wechat.removeMenuUrl");
		
		WxApiMethodName.CREATE_QRCODE_URL=WxConfiguration.getProperties("wechat.createQrCodeUrl");
		WxApiMethodName.SHOW_QRCODE_URL=WxConfiguration.getProperties("wechat.showQrCodeUrl");
		
		WxApiMethodName.SEND_MASS_GROUP_URL=WxConfiguration.getProperties("wechat.massGroupUrl");
		WxApiMethodName.SEND_MASS_OPENID_URL=WxConfiguration.getProperties("wechat.massOpenIdUrl");
		WxApiMethodName.DELETE_MASS_URL=WxConfiguration.getProperties("wechat.massDeleteUrl");
		
		WxApiMethodName.SEND_TEMPLATE_MSG_URL=WxConfiguration.getProperties("wechat.templateMsgUrl");
		WxApiMethodName.GET_TEMPLATE_ID_URL=WxConfiguration.getProperties("wechat.templateIdUrl");
		WxApiMethodName.GET_TEMPLATE_LIST_URL=WxConfiguration.getProperties("wechat.templateListUrl");
	}
	
	public static final String getProperties(String type) {
		return bundle.getString(type);
	}
	

}
