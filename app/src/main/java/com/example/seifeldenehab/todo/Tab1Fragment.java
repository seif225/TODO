package com.example.seifeldenehab.todo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {

    RecyclerView rvxml;
    @Nullable
        @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        rvxml = (RecyclerView) view.findViewById(R.id.rv1);
        ArrayList<Model> list =new ArrayList<>() ;
        list.add(new Model("Seif","Seif@gmail.com",50, R.drawable.download));
        RV rvjava = new RV(list);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rvxml.setHasFixedSize(true);
        rvxml.setLayoutManager(manager);
        rvxml.setAdapter(rvjava);

        return view;
    }
}
