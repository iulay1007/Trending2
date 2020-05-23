package com.example.trendingtwo.Model;

import android.util.Log;


import com.example.trendingtwo.View.RecyclerviewAdapter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkManager {
    private static NetworkManager mInstance;
        private static Retrofit retrofit;
        private static volatile Request request = null;
        private RetrofitService mRetrofitService=null;

        public static NetworkManager getInstance(RecyclerviewAdapter mAdapter) {
            if (mInstance == null) {
                synchronized (NetworkManager.class) {

                        mInstance = new NetworkManager();


                }
            }
            return mInstance;
        }

        public NetworkManager() {

            Log.d("Network","success --->");
            OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(60000, TimeUnit.MILLISECONDS)
                    .readTimeout(60000, TimeUnit.MILLISECONDS)
                    .build();
            Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl("https://github-trending-api.now.sh/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
            mRetrofitService=retrofit.create(RetrofitService.class);
            Log.d("ok","work---->");

        }

      /*  public static Request getRequest() {
            if (request == null) {
                synchronized (Request.class) {
                    request = retrofit.create(Request.class);
                }
            }
            return request;
        }*/
     // public void updateList(JsonBean result,RecyclerviewAdapter mAdapter){

     //     mAdapter.setData(result);

   //   }
      public RetrofitService getRetrofitService(){
          if(mRetrofitService==null){
              mRetrofitService=retrofit.create(RetrofitService.class);
          }
          return mRetrofitService;
      }
}