package com.example.kywlater.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class about_us extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        findViewById(R.id.about_us1).setOnClickListener(this);
        findViewById(R.id.about_us2).setOnClickListener(this);
        findViewById(R.id.about_us3).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String myurl=new String();
        switch (view.getId()){
            case R.id.about_us1:
                myurl="https://dic.pixiv.net/a/%E6%98%A5%E6%97%A5%E9%87%8E%E7%A9%B9";
                Intent intent=new Intent(about_us.this,contact_us.class);
                intent.putExtra("url",myurl);
                startActivity(intent);
                break;
            case R.id.about_us2:
                myurl="https://www.pixiv.net/";
                Intent intent2=new Intent(about_us.this,contact_us.class);
                intent2.putExtra("url",myurl);
                startActivity(intent2);
                break;
            case R.id.about_us3:
                myurl="https://github.com/kyw7";
                Intent intent3=new Intent(about_us.this,contact_us.class);
                intent3.putExtra("url",myurl);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
