package com.example.seifeldenehab.todo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChatFragment extends Fragment {
EditText et;
Button send;
Editable message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.chat,container,false);
et=view.findViewById(R.id.edit_text);
send=view.findViewById(R.id.send);
message=et.getText();
send.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(view.getContext(),message,Toast.LENGTH_LONG).show();
    }
});

        return view;
    }
}

