package com.example.kywlater.myapplication.http;

public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
