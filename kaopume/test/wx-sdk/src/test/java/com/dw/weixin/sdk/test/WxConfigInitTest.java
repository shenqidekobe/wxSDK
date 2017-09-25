package com.dw.weixin.sdk.test;

import org.junit.Test;

import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxConfiguration;

public class WxConfigInitTest {
	
	
	@Test
	public void test(){
		WxConfiguration.initWeixinErrorProperties();
		for(String key:WxConstanst.errorMap.keySet()){
			System.out.println(key+" = "+WxConstanst.errorMap.get(key));
		}
		System.out.println(WxConstanst.errorMap.get("125")==null);
	}

}
