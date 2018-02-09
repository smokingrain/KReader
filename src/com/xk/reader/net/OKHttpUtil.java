package com.xk.reader.net;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.xk.reader.utils.HttpRequestParam;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtil {

	private static OkHttpClient client;
	
	
	static{
		OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                ;
		client = builder.build();
		
	}
	
	
	public static String post(String url, List<HttpRequestParam> params) {
		FormBody.Builder builder = new FormBody.Builder();
		if(null != params) {
			for(HttpRequestParam param : params) {
				builder.addEncoded(param.key, param.value);
			}
		}
		Request request = new Request.Builder().url(url).post(builder.build()).build();
		try {
			Response response = client.newCall(request).execute();
			String result = response.body().string();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String get(String url, List<HttpRequestParam> params) {
		if(null != params) {
			StringBuffer sb = new StringBuffer();
			sb.append("?");
			for(HttpRequestParam param : params) {
				sb.append(param.key).append("=").append(param.value).append("&");
			}
			url += sb.toString();
		}
		Request request = new Request.Builder().url(url).get().build();
		try {
			Response response = client.newCall(request).execute();
			String result = response.body().string();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
