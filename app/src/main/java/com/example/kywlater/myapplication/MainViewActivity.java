package com.example.kywlater.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainViewActivity extends AppCompatActivity implements View.OnClickListener {
    private int button_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        fragmentinit();
        findViewById(R.id.adopt_button).setOnClickListener(this);
        findViewById(R.id.info_button).setOnClickListener(this);
        findViewById(R.id.mypets_button).setOnClickListener(this);
//        TextView textView=findViewById(R.id.info_head_text);
//        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/purimonyorori2.ttf");
//        textView.setTypeface(typeface);

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
