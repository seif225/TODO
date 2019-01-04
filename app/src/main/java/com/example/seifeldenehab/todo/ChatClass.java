package com.example.seifeldenehab.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChatClass extends AppCompatActivity {
    EditText et;
    Button send;
    Editable message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_class);
        et=findViewById(R.id.edit_text);
        send=findViewById(R.id.send);
        message=et.getText();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();
            }
        });

    }
}
