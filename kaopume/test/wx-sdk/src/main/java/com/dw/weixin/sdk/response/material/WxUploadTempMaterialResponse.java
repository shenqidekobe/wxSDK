package com.dw.weixin.sdk.response.material;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 上传临时素材到微信服务器返回的对象信息
 * */
public class WxUploadTempMaterialResponse extends WxResponse{

	private static final long serialVersionUID = 5710695522062951209L;
	
	private String type;//素材的类型
	
	private String media_id;//微信服务器返回的素材ID
	
	private Long created_at;//素材上传的时间戳
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public Long getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}
}
