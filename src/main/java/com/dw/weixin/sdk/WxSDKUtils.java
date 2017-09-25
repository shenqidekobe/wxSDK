package com.dw.weixin.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 微信SDK工具类，提供常用的方法
 * */
public class WxSDKUtils {
	
	/**
	 * 创建一个随机的字符串，基于UUID
	 * */
	public static String createNonceStr() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 创建当前时间戳的字符串
	 * */
	public static String createTimestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
	
	/**
	 * 生成一个基于大小写数据的随机字符串
	 * 
	 * @param length
	 * 
	 * @return String
	 * */
	public static String randomString(int length) {  
	    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
	    Random random = new Random();  
	    StringBuffer buf = new StringBuffer();  
	    for (int i = 0; i < length; i++) {  
	        int num = random.nextInt(base.length());  
	        buf.append(base.charAt(num));  
	    }  
	    return buf.toString();  
	}  
	

	/**
	 * 解析request inputStream成字符串
	 * */
    public static String readStreamParameter(InputStream in){  
        StringBuilder buffer = new StringBuilder();  
        BufferedReader reader=null;  
        try{  
            reader = new BufferedReader(new InputStreamReader(in));  
            String line=null;  
            while((line = reader.readLine())!=null){  
                buffer.append(line);  
            }  
            return new String(buffer.toString().getBytes(),"UTF-8");
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            if(null!=reader){  
                try {  
                    reader.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return null;
    }
    
    /**
     * xml字符串转换为map
     * */
    public static Map<String,String> parseXml(String xmlStr){
    	Map<String,String> map=new HashMap<String, String>();
    	try {
			Document doc=DocumentHelper.parseText(xmlStr);
			Element root= doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> list=root.elements();
			for(Element ele:list){
				map.put(ele.getName(), ele.getText().trim());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	return map;
    }
    
    /**
     * 解析xml获取Encrypt，主要用于加密微信推送过来的消息
     * */
    public static String parseXmlAsEncrypt(String xmlStr){
    	try {
			Document doc=DocumentHelper.parseText(xmlStr);
			Element root= doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> list=root.elements();
			for(Element ele:list){
				if("Encrypt".equals(ele.getName())){
					return ele.getText().trim();
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    	return "";
    }
}
