package com.example.trendingtwo.Model;

import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    Retrofit mRetrofit=new Retrofit.Builder().baseUrl("https://github-trending-api.now.sh/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    RetrofitService mRetrofitService=mRetrofit.create(RetrofitService.class);
    Call<DataBean> call=mRetrofitService.getBean();




}
