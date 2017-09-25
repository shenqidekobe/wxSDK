package com.dw.weixin.sdk.test;

import com.dw.weixin.sdk.XStreamUtil;
import com.dw.weixin.sdk.response.third.ThirdTicketUnauthorizedResponse;

public class ReturnTicketTest {
	
	
	public static void main(String[] args)throws Exception {
		String xml="<xml><AppId><![CDATA[wx267a74303baa5ae2]]></AppId>\n"
				+ "<CreateTime>1452053476</CreateTime>\n<InfoType>"
				+ "<![CDATA[component_verify_ticket]]></InfoType>\n"
				+ "<ComponentVerifyTicket><![CDATA[ticket@@@g7nlIZH8g6vqUC5SZF2MhwKdPbu6VL3g7FMcQAzGoZP8z9csN_GLhVIkNrOrCEejsHF7O2Ll7fVA_eWORyoweA]]>"
				+ "</ComponentVerifyTicket>\n</xml>";
		
		xml="<xml><AppId><![CDATA[wx267a74303baa5ae2]]></AppId><CreateTime>1452055278</CreateTime><InfoType><![CDATA[component_verify_ticket]]></InfoType><ComponentVerifyTicket><![CDATA[ticket@@@g7nlIZH8g6vqUC5SZF2MhwKdPbu6VL3g7FMcQAzGoZP8z9csN_GLhVIkNrOrCEejsHF7O2Ll7fVA_eWORyoweA]]></ComponentVerifyTicket></xml>";
		
		System.out.println(xml);
		ThirdTicketUnauthorizedResponse rsp=XStreamUtil.fromXml(xml, ThirdTicketUnauthorizedResponse.class);
		
		System.out.println(rsp.getInfoType());
	}

}
