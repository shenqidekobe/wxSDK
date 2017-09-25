package com.dw.weixin.sdk.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.weixin.sdk.cache.base.WxAuthAccountObject;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.constants.WxEnumTransform;
import com.dw.weixin.sdk.exception.WeixinSDKException;
import com.dw.weixin.sdk.openapi.IWeixinBasisAPI;
import com.dw.weixin.sdk.openapi.factory.WeixinAPIFactory;
import com.dw.weixin.sdk.openapi.factory.WeixinAPInitObject;
import com.dw.weixin.sdk.request.oper.WxUserInfoGetRequest;
import com.dw.weixin.sdk.request.third.ThirdPreauthCodeRequest;
import com.dw.weixin.sdk.response.third.ThirdPreauthCodeResponse;

/**
 * 微信SDK调用对外API接口测试
 * */
public class APITest {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	private WeixinAPInitObject initObject=null;
	
	private IWeixinBasisAPI weixinAPI=null;
	
	private String thirdAppId="wx267a74303baa5ae2";
	
	private String authorizerAppId="wxce9a5c23715b8337";
	
	
	@Before
	public void init(){
		String thirdAppSecret="3814c2123df76500808321a45bc6e3c4";
		String encodingAesKey="uF1LP2Lc5xRGzJX2CprfnbGSArsVCuru2Ei5SSZA09m";
		String token="dwAdmin1qaz";
		WxConstanst.CURRENT_THIRD_PLATFORM_VERIFY_TICKET="ticket@@@SngPAawZR2p5EboRRoqSJ-FmOan4Ho8AGXrWsZhQlHGTO1lkS97AMIJY9kzjQ0BIAOe7s99Spmy8UliS2R3a1g";
		Map<String, WxAuthAccountObject> authAppMap=new HashMap<String,WxAuthAccountObject>();
		WxAuthAccountObject authApp=new WxAuthAccountObject();
		authApp.setAuthCode("1266566545545455");
		authAppMap.put(authorizerAppId, authApp);
		initObject=new WeixinAPInitObject();
		initObject.setAppId(thirdAppId);
		initObject.setAppSecret(thirdAppSecret);
		initObject.setEncodingAesKey(encodingAesKey);
		initObject.setAppToken(token);
		initObject.setAuthAppMap(authAppMap);
	}
	
	@Test
	public void craeteAPI(){
		try {
			weixinAPI=WeixinAPIFactory.createIWeixinAPI(WxEnumTransform.CALL_API_WAY.THIRD_PROXY, initObject);
		} catch (WeixinSDKException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void getPreAuthCode(){
		try {
			ThirdPreauthCodeRequest req1=new ThirdPreauthCodeRequest();
			req1.setComponent_appid(thirdAppId);
			WxUserInfoGetRequest req2 = new WxUserInfoGetRequest();
			req2.setOpenid("oMe0_t_3ECT6oR4xdYnwY-0P85Nc");
			ThirdPreauthCodeResponse rsp1=(ThirdPreauthCodeResponse) weixinAPI.sendReq(req1, authorizerAppId);
			//WxUserInfoGetResponse rsp2=(WxUserInfoGetResponse) weixinAPI.sendReq(req2, thirdAppId);
			logger.info("预授权码:"+rsp1.getPre_auth_code());
			//logger.info("用户头像信息："+rsp2.getHeadimgurl());
		} catch (WeixinSDKException e) {
			e.printStackTrace();
		}
	}
	

}
