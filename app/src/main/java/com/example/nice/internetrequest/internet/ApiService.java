package com.example.nice.internetrequest.internet;

import com.example.nice.internetrequest.Weather;



import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by xingge on 2017/5/16.
 */

public interface ApiService {
	@GET("101010100.html")
	Observable<Weather> getWeather();
}
