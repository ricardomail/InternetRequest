package com.example.nice.internetrequest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.nice.internetrequest.internet.Api;
import com.example.nice.internetrequest.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    List<SearchBean.DataBean> list = new ArrayList<>();
    LoadingDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRequest();
    }

    private void initRequest() {
//        Api.getDefault().getSearch("2","5204092642")
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        dialog = new LoadingDialog(MainActivity.this);
//                        dialog.show();
//                    }
//                })
//                .subscribe
//                .subscribeOn(Schedulers.io())
//                .map(new HttpResultFun<List<SearchBean.DataBean>>(this))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new RxSubscribeer<List<SearchBean.DataBean>>(dialog) {
//                    @Override
//                    protected void _onNext(List<SearchBean.DataBean> been) {
//                        Toast.makeText(MainActivity.this,been.size()+"",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    protected void _onError(String message) {
//
//                    }
//                });
        Api.getDefault().getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        String re = "";
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribeer<Weather>(this) {
                    @Override
                    protected void _onNext(Weather weather) {
                        Toast.makeText(MainActivity.this,weather.getWeatherinfo().getCity(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void _onError(String message) {
                        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                });

    }

//
     class HttpResultFun<T>implements Func1<HttpResult<T>, T> {
        private Context mContext;

    public HttpResultFun(Context context) {
        mContext = context;
    }

    @Override
         public T call(HttpResult<T> result) {
             if(!result.isSuccess()){
                 Toast.makeText(mContext,result.getMessage(),Toast.LENGTH_SHORT).show();
                 return null;
             }
             return  result.getData();
         }
     }


}
