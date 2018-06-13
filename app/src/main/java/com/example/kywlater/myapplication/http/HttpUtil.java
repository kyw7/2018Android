package com.example.kywlater.myapplication.http;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class HttpUtil {
    public static void sendOkHttpRequest( final String address, final okhttp3.Callback callback){
        Log.d("data", "发送请求");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
