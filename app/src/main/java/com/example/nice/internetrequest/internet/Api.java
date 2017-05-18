package com.example.nice.internetrequest.internet;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xingge on 2017/5/16.
 */

public class Api {
	private static ApiService SERVICE;
	/**
	 * 设置请求超时时间
	 */
	private static final int DEFAULT_TIMEOUT = 10000;
	public static ApiService getDefault(){
		if(SERVICE == null){
			//手动创建一个OkHttpClient的请求头
			OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
			httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
			/**
			 * 对所有请求添加请求头
			 */
//			httpClientBuilder.addInterceptor(new Interceptor() {
//				@Override
//				public Response intercept(Chain chain) throws IOException {
//					Request request = chain.request();
//					okhttp3.Response originalResponse = chain.proceed(request);
//
//					return originalResponse.newBuilder().header("","").addHeader("","").build();
//				}
//			});
			SERVICE = new Retrofit.Builder()
					.client(httpClientBuilder.build())
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
					.baseUrl("http://www.weather.com.cn/data/sk/")//设置请求地址
					.build().create(ApiService.class);

		}
		return SERVICE;
	}
}
