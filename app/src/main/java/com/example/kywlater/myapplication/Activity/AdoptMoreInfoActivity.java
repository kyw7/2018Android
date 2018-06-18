package com.example.kywlater.myapplication.Activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.kywlater.myapplication.R;
import com.example.kywlater.myapplication.entity.animal;
import com.example.kywlater.myapplication.tools.AnimalHelper;

public class AdoptMoreInfoActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView animalImageView = (ImageView) findViewById(R.id.animalImageView);
        TextView animalDetail = (TextView) findViewById(R.id.animal_detail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        final animal thisAnimal =(animal) getIntent().getSerializableExtra("animal");
        animalDetail.setText(thisAnimal.getDetail());
        floatingActionButton = findViewById(R.id.floatingActionBar);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = AnimalHelper.adopt(LoginActivity.me.getName(),thisAnimal.getId());
                if (res.equals("success")){
                    Snackbar.make(v,"谢谢你收养了这只小动物",Snackbar.LENGTH_SHORT)
                            .show();
                }
                else {
                    Snackbar.make(v,"对不起，发生了错误",Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
        Glide.with(this).load(thisAnimal.getImageId()).into(animalImageView);
        collapsingToolbar.setTitle(thisAnimal.getAnimal_type());
        animalDetail.setText(thisAnimal.getDetail());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.home:
                finish();
                return  true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
