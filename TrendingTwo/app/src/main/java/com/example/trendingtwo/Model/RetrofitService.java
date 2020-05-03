package com.example.trendingtwo.Model;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("repositories")
    Call <DataBean> getBean();
}
