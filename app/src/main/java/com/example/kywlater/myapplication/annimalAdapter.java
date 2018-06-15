package com.example.kywlater.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 16911 on 2018/06/15.
 */

public class annimalAdapter extends RecyclerView.Adapter {
    private List<animal> animalA;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView animalImage;
        TextView textView_typesomatype;
        TextView textView_singleage;
        TextView textView_detail;
        View animalview;
        public ViewHolder(View view){
            super(view);
            animalview=view;
            animalImage=view.findViewById(R.id.animal_adopt);
            textView_typesomatype=view.findViewById(R.id.type_somatype);
            textView_singleage=view.findViewById(R.id.singleage);
            textView_detail=view.findViewById(R.id.detail);
        }
    }
    public annimalAdapter(List<animal> animalList){
        animalA=animalList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singleanimal,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.animalview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                animal Aanimal=animalA.get(position);
                Toast.makeText(view.getContext(),String.valueOf(Aanimal.getAnimal_age()),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder1((ViewHolder) holder, position);
    }


    public void onBindViewHolder1(ViewHolder holder, int position) {
        animal ani=animalA.get(position);
        holder.animalImage.setImageResource(ani.getImageid());
        holder.textView_detail.setText(ani.getDetail());
        holder.textView_singleage.setText( String.valueOf(ani.getAnimal_age()));
        holder.textView_typesomatype.setText(ani.getAnimal_type());

    }

    @Override
    public int getItemCount() {
        return animalA.size();
    }
}
