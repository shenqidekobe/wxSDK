package com.dw.weixin.sdk.constants;


/**
 * 定义提供对外的微信枚举类型
 * */
public class WxEnumTransform {
	
	public static final String WEIXIN_RESPONSE_SUCCESS="success";//返回给微信服务器的正确回复
	
	/**
	 * API的调用方式，分为{公众号调用和代公众号调用(第三方平台)}
	 * */
	public static enum CALL_API_WAY{
		THIRD_PROXY,WEIXIN_PUBLIC
	}
	
	/**
	 * 微信的消息类型
	 */
	public static enum MSG_TYPE{
		text,//文本消息
		image,//图片消息
		voice,//语音消息
		video,//视频消息
		shortvideo,//小视频消息
		music,//音乐消息
		news,//图文消息
		location,//回复地理位置消息
		link,//链接
		event,//事件
	}
	
	/**
	 * 微信推送的事件类型
	 */
	public static enum EVENT_TYPE{
		CLICK, //菜单事件-点击
		VIEW,   //菜单事件-视图
		LOCATION, //地理位置事件
		SCAN,  //用户已关注时的事件推送
		subscribe,   //关注事件:订阅
		unsubscribe,   //关注事件: 取消订阅
	}
	
	/**
	 * 微信的文件类型
	 * */
	public static enum FILE_TYPE{
		image,//图片image
		voice,//语音voice
		video,//视频video
		thumb,//缩略图thumb
	}
	
	/**
	 * 微信的自定义菜单类型
	 * */
	public static enum MENU_TYPE{
		click, //点击推事件
		view, //跳转URL
		scancode_push, //扫码推事件
		scancode_waitmsg, //扫码推事件且弹出“消息接收中”提示框
		pic_sysphoto, //弹出系统拍照发图
		pic_photo_or_album, //弹出拍照或者相册发图
		pic_weixin, //弹出微信相册发图器
		location_select, //弹出地理位置选择器
		media_id, //下发消息（除文本消息）
		view_limited, //跳转图文消息URL
	}
	

	/**
	 * 用户基本信息返回语言
	 */
	public static enum LANG_TYPE{
		zh_CN, //简体
		zh_TW, //繁体
		en,//英语
	}
	
	/** 
	 * 二维码类型
	 */
	public static enum QR_CODE_TYPE{
		QR_SCENE,//临时二维码，时常1800秒
		QR_LIMIT_SCENE//永久二维码
	}
	
	/**
	 * 微信服务器向第三方平台推送的事件类型
	 * */
	public static enum THIRD_EVENT_TYPE{
		component_verify_ticket,//推送component_verify_ticket
		unauthorized//推送取消授权通知
	}

}
