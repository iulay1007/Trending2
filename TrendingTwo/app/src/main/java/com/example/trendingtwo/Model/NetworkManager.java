package com.example.trendingtwo.Model;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static NetworkManager mInstance;
        private static Retrofit retrofit;
        private static volatile Request request = null;

        public static NetworkManager getInstance() {
            if (mInstance == null) {
                synchronized (NetworkManager.class) {
                    if (mInstance == null) {
                        mInstance = new NetworkManager();
                    }
                }
            }
            return mInstance;
        }


        public void init() {
            // 初始化okhttp
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            // 初始化Retrofit
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl("https://github-trending-api.now.sh/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        public static Request getRequest() {
            if (request == null) {
                synchronized (Request.class) {
                    request = retrofit.create(Request.class);
                }
            }
            return request;
        }
}