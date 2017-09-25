package com.dw.weixin.sdk.base;

import java.io.Serializable;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;

/**
 * 接收微信服务器信息基类
 * */
public class WxResponse implements Serializable {
	private static final long serialVersionUID = 5014379068811962022L;
	
	private String errcode="0";
	private String errmsg="ok";
	
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	
	public String getErrmsg() {
		if("0".equals(errcode)){
			errmsg=WxEnumTransform.WEIXIN_RESPONSE_SUCCESS;
		}else{
			String errorVal=WxConstanst.errorMap.get(errcode);
			if(errorVal!=null&&errorVal!=""){
				errmsg=errorVal;
			}
		}
		return errmsg;
	}
	
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	public boolean isSuccess(){
		if("0".equals(errcode)){
			return true;
		}
		if(errcode==null||errcode==""){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "WxResponse [errcode=" + errcode + ", errmsg=" + getErrmsg() + "]";
	}
	
}