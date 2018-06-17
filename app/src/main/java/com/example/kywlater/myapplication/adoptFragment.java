package com.example.kywlater.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class adoptFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<animal> animals=new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    android.support.v7.widget.RecyclerView recyclerView;
   // RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private int step=12;
    private int all=12;
    private annimalAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.adopt_fragment,container,false);
        swipeRefreshLayout=view.findViewById(R.id.reflash);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView=view.findViewById(R.id.adoptinfo);


        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.adoptinfo);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new annimalAdapter(animals);
        recyclerView.setAdapter(adapter);


//        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if(newState==RecyclerView.SCROLL_STATE_IDLE&&all==adapter.getItemCount()){
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            List<animal> newDatas = new ArrayList<>();
//                            for (int i = 0; i< 5; i++) {
//                                animal sanimal=new animal(12,"large","husky",R.drawable.can,"fdas");
//                                newDatas.add(sanimal);
//
//                            }
//                            animals.addAll(newDatas);
//
//                        }
//                    },1000);
//                }
//            }
//        });

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
//        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.adoptinfo);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
//        annimalAdapter adapter=new annimalAdapter(animals);
//        recyclerView.setAdapter(adapter);
        makeRecycle();
    }
    public void makeRecycle(){
        View view=getView();
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.adoptinfo);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new annimalAdapter(animals);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getContext(), "Refresh Finished!", Toast.LENGTH_SHORT).show();
        //添加代码
        swipeRefreshLayout.setRefreshing(false);
    }
}
