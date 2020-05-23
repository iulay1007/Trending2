package com.example.trendingtwo.Model;



import java.util.List;

import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("repositories")
    Observable <List<JsonBean>> getBean();
}
