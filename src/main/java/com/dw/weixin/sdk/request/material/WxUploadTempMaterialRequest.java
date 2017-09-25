package com.dw.weixin.sdk.request.material;

import java.io.File;
import java.util.Map;

import com.dw.weixin.sdk.RequestCheckUtils;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxApiMethodName;
import com.dw.weixin.sdk.exception.WeixinSDKRuleException;
import com.dw.weixin.sdk.response.material.WxUploadTempMaterialResponse;

/**
 * 上传临时素材到微信服务器请求
 * */
public class WxUploadTempMaterialRequest implements WxRequest<WxUploadTempMaterialResponse>{

	
	private String type;//媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	
	private File file;//上传的文件信息

	@Override
	public String getApiMethodUrl() {
		return WxApiMethodName.UPLOAD_URL;
	}

	@Override
	public void check() throws WeixinSDKRuleException {
		RequestCheckUtils.checkNotEmpty(this.type, "type");
		RequestCheckUtils.checkNotEmpty(this.file, "file");
	}

	@Override
	public Class<WxUploadTempMaterialResponse> getResponseClass() {
		return WxUploadTempMaterialResponse.class;
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
		return WxConstanst.REQUEST_PROCESS_WAY.UPLOAD.toString();
	}
	@Override
	public Integer getApiFuncInfoId(){
		//从属素材权限集
		return WxConstanst.FUNCINFO_ID.MATERIAL_FUNC_ID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
