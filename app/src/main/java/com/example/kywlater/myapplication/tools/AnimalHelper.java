package com.example.kywlater.myapplication.tools;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.kywlater.myapplication.Activity.LoginActivity;
import com.example.kywlater.myapplication.Adapter.AnimalAdapter;
import com.example.kywlater.myapplication.entity.adopt;
import com.example.kywlater.myapplication.entity.animal;
import com.example.kywlater.myapplication.http.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.logger.AndroidLogAdapter;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class AnimalHelper {
    private static AnimalAdapter adapter;
    public static String result;
    private static FragmentActivity activity;

    public static void initForAll(final List<animal> animalsList) {
        animalsList.clear();
        String url = "http://118.25.8.154/tp5/public/index/animal/getall";
        HttpUtil.sendOkHttpRequest(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.d("data", res);
                com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());//更加强大的log工具
                com.orhanobut.logger.Logger.d(res);
                //换这个方式
                //Json的解析类对象
                //将JSON的String 转成一个JsonArray对象
                JsonParser jsonParser = new JsonParser();
                JsonArray jsonArray = jsonParser.parse(res).getAsJsonArray();
                Gson gson = new Gson();
                // animal animals = gson.fromJson(res,animal.class);
                // List<animal> ani = gson.fromJson(res, new TypeToken<List<animal>>() {}.getType());
                // animalsList.addAll(ani);
                for (JsonElement ani : jsonArray) {
                    animal animalBean = gson.fromJson(ani, animal.class);
                    // Log.d("data", animalBean.getimageid());
                    animalsList.add(animalBean);
                }
                if (adapter != null && activity != null) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }
    public static void initForMyAnimals(final List<animal> animalsList) {
        animalsList.clear();
        String url = "http://118.25.8.154/tp5/public/index/animal/getmy/"+ LoginActivity.me.getName();
        HttpUtil.sendOkHttpRequest(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.d("data", res);
                com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());//更加强大的log工具
                com.orhanobut.logger.Logger.d(res);
                //换这个方式
                //Json的解析类对象
                //将JSON的String 转成一个JsonArray对象
                JsonParser jsonParser = new JsonParser();
                JsonArray jsonArray = jsonParser.parse(res).getAsJsonArray();
                Gson gson = new Gson();
                // animal animals = gson.fromJson(res,animal.class);
                // List<animal> ani = gson.fromJson(res, new TypeToken<List<animal>>() {}.getType());
                // animalsList.addAll(ani);
                for (JsonElement ani : jsonArray) {
                    animal animalBean = gson.fromJson(ani, animal.class);
                    // Log.d("data", animalBean.getimageid());
                    animalsList.add(animalBean);
                }
                if (adapter != null && activity != null) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }
    public static String adopt(String personName,int animalId) {
        String url = "http://118.25.8.154/tp5/public/index/animal/adopt/"+personName+"/"+animalId;

        HttpUtil.sendOkHttpRequest(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.d("data", res);
                result =res;
            }
        });
        return result;
    }

    public static void setAdapter(AnimalAdapter adapter) {
        AnimalHelper.adapter = adapter;
    }

    public static void setActivity(FragmentActivity activity) {
        AnimalHelper.activity = activity;
    }
}
