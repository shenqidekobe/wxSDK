package com.dw.weixin.sdk.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信基础常量定义
 * */
public class WxConstanst {
	
	public static String CURRENT_SDK_APPID=null;//当前SDK初始化的帐号ID
	public static Boolean IS_THIRD_PLATFORM=true;//当前调用者是否为第三方平台，默认是
	public static String CURRENT_THIRD_PLATFORM_VERIFY_TICKET=null;//当前SDK的第三方平台的component_verify_ticket(微信服务器每隔十分钟定时推送)
	
	/**
	 * HTTP请求调用方式，分为{默认、上传、下载}
	 * */
	public static enum REQUEST_PROCESS_WAY{
		DEFAULT,UPLOAD,DOWNLOAD
	}

	/**
	 * 公众号授权给第三方的权限集ID说明
	 * */
	public static class FUNCINFO_ID{
		public static final Integer MSGANDMENU_FUNC_ID=1;//消息与菜单权限集
		public static final Integer USER_FUNC_ID=2;//用户管理权限集
		public static final Integer ACCOUNT_FUNC_ID=3;//帐号管理权限集
		public static final Integer WEBAUTH_FUNC_ID=4;//网页授权权限集
		public static final Integer MINSTORE_FUNC_ID=5;//微信小店权限集
		public static final Integer SERVICE_FUNC_ID=6;//多客服权限集
		public static final Integer BUSINESS_FUNC_ID=7;//业务通知权限集
		public static final Integer CARD_FUNC_ID=8;//微信卡券权限集
		public static final Integer SCAN_FUNC_ID=9;//微信扫一扫权限集
		public static final Integer CONWIFI_FUNC_ID=10;//微信连WIFI权限集
		public static final Integer MATERIAL_FUNC_ID=11;//素材管理权限集
		public static final Integer SHARK_FUNC_ID=12;//摇一摇周边权限集
		public static final Integer DOORSTORE_FUNC_ID=13;//微信门店权限集
		
	}
	
	/**
	 * 参数token的名称
	 * */
	public static final class ACCESS_TOKEN_NAMES{
		public static final String NO_ACCESS_TOKEN="no_token";//无需accessToken的请求
		public static final String ACCESS_TOKEN="access_token";//微信公众号的API
		public static final String THIRD_ACCESS_TOKEN="component_access_token";//第三方平台接口使用的参数名
	}
	
	/**
	 * 请求方式
	 * */
	public static final class REQUEST_METHOD{
		public static final String POST="post";
		public static final String GET="get";
	}
	
	/**
	 * HTTP协议类型
	 * */
	public static final class PROTOCOL_TYPE{
		public static final String HTTPS="https";
		public static final String HTTP="http";
	}
	
	public static final String XML_ROOT_NAME = "xml";
	public static Map<String, String> errorMap=new HashMap<String, String>();//微信错误信息map
	
	
}
