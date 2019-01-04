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

import static com.example.seifeldenehab.todo.R.drawable.ic_launcher_background;

public class Tab3Fragment extends Fragment {
    RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);
        rv =view.findViewById(R.id.rv3);
        //fake List
        ArrayList<Model> list =new ArrayList<>() ;
        list.add(new Model("ahmed","ahmed@gmail.com",50, R.drawable.download));
        RV quotesListAdapter = new RV(list);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(manager);
        rv.setAdapter(quotesListAdapter);
        return view;
    }
}
