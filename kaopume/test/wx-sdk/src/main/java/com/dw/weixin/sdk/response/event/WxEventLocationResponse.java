package com.dw.weixin.sdk.response.event;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.response.WxEventResponse;

/**
 * 上报地理位置事件
 * Event: LOCATION
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxEventLocationResponse extends WxEventResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	/**地理位置纬度*/
	private String Latitude;
	
	/**地理位置经度*/
	private String Longitude;
	
	/**地理位置精度*/
	private String Precision;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}
	
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}

}
