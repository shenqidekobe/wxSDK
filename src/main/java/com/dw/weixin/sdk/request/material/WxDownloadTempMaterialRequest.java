package com.dw.weixin.sdk.request.material;

import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.material.WxDownloadTempMaterialResponse;

/**
 * 从微信服务器下载临时素材请求
 * */
public class WxDownloadTempMaterialRequest implements WxRequest<WxDownloadTempMaterialResponse>{

	
	private String media_id;//媒体文件ID

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.DOWNLOAD_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.media_id, "media_id");
	}

	@Override
	public Class<WxDownloadTempMaterialResponse> getResponseClass() {
		return WxDownloadTempMaterialResponse.class;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	@Override
	public String getApiMethodRequestType() {
		return WxConstanst.REQUEST_METHOD.POST;
	}

	@Override
	public String getAccessTokenParamName() {
		return WxConstanst.ACCESS_TOKEN_NAMES.ACCESS_TOKEN;
	}
	@Override
	public String getRequestProcessWay(){
		return WxConstanst.REQUEST_PROCESS_WAY.DOWNLOAD.toString();
	}
	@Override
	public Integer getApiFuncInfoId(){
		//从属素材权限集
		return WxConstanst.FUNCINFO_ID.MATERIAL_FUNC_ID;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
}
