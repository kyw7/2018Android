package com.example.kywlater.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainViewActivity extends AppCompatActivity implements View.OnClickListener {
    private int button_count=0;
    private List<animal> animals=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        fragmentinit();
        findViewById(R.id.adopt_button).setOnClickListener(this);
        findViewById(R.id.info_button).setOnClickListener(this);
        findViewById(R.id.mypets_button).setOnClickListener(this);
       // findViewById(R.id.contact_us).setOnClickListener(this);


    }

    public void init(){
        int i=0;
        for(;i<12;i=i+1){
            animal sanimal=new animal(12,"large","husky",R.drawable.doge,"fdas");
            animals.add(sanimal);
        }

    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.info_button:
                if(button_count==1){

                }else{
                    replaceTopFragment(new head_info_fragment());
                    replaceMiddFragment(new infoFragment());
                    pressdButton(1);
                    button_count=1;

                }
                break;
            case R.id.adopt_button:
                if(button_count==0){

                }else {
                    replaceTopFragment(new head_adopt_harder_fragment());
                    replaceMiddFragment(new adoptFragment());
                    pressdButton(0);
                    button_count=0;
                }

                break;
            case R.id.mypets_button:
                if(button_count==-1){

                }else{
                    replaceTopFragment(new headmypets_fragment());
                    replaceMiddFragment(new mypetsFragment());
                    pressdButton(-1);
                    button_count=-1;
                }

                break;
            case R.id.contact_us:
                Intent intent=new Intent(MainViewActivity.this,contact_us.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    private void replaceTopFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayouttop,fragment);
        transaction.commit();
    }
    private void replaceMiddFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragelayout2,fragment);
        transaction.commit();
    }
    private void pressdButton(int i){
        Button info=findViewById(R.id.info_button);
        Button mype=findViewById(R.id.mypets_button);
        Button adopt=findViewById(R.id.adopt_button);
        info.setTextColor(Color.rgb(130,254, 142));
        mype.setTextColor(Color.rgb(130,254,142));
        adopt.setTextColor(Color.rgb(130,254,142));
        switch(i){
            case -1:
                mype.setTextColor(Color.rgb(243,93,93));

                break;
            case 0:

                adopt.setTextColor(Color.rgb(243,93,93));
                break;
            case 1:
                info.setTextColor(Color.rgb(243,93,93));
                break;
            default:
                break;
        }
    }
    private void fragmentinit(){
        replaceTopFragment(new head_adopt_harder_fragment());
        replaceMiddFragment(new adoptFragment());
    }
}
