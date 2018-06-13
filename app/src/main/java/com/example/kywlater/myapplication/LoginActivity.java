package com.example.kywlater.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.kywlater.myapplication.entity.Person;
import com.example.kywlater.myapplication.http.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.submmit).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
        //一个调用网络接口请求数据的例子
        /*HttpUtil.sendOkHttpRequest("http://118.25.8.154/index.php",new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Log.d("data", responseData);
                Log.d("data", "对吗？");
                Gson gson = new Gson();
                Person person = gson.fromJson(responseData,Person.class);
                Log.d("data", person.getName());
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submmit:
                //http请求实例
                HttpUtil.sendOkHttpRequest("http://118.25.8.154/index.php",new okhttp3.Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }


                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        Log.d("data", responseData);
                        //Log.d("data", "对吗？");
                        parseJSONWithGSON(responseData);
                        //Gson gson = new Gson();
                        //Person person = gson.fromJson(responseData,Person.class);
                        //Log.d("data", person.getName());
                    }
                });
                  Intent intent=new Intent(LoginActivity.this,MainViewActivity.class);
                  startActivity(intent);

            break;
            case R.id.register:
                Intent intent2=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent2);
            break;
            default: break;
        }
    }

    // 在这里进行UI操作，将结果显示到界面上
    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
    //用于处理json数组的列子
    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<Person> appList = gson.fromJson(jsonData, new TypeToken<List<Person>>() {}.getType());
        for (Person person : appList) {
            Log.d("data", "id is " + person.getId());
            Log.d("data", "name is " + person.getName());
        }
    }
}
