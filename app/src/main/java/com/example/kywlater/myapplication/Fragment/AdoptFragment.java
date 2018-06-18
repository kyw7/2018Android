package com.example.kywlater.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kywlater.myapplication.R;
import com.example.kywlater.myapplication.Adapter.AnimalAdapter;
import com.example.kywlater.myapplication.entity.animal;
import com.example.kywlater.myapplication.tools.AnimalHelper;

import java.util.ArrayList;
import java.util.List;


public class AdoptFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<animal> animalsList = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager layoutManager;
    AnimalAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopt_fragment, container, false);
        swipeRefreshLayout = view.findViewById(R.id.reflash);
        swipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AnimalHelper.initForAll(animalsList);
        RecyclerView mRecyclerView = view.findViewById(R.id.adoptinfo);
        layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        Log.d("haha", "onViewCreated: "+animalsList.size());
        adapter = new AnimalAdapter(animalsList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getContext(), "Refresh Finished!", Toast.LENGTH_SHORT).show();
        Log.d("haha", "onRefresh: "+animalsList.size());
        adapter.notifyDataSetChanged();
        //添加代码
        swipeRefreshLayout.setRefreshing(false);
    }

}