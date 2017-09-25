package com.dw.weixin.sdk.base.thrid;

import java.util.Map;

import com.dw.weixin.sdk.base.WxObject;

/**
 * 第三方平台使用的授权方信息
 * */
public class ThridAuthorizerObject extends WxObject {

	private static final long serialVersionUID = -102363364843592909L;
	
	private String nick_name;//授权方昵称
	
	private String head_img;//授权方头像
	
	private Map<String,Integer> service_type_info;//授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
	
	private Map<String,Integer> verify_type_info;//授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
	
	private String user_name;//授权方公众号的原始ID
	
	private String alias;//授权方公众号所设置的微信号，可能为空
	
	private String qrcode_url;//二维码图片的URL
	
	/**
	 *  用以了解以下功能的开通状况（0代表未开通，1代表已开通）：
		 open_store:是否开通微信门店功能
		 open_scan:是否开通微信扫商品功能
		 open_pay:是否开通微信支付功能
		 open_card:是否开通微信卡券功能
		 open_shake:是否开通微信摇一摇功能
	 * */
	private Map<String,Integer> business_info;

	
	
	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getHead_img() {
		return head_img;
	}

	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}

	public Map<String, Integer> getService_type_info() {
		return service_type_info;
	}

	public void setService_type_info(Map<String, Integer> service_type_info) {
		this.service_type_info = service_type_info;
	}

	public Map<String, Integer> getVerify_type_info() {
		return verify_type_info;
	}

	public void setVerify_type_info(Map<String, Integer> verify_type_info) {
		this.verify_type_info = verify_type_info;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getQrcode_url() {
		return qrcode_url;
	}

	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}

	public Map<String, Integer> getBusiness_info() {
		return business_info;
	}

	public void setBusiness_info(Map<String, Integer> business_info) {
		this.business_info = business_info;
	}


	
}
