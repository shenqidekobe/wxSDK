package com.dw.weixin.sdk;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信的签名验证算法
 * checkAuthentication、提供微信公众号接入服务器验证
 * checkJsSDKSign、微信JS-SDK签名验证
 * 
 * @author kobe
 * */
public class WxCheckArithmetic {
	
	private static final String DEFAULT_ERROR_MSG="verifyFailure";//默认的错误验证消息(无需关心此错误消息，只需关心成功即可)
	
	/**
	 * 验证微信公众号是否可用
	 * @param token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * 
	 * @return echostr
	 * */
	public static String checkAuthentication(String token,String signature,String timestamp,String nonce,String echostr) {
        String result=DEFAULT_ERROR_MSG;
        String[] ArrTmp = {token, timestamp, nonce };
        Arrays.sort(ArrTmp);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ArrTmp.length; i++) {
            sb.append(ArrTmp[i]);
        }
        String pwd = Encrypt(sb.toString()); // 对排序后的字符串进行SHA-1加密
        if (pwd.equals(signature)) { 
            try {
                result = echostr;
            } catch (Exception e) {
                e.printStackTrace();
            } 
        } 
        return result;
    }
	
	/**
	 * SHA1生成签名字符串
	 * */
	public static String getSHA1(String token, String timestamp, String nonce, String encrypt)throws Exception{
		String[] array = new String[] { token, timestamp, nonce, encrypt };
		StringBuffer sb = new StringBuffer();
		// 字符串排序
		Arrays.sort(array);
		for (int i = 0; i < 4; i++) {
			sb.append(array[i]);
		}
		String str = sb.toString();
		// SHA1签名生成
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(str.getBytes());
		byte[] digest = md.digest();

		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		return hexstr.toString();
	}
	
	/**
	 *微信JSSDK签名认证
	 *@param jsapiTicket
	 *@param url
	 *
	 *@return map
	 * */
	public static Map<String, String> checkJsSDKSign(String jsapiTicket,String url) {
		Map<String, String> ret = new HashMap<String, String>();
		try {
			String nonce_str = WxSDKUtils.createNonceStr();
			String timestamp = WxSDKUtils.createTimestamp();
			String signature = "";
			String string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
			ret.put("url", url);
			ret.put("jsapiTicket", jsapiTicket);
			ret.put("nonceStr", nonce_str);
			ret.put("timestamp", timestamp);
			ret.put("signature", signature);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ret;

	}
	

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	

    
    /**
     * 用SHA-1算法加密字符串并返回16进制串
     * 
     * @param strSrc
     * @return
     */
    private static String Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
            return null;
        }
        return strDes;
    }

    private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

}
