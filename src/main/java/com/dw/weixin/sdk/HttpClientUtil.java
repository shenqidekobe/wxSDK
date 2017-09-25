package com.dw.weixin.sdk;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSON;

/**
 * httpClient utils
 * */
public class HttpClientUtil {
	
	private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000)
            .setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000)
            .build();
	
	/**
	 * 执行post请求 protocol:协议
	 * */
	public static HttpEntity _executePost(String url, Map<String,String> maps) {
		CloseableHttpClient client=HttpClients.createDefault();
		HttpEntity httpEntity = null;
		try {
			HttpPost post = new HttpPost(url);
			String jsonData = JSON.toJSONStringWithDateFormat(maps, "yyyy-MM-dd HH:mm:ss");
			post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
			StringEntity entity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
			post.setEntity(entity);
			post.setConfig(requestConfig);
			CloseableHttpResponse res = client.execute(post);
			if (HttpStatus.SC_OK == res.getStatusLine().getStatusCode()) {
				httpEntity = res.getEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpEntity;
	}

	/**
	 * 执行get请求
	 * */
	public static CloseableHttpResponse executeGet(String url) {
		CloseableHttpClient client=HttpClients.createDefault();
		CloseableHttpResponse res = null;
		try {
			HttpGet get = new HttpGet(url);
			get.setConfig(requestConfig);
			res = client.execute(get);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
