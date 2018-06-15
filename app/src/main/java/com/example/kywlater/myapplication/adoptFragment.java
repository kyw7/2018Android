package com.example.kywlater.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class adoptFragment extends Fragment {
    private List<animal> animals=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.adopt_fragment,container,false);
        return view;
    }
    public void init(){
        int i=0;
        for(;i<12;i=i+1){
            animal sanimal=new animal(12,"large","husky",R.drawable.can,"fdas");
            animals.add(sanimal);
        }

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.adoptinfo);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        annimalAdapter adapter=new annimalAdapter(animals);
        recyclerView.setAdapter(adapter);

    }
}
