package com.dw.weixin.sdk;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.dw.weixin.sdk.base.crypt.WxMsgDecryptObject;
import com.dw.weixin.sdk.base.crypt.WxMsgEncryptObject;
import com.dw.weixin.sdk.cache.WxAccountPoolManager;
import com.dw.weixin.sdk.cache.base.WxAccountObject;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * 微信消息加解密工具类
 * */
public class WxBizMsgCryptUtils {

	private static WXBizMsgCrypt wxMsgCrypt = null;
	
	/**
	 * 从缓存池中初始化
	 * */
	public WxBizMsgCryptUtils() {
		try {
			if(wxMsgCrypt==null){
				String appId=WxConstanst.CURRENT_SDK_APPID;
				WxAccountObject obj=WxAccountPoolManager.getObject(appId);
				String token=obj.getAccountToken();
				String encodingAesKey=obj.getEncodingAesKey();
				wxMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
			}
		} catch (AesException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 外部传入参数初始化
	 * */
	public WxBizMsgCryptUtils(String appId, String token, String encodingAesKey) {
		try {
			wxMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
		} catch (AesException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 消息加密
	 * 
	 * @param msgEncrypt
	 * 
	 * @return WxMsgDecryptObject
	 * */
	public WxMsgDecryptObject encryptMsg(WxMsgEncryptObject msgEncrypt) {
		if (msgEncrypt == null) {
			return null;
		}
		WxMsgDecryptObject decrypt = null;
		try {
			String timestamp = msgEncrypt.getTimestamp();
			timestamp=StringUtils.isEmpty(timestamp)?WxSDKUtils.createTimestamp():timestamp;
			String nonceStr = msgEncrypt.getNonceStr();
			nonceStr=StringUtils.isEmpty(nonceStr)?WxSDKUtils.createNonceStr():nonceStr;
			String cipher = wxMsgCrypt.encryptMsg(msgEncrypt.getReplyMsg(),
					msgEncrypt.getTimestamp(), msgEncrypt.getNonceStr());
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(cipher);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

			String encrypt = nodelist1.item(0).getTextContent();
			String msgSignature = nodelist2.item(0).getTextContent();

			decrypt = new WxMsgDecryptObject(encrypt, msgSignature, timestamp,
					nonceStr);

		} catch (AesException | ParserConfigurationException | SAXException
				| IOException e) {
			e.printStackTrace();
		}
		return decrypt;
	}

	/**
	 * 消息解密
	 * 
	 * @param encrypt
	 *            :
	 * @param msgSignature
	 *            :加密后的消息签名字符串
	 * @param timestamp
	 *            :时间戳,加密时的时间戳
	 * @param nonceStr
	 *            :随机字符串,加密时的随机字符串
	 * 
	 * @return
	 * */
	public String decryptMsg(WxMsgDecryptObject msgDecrypt) {
		if (msgDecrypt == null) {
			return null;
		}
		String xml = null;
		try {

			String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
			String fromXML = String.format(format, msgDecrypt.getEncrypt());

			xml = wxMsgCrypt.decryptMsg(msgDecrypt.getMsgSignature(),
					msgDecrypt.getTimestamp(), msgDecrypt.getNonceStr(),
					fromXML);
		} catch (AesException e) {
			e.printStackTrace();
		}
		return xml;
	}

}
