package com.example.kywlater.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.loginButton).setOnClickListener(this);
        FragmentManager fragmentManager =  getSupportFragmentManager();
        fragmentManager.beginTransaction().add(new adoptFragment(), null).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                Toast.makeText(MainActivity.this, "点击Button2", Toast.LENGTH_SHORT).show();
                ToAdopt(new adoptFragment());
                break;
                default: break;
        }
    }

    public void ToAdopt(Fragment fragment){
        FragmentManager fragmentManager =  getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.loginLayout, fragment).commit();
    }
}
