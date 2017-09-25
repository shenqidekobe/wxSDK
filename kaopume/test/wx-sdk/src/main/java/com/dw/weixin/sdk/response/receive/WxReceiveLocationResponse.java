package com.dw.weixin.sdk.response.receive;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.WxReceiveResponse;
/**
 * 接收位置消息
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxReceiveLocationResponse  extends WxReceiveResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	/**地理位置维度*/
	private String  Location_X;
	/**地理位置经度*/
	private String  Location_Y;
	/**地图缩放大小*/
	private Integer  Scale;
	/**地理位置信息*/
	private String  Label;
	
	public WxReceiveLocationResponse() {
		setMsgType(WxEnumTransform.MSG_TYPE.location.toString());
	}
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public Integer getScale() {
		return Scale;
	}
	public void setScale(Integer scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		super.check();
	}
	@Override
	public Map<String, Class> getRequestContainClass() {
		Map<String, Class> mapClass = new LinkedHashMap<String, Class>();
		mapClass.put(WxConstanst.XML_ROOT_NAME, this.getClass());
		return mapClass;
	}
	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.ACCESS_TOKEN;
	}
}
