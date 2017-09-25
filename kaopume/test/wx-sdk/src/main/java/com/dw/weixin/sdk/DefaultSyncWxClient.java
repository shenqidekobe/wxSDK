package com.dw.weixin.sdk;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dw.weixin.sdk.base.SyncWxClient;
import com.dw.weixin.sdk.base.WxRequest;
import com.dw.weixin.sdk.base.WxResponse;
import com.dw.weixin.sdk.cache.WxAccountPoolManager;
import com.dw.weixin.sdk.constants.WxConstanst;
import com.dw.weixin.sdk.exception.WeixinSDKException;
import com.dw.weixin.sdk.request.material.WxUploadTempMaterialRequest;
import com.dw.weixin.sdk.response.material.WxDownloadTempMaterialResponse;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

/**
 * 调用请求的默认处理实现
 * 
 * @author kobe
 */
public class DefaultSyncWxClient implements SyncWxClient {
	
	private Logger logger=LoggerFactory.getLogger(DefaultSyncWxClient.class);
	
	/**http请求基础配置*/
	private RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000)
            .setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000)
            .build();
	
	/**http的请求地址*/
	private String requestUrl;
	/**http请求的协议，默认https*/
	private String protocol=WxConstanst.PROTOCOL_TYPE.HTTPS;
	/**是否需验证请求参数*/
	private boolean needCheckRequest;
	/**调用微信请求的accessToken值*/
	private String accessTokenValue;
	/**调用者的微信appId*/
	private String appId;
	
	public DefaultSyncWxClient(String appId){
		this(null,appId);
	}
	
	public DefaultSyncWxClient(String requestUrl ,String appId) {
		this(null,WxConstanst.PROTOCOL_TYPE.HTTPS, appId);
	}
	
	private DefaultSyncWxClient(String requestUrl,String protocol ,String appId) {
		this.needCheckRequest = true;
		
		this.requestUrl = requestUrl;
		this.protocol = protocol;
		this.appId=appId;
		
	}
	
	public <T extends WxResponse> T execute(WxRequest<T> request) throws WeixinSDKException {
		return _execute(request, null);
	}
	
	@SuppressWarnings("unchecked")
	private <T extends WxResponse> T _execute(WxRequest<T> request,String session) throws WeixinSDKException {
		if (this.needCheckRequest&&request!=null) {   //检查请求参数
			try {
				request.check();
			} catch (WeixinSDKException e) {
				try {
					WxResponse localResponse = request.getResponseClass().newInstance();
					localResponse.setErrcode(e.getErrCode());
					localResponse.setErrmsg(e.getErrMsg());
					return  ((T) localResponse);
				} catch (InstantiationException | IllegalAccessException e1) {
				}
			}
		}
		WxResponse tRsp = null;
		String json = null;
		try {
			requestUrl = request.getApiMethodUrl();
		    String paramName=request.getAccessTokenParamName();
		    if(paramName!=null&&!paramName.equals(WxConstanst.ACCESS_TOKEN_NAMES.NO_ACCESS_TOKEN)){
		    	if(WxConstanst.ACCESS_TOKEN_NAMES.THIRD_ACCESS_TOKEN.equals(paramName)){
		    		this.accessTokenValue=WxAccountPoolManager.produceThirdAccessToken();
		    	}else{
		    		if(WxConstanst.IS_THIRD_PLATFORM){
		    			this.accessTokenValue=WxAccountPoolManager.produceAuthorizerAccessTokenByAuthCode(appId);
		    		}else{
		    			this.accessTokenValue=WxAccountPoolManager.produceAccessToken(appId);
		    		}
		    	}
		    	requestUrl=requestUrl+"?"+paramName+"="+this.accessTokenValue;
		    }
			String processWay=request.getRequestProcessWay();
			if(WxConstanst.REQUEST_PROCESS_WAY.DOWNLOAD.toString().equals(processWay)){
		    	InputStream is= downloadFile();
		    	WxDownloadTempMaterialResponse rsp=new WxDownloadTempMaterialResponse();
		    	rsp.setInputStream(is);
		    	return (T) rsp;
		    }
			json = doPost(request);
			tRsp = JSON.parseObject(json,request.getResponseClass());
		}catch(Exception e){
			e.printStackTrace();
			tRsp.setErrcode("errorJson");
			tRsp.setErrmsg(json);
		}
		return (T) tRsp;
	}
	
	private <T extends WxResponse> String doPost(WxRequest<T> request) throws Exception{
	    String jsonData ="";
	    String requestType = request.getApiMethodRequestType();
	    String processWay=request.getRequestProcessWay();
	    
	    logger.debug("weixinSDK requestURL="+requestType+"："+requestUrl);
	    if(WxConstanst.REQUEST_PROCESS_WAY.DEFAULT.toString().equals(processWay)){
	    	if(requestType==null||requestType.equals(WxConstanst.REQUEST_METHOD.POST)){
	    		if(request!=null){
	    			jsonData = genJsonStr(request);
	    		}
	    		return _doPost(jsonData);
	    	}else {
	    		Map<String,String> textParams = request.getTextParams();
	    		if(textParams!=null){
	    			for(Map.Entry<String, String> entry: textParams.entrySet()) {
	    				jsonData += "&"+entry.getKey()+"="+entry.getValue();
	    			} 
	    		}
	    		logger.debug("weixinSDK get request params = "+jsonData);
	    		return _doGet("?r=sip"+jsonData);
	    	}
	    }else if(WxConstanst.REQUEST_PROCESS_WAY.UPLOAD.toString().equals(processWay)){
	    	WxUploadTempMaterialRequest uploadMaterial=(WxUploadTempMaterialRequest) request;
	    	requestUrl=requestUrl+"&type="+uploadMaterial.getType();
	    	return uploadFile(uploadMaterial.getFile());
	    }
	    return null;
	}
	
	
	/**
	 * HttpClient请求服务器
	 * @param serverUrl
	 * @param request
	 * @return
	 */
	private String _doPost(String jsonData)  throws Exception {
		CloseableHttpClient client=null;
		HttpEntity httpEntity = null;
		try {
			SSLContextBuilder builder = new SSLContextBuilder();
		    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		    // HttpClients.custom().setSSLSocketFactory(sslsf).build();
		    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
		            .<ConnectionSocketFactory> create().register(protocol, sslsf)
		            .build();
		    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
		            socketFactoryRegistry);
		    client = HttpClients.custom().setConnectionManager(cm).build();
			HttpPost post = new HttpPost(requestUrl);
			//post.addHeader(HTTP.CONTENT_TYPE, contengType);
			post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
			StringEntity entity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
			post.setEntity(entity);
			HttpResponse res = client.execute(post);
			String responseString = null;
			if (HttpStatus.SC_OK == res.getStatusLine().getStatusCode()) {
				httpEntity = res.getEntity();
				if (httpEntity != null) {
					responseString = EntityUtils.toString(httpEntity,"UTF-8"); // 返回服务器响应的HTML代码
				}
			}
			return responseString;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return null;
	}
	
	/**
	 * HttpClient请求服务器
	 * @param serverUrl
	 * @param request
	 * @return
	 */
	private String _doGet(String jsonData)  throws Exception {
		CloseableHttpClient client=HttpClients.createDefault();
		HttpEntity httpEntity = null;
		try {
			HttpGet get = new HttpGet(requestUrl+jsonData);
			get.setConfig(requestConfig);
			CloseableHttpResponse res = client.execute(get);
			if (HttpStatus.SC_OK == res.getStatusLine().getStatusCode()) {
				//res.getParams().setParameter(HTTP.CONTENT_ENCODING, "UTF-8");
				httpEntity = res.getEntity();
				if (httpEntity != null) {
					return EntityUtils.toString(httpEntity,"UTF-8"); // 返回服务器响应的HTML代码
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return null;
	}
	
	/**
	 * 上传多媒体文件到微信服务器
	 * */
	public String uploadFile(File file)throws Exception {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		try {
			HttpEntity httpEntity = null;
			FileBody fileBody = new FileBody(file);
			MultipartEntityBuilder meb = MultipartEntityBuilder.create();
			meb.addPart("file", fileBody);
			HttpEntity reqEntity=meb.build();
			
			HttpPost httppost = new HttpPost(requestUrl);
			httppost.setEntity(reqEntity);
			httppost.setConfig(requestConfig);
			CloseableHttpResponse response;
			String responseString = null;
			response = httpclient.execute(httppost);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				httpEntity = response.getEntity();
				if (httpEntity != null) {
					responseString = EntityUtils.toString(httpEntity,"UTF-8"); // 返回服务器响应的HTML代码
				}
			}
			return responseString;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
		return null;
	}

	/**
	 * 下载文件
	 * */
	public InputStream downloadFile()throws Exception {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		try {
			HttpGet get = new HttpGet(requestUrl);
			get.setConfig(requestConfig);
			CloseableHttpResponse res = httpclient.execute(get);
			if(res.getEntity()!=null){
				return res.getEntity().getContent();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			httpclient.close();
		}
		return null;
	}
	
	/**
	 * 对象转换成json字符串
	 * */
    private static String genJsonStr(Object object) {
    	JSONSerializer serializer = new JSONSerializer();
		serializer.exclude("*.class", "accessTokenParamName","requestProcessWay","responseClass","apiFuncInfoId"
    			,"apiMethodRequestType","apiMethodUrl","textParams")
				.transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"), Date.class);
		String json=serializer.deepSerialize(object);
		//String json = JSON.toJSONString(object,  filter);
		return json;
	}

	public void setNeedCheckRequest(boolean needCheckRequest) {
		this.needCheckRequest = needCheckRequest;
	}
	
}