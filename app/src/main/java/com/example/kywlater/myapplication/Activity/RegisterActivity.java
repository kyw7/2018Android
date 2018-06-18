package com.example.kywlater.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kywlater.myapplication.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById(R.id.register_button).setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_button:
                Intent intent=new Intent(RegisterActivity.this,MainViewActivity.class);
                startActivity(intent);
                break;
            default: break;
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
