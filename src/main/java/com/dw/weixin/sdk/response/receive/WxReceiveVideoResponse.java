package com.dw.weixin.sdk.response.receive;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.WxReceiveResponse;
/**
 * 接收视频消息
 * @author kobe
 */
@SuppressWarnings({"rawtypes"})
public class WxReceiveVideoResponse  extends WxReceiveResponse {
	
	private static final long serialVersionUID = 4919486720092193326L;
	
	/**视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。*/
	private String  ThumbMediaId;
	/**视频消息媒体id，可以调用多媒体文件下载接口拉取数据。*/
	private String  MediaId;
	
	public WxReceiveVideoResponse() {
		setMsgType(WxEnumTransform.MSG_TYPE.video.toString());
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
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
}
