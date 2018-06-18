package com.example.kywlater.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.kywlater.myapplication.Activity.AdoptMoreInfoActivity;
import com.example.kywlater.myapplication.R;
import com.example.kywlater.myapplication.entity.animal;
import java.util.List;

/**
 * Created by 16911 on 2018/06/15.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<animal> mAnimal;
    private Context mcontext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView animalImage;
        TextView textView_typesomatype;
        TextView textView_singleage;
        TextView textView_detail;
        View animalview;

        ViewHolder(View view) {
            super(view);
            animalview = view;
            animalImage = view.findViewById(R.id.animal_adopt);
            textView_typesomatype = view.findViewById(R.id.type_somatype);
            textView_singleage = view.findViewById(R.id.singleage);
            textView_detail = view.findViewById(R.id.detail);
        }
    }

    public AnimalAdapter(List<animal> animalList) {
        mAnimal = animalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.singleanimal, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.animalview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                animal aa  = mAnimal.get(position);
                //Intent intent = new Intent(mcontext,adopt_more_info.class);
                Intent intent = new Intent(mcontext,AdoptMoreInfoActivity.class);
                intent.putExtra("animal",aa);
                Snackbar.make(view,"你点击了这只狗狗",Snackbar.LENGTH_SHORT)
                        .show();
                mcontext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        animal ani = mAnimal.get(position);
        Glide.with(mcontext).load(ani.getImageId()).into(holder.animalImage);
        holder.textView_detail.setText(ani.getDetail());
        holder.textView_singleage.setText(String.valueOf(ani.getAge()));
        holder.textView_typesomatype.setText(ani.getAnimal_type());
        /*Glide.with(mcontext).load(R.drawable.doge).into(holder.animalImage);
        holder.textView_detail.setText("ss");
        holder.textView_singleage.setText(String.valueOf("ss"));
        holder.textView_typesomatype.setText("ss");*/
    }

    @Override
    public int getItemCount() {
        return mAnimal.size();
    }
}
