package com.awaken.imagine.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
	public static final String CONTENT_TYPE_JSON = "application/json";
	public static final String ENCODE_DEFAUL = "UTF-8";

	public static String doPost(String url, Map<String, String> formData, LinkedHashMap<String, String> headers, String contentType) {
		return doPost(url, formData, null, ENCODE_DEFAUL, headers, contentType);
	}

	public static String doPost(String url, String jsonString, LinkedHashMap<String, String> headers, String contentType) {
		return doPost(url, null, jsonString, ENCODE_DEFAUL, headers, contentType);
	}

	public static String doPost(String url, String jsonString, LinkedHashMap<String, String> headers) {
		return doPost(url, null, jsonString, ENCODE_DEFAUL, headers, CONTENT_TYPE_JSON);
	}
	
	public static String doGet(String url, Map<String, String> headers, Map<String, String> querys) {
    	return doGet(url, ENCODE_DEFAUL, headers, querys);
    }
	
    public static String doPost(String url, String jsonString, String charset, LinkedHashMap<String, String> headers) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置编码格式防止出现中文乱码
            StringEntity stringEntity = new StringEntity(jsonString, Charset.forName(ENCODE_DEFAUL));
            //给HttpPost 设置请求头
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpPost.setHeader(key, headers.get(key));
                }
            }
            stringEntity.setContentType(CONTENT_TYPE_JSON);
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            result = EntityUtils.toString(resEntity, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String doPost(String url, Map<String, String> formData, String jsonString, String charset, LinkedHashMap<String, String> headers, String contentType) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            if (formData != null && formData.size() > 0) {
				List<NameValuePair> params = new ArrayList<NameValuePair>(formData.size());
				for (Map.Entry<String, String> parameter : formData.entrySet()) {
					params.add(new BasicNameValuePair(parameter.getKey(), parameter.getValue()));
				}
				httpPost.setEntity(new UrlEncodedFormEntity(params, charset));
            }

            //设置编码格式防止出现中文乱码
            if (jsonString != null && !"".equals(jsonString.trim())) {
            	StringEntity stringEntity = new StringEntity(jsonString, Charset.forName(charset));
            	stringEntity.setContentType(contentType);
                httpPost.setEntity(stringEntity);
            }
            //给HttpPost 设置请求头
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpPost.setHeader(key, headers.get(key));
                }
            }
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            result = EntityUtils.toString(resEntity, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String doGet(String url, String charset, LinkedHashMap<String, String> headers) {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            //设置请求头
            //给HttpPost 设置请求头
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpGet.setHeader(key, headers.get(key));
                }
            }
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity resEntity = response.getEntity();
            result = EntityUtils.toString(resEntity, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
	public static String doGet(String url, String charset, Map<String, String> headers, Map<String, String> querys) {
		
		String result = null;
		try {
			HttpClient httpClient = wrapClient(url);
	    	HttpGet request = new HttpGet(buildUrl(url, querys));
	        for (Map.Entry<String, String> e : headers.entrySet()) {
	        	request.addHeader(e.getKey(), e.getValue());
	        }
	        HttpResponse httpResponse = httpClient.execute(request);
	        HttpEntity resEntity = httpResponse.getEntity();
            result = EntityUtils.toString(resEntity, charset);
		} catch (Exception e) {
			logger.error("error - http请求异常", e);
		}
        return result;
    }
	
	private static void sslClient(HttpClient httpClient) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                	
                }
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                	
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = httpClient.getConnectionManager();
            SchemeRegistry registry = ccm.getSchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
        	throw new RuntimeException(ex);
        }
    }
    
	private static HttpClient wrapClient(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		if (url.startsWith("https://")) {
			sslClient(httpClient);
		}
		
		return httpClient;
	}
	
    private static String buildUrl(String url, Map<String, String> querys) throws UnsupportedEncodingException {
    	StringBuilder sbUrl = new StringBuilder(url);
    	if (null != querys) {
    		StringBuilder sbQuery = new StringBuilder();
        	for (Map.Entry<String, String> query : querys.entrySet()) {
        		if (0 < sbQuery.length()) {
        			sbQuery.append("&");
        		}
        		if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
        			sbQuery.append(query.getValue());
                }
        		if (!StringUtils.isBlank(query.getKey())) {
        			sbQuery.append(query.getKey());
        			if (!StringUtils.isBlank(query.getValue())) {
        				sbQuery.append("=");
        				sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
        			}        			
                }
        	}
        	if (0 < sbQuery.length()) {
        		sbUrl.append("?").append(sbQuery);
        	}
        }
    	
    	return sbUrl.toString();
    }
    
}
