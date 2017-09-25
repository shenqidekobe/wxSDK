package com.dw.weixin.sdk.response.material;

import java.io.InputStream;

import com.dw.weixin.sdk.base.WxResponse;

/**
 * 下载临时素材的返回对象
 * */
public class WxDownloadTempMaterialResponse extends WxResponse{

	private static final long serialVersionUID = 3360724335297349207L;
	
	private InputStream inputStream;//返回的文件流

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
