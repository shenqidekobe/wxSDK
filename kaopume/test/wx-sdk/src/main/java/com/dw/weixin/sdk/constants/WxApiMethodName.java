package com.dw.weixin.sdk.constants;

/**
 * 微信api方法接口地址
 * */
public class WxApiMethodName {
	
	/** 获取第三方平台accessToken */
	public static String THRID_ACCESS_TOKEN_URL;
	/** 获取预授权代码Url */
	public static String THRID_AUTHCODE_URL;
	/**使用授权码换取公众号的授权信息 Url */
	public static String THRID_AUTHINFO_URL;
	/** 获取（刷新）授权公众号的令牌 Url */
	public static String THRID_AUTHTOKEN_URL;
	/** 获取授权方的账户信息 Url */
	public static String THRID_ACCOUNTINFO_URL;
	/** 获取授权方的选项设置信息 Url */
	public static String THRID_GETOPTION_URL;
	/** 设置授权方的选项信息 Url */
	public static String THRID_SETOPTIN_URL;
	
	
	/**公众号发起网页授权 请求code*/
	public static String OAUTH2_CODE_URL;
	/**第三方服务通过code换取access_token*/
	public static String OAUTH2_THIRD_ACCESS_TOKEN_URL;
	/**第三方服务刷新access_token*/
	public static String OAUTH2_THIRD_REFRESH_TOKEN_URL;
	/**公众号自己通过code换取access_token*/
	public static String OAUTH2_ACCESS_TOKEN_URL;
	/**公众号自己刷新access_token*/
	public static String OAUTH2_REFRESH_TOKEN_URL;
	/**通过网页授权access_token获取用户基本信息（需授权作用域为snsapi_userinfo）*/
	public static String OAUTH2_USERINFO_URL;
	
	
	/** 获取accesstoken Url */
	public static String ACCESS_TOKEN_URL;
	/** 获取JS-SDK认证的ticket*/
	public static String JS_TICKET_URL;
	/** 发送消息Url */
	public static String SEND_URL;
	/**上传文件 Url */
	public static String UPLOAD_URL;
	/** 下载文件 Url */
	public static String DOWNLOAD_URL;
	
	/** 创建分组 Url */
	public static String CREATE_GROUP_URL;
	/** 修改分组 Url */
	public static String UPDATE_GROUP_URL;
	/** 查询分组 Url */
	public static String FIND_GROUP_URL;
	/** 查询用户所在分组 Url */
	public static String FIND_USERGROUP_URL;
	/** 将用户进行分组 Url */
	public static String MEMBER_USER_URL;
	/** 获取用户基本信息 Url */
	public static String FIND_USERINFO_URL;
	/** 批量获取用户基本信息 Url */
	public static String FIND_USERINFO_LIST_URL;
	/** 获取用户列表 Url */
	public static String FIND_USERLIST_URL;
	
	/** 创建菜单 Url */
	public static String CREATE_MENU_URL;
	/** 查询菜单 Url */
	public static String FIND_MENU_URL;
	/** 删除菜单 Url */
	public static String REMOVE_MENU_URL;
	
	/**创建带参数二维码Url*/
	public static String CREATE_QRCODE_URL;
	/**通过ticket换取二维码Url*/
	public static String SHOW_QRCODE_URL;
	
	/** 按用户分组群发消息 Url */
	public static String SEND_MASS_GROUP_URL;
	/** 按OpenID群发消息 Url */
	public static String SEND_MASS_OPENID_URL;
	/** 删除群发消息 Url */
	public static String DELETE_MASS_URL;
	
	/** 发送模版消息 Url */
	public static String SEND_TEMPLATE_MSG_URL;
	/** 获取模版ID Url */
	public static String GET_TEMPLATE_ID_URL;
	/** 获取模版列表 Url */
	public static String GET_TEMPLATE_LIST_URL;

}
