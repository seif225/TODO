package com.example.seifeldenehab.todo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AddScore extends Fragment {
int score;
TextView scoreTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_score,container,false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.numbers, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        score=2;
                        break;
                    case 1:
                        score=5;

                        break;
                    case 2:
                        score=6;

                        break;
                    case 3:
                        score=7;

                        break;
                    case 4:
                        score=8;

                        break;
                    case 5:
                        score=9;

                        break;
                    case 6:
                        score=10;

                        break;
                    case 7:
                        score=15;

                        break;
                            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        scoreTv=view.findViewById(R.id.score_tv);
        scoreTv.setText(toString().valueOf(score));
        return view;
    }
}
