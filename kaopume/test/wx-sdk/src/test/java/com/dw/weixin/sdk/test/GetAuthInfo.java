package com.dw.weixin.sdk.test;

import com.alibaba.fastjson.JSON;
import com.dw.weixin.sdk.response.third.ThirdGetAuthorizerInfoResponse;

import flexjson.JSONDeserializer;

public class GetAuthInfo {
	
	public static void main(String[] args) {
		String json="{\"authorizer_info\":{\"nick_name\":\"智慧消息树\",\"service_type_info\":{\"id\":2},\"verify_type_info\":{\"id\":0},"+
				"\"user_name\":\"gh_87950ab61f0e\",\"alias\":\"\","+
				"\"qrcode_url\":\"http://mmbiz.qpic.cn/mmbiz/Glgg3aMib9LzMU0sE9pdxkM4R1H3CnHoMhZ6ppm2yN0MolFlulviacIbRCZgUt5dyuyEE0XUIsIO4Tj2VdiaAt2fg0\","+
				"\"business_info\":{\"open_pay\":0,\"open_shake\":0,\"open_scan\":0,\"open_card\":0,\"open_store\":0}},"+
				"\"authorization_info\":{\"authorizer_appid\":\"wx8752dce687099e76\",\"func_info\":[{\"funcscope_category\":{\"id\":1}},"+
				                                                                           "{\"funcscope_category\":{\"id\":2}},"+
				                                                                           "{\"funcscope_category\":{\"id\":11}}]}}";
		 ThirdGetAuthorizerInfoResponse rsp = JSON.parseObject(json,ThirdGetAuthorizerInfoResponse.class);
		 
	   System.out.println(rsp.getAuthorizer_info().getQrcode_url());
		
		System.out.println(json);
		 
		 JSONDeserializer<ThirdGetAuthorizerInfoResponse> deserializer=new JSONDeserializer<ThirdGetAuthorizerInfoResponse>();
		 ThirdGetAuthorizerInfoResponse resultDto=deserializer.deserialize(json,ThirdGetAuthorizerInfoResponse.class);
		 System.err.println(resultDto.getAuthorizer_info());
	}

}
