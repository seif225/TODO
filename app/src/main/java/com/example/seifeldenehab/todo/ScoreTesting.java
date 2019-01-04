package com.example.seifeldenehab.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ScoreTesting extends AppCompatActivity {
    int score=0;
    Spinner spinner;
    Button add;
    TextView scoreTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_testing);
         spinner = (Spinner) findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        add=findViewById(R.id.add);

        spinner.setAdapter(adapter);
        final Intent i = new Intent();
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

               i.putExtra("score" , score);}


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
                score = getIntent().getIntExtra("score",0);
        scoreTv=findViewById(R.id.score_tv);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTv.setText(""+score);
            }
        });


    }
    }

