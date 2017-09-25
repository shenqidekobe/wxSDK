package com.dw.weixin.sdk;

import java.util.Map;

import com.dw.weixin.sdk.request.WxXmlRequest;
import com.thoughtworks.xstream.XStream;

/**
 * xml序列化和反序列化工具实现类
 * 
 * @author kobe
 * */
@SuppressWarnings({"rawtypes","unchecked"})
public class XStreamUtil<T extends WxXmlRequest> {

	/**
	 * obj to xml
	 * */
	public static String toXml(WxXmlRequest request){
		XStream xstream = new XStream();
		Map<String, Class> map = request.getRequestContainClass();
		for(Map.Entry<String, Class> entry : map.entrySet()){
			xstream.alias(entry.getKey(), entry.getValue());
		}
		String xml = xstream.toXML(request);
		return xml;
	}
	
	/**
	 * xml to obj
	 * */
	public static <T extends WxXmlRequest> T fromXml(String xml,Class<T> clazz){
		XStream xstream = new XStream();
		T returnObj = null;
		try {
			returnObj = clazz.newInstance();
			Map<String, Class> map = returnObj.getRequestContainClass();
			for(Map.Entry<String, Class> entry : map.entrySet()){
				xstream.alias(entry.getKey(), entry.getValue());
			}
			returnObj = (T)xstream.fromXML(xml);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return returnObj;
	}

}
