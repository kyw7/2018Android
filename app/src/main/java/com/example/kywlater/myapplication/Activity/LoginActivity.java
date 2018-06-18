package com.example.kywlater.myapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kywlater.application.MainActivity;
import com.example.kywlater.myapplication.R;
import com.example.kywlater.myapplication.entity.Person;
import com.example.kywlater.myapplication.http.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static Person me = new Person();
    private final String TAG = "MainActivity";
    private EditText account;
    private com.example.kywlater.myapplication.passwordEditText passwordEditText;
    //private ImageView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = findViewById(R.id.account);
        passwordEditText = findViewById(R.id.password);
        account.setText("kyw7");
        passwordEditText.setText("123");
        findViewById(R.id.submmit).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
        //test = findViewById(R.id.login_icon);
       // Glide.with(this).load("http://118.25.8.154/tp5/public/uploads/animalHead/3.jpg").into(test);
        //Toast.makeText(LoginActivity.this,"用户名或者密码错误，请重试",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.submmit:
                //http请求实例
                String url = "http://118.25.8.154/tp5/public/index/person/login/"
                        + account.getText().toString() +"/"+ passwordEditText.getText().toString();
                final Context context = getApplicationContext();
                HttpUtil.sendOkHttpRequest(url, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        Log.d("data", "收到的数据打出来");
                        Log.d("data", responseData);
                        if (responseData.equals("success")){
                            me.setName(account.getText().toString());
                            Intent intent = new Intent(LoginActivity.this, MainTestActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Snackbar.make(view,"用户名或者密码错误，请重试",Snackbar.LENGTH_SHORT)
                                    .show();
                        }
                        //parseJSONWithGSON(responseData);
                        //Gson gson = new Gson();
                        //Person person = gson.fromJson(responseData,Person.class);
                        //Log.d("data", person.getName());
                    }
                });

                break;
            case R.id.register:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
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
        List<Person> appList = gson.fromJson(jsonData, new TypeToken<List<Person>>() {
        }.getType());
        for (Person person : appList) {
            Log.d("data", "id is " + person.getId());
            Log.d("data", "name is " + person.getName());
        }
    }
}
