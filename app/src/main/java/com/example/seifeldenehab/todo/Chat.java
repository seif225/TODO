package com.example.seifeldenehab.todo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference userDatabaseReference;
    Button sendMsg;
    EditText msg;
    ChildEventListener mChildEventListener;

    String message,user_name,user_email;
    ArrayList<MessageModel>messageList;


    ArrayList<Users>usersList;


    ChatAdapter chatAdapter;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    Users user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent i=getIntent();
        user_email=i.getStringExtra("user_email");
        Log.e("Chat","User email= "+user_email);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Chat");
        //userDatabaseReference=firebaseDatabase.getReference().child("Users").orderByChild("email").equals(user_email+"");
        msg=findViewById(R.id.msg);
        sendMsg=findViewById(R.id.send);
        messageList=new ArrayList<>();
        layoutManager=new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.message_container);
        setAdapter();
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message=msg.getText().toString();
                getUserName();
                if(user_name!=null)
                    user_name=user.getUser_name();
                else
                    user_name="UnKnown";
                databaseReference.push().setValue(new MessageModel(user_name+"",message+""));
                msg.setText("");
            }
        });

        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    messageList.add(dataSnapshot.getValue(MessageModel.class));
                    Log.e("Chat","message is adderd");

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("OnCancelled","DatabaseError");
            }
        };
        databaseReference.addChildEventListener(mChildEventListener);


    }

    public void setAdapter(){
        chatAdapter=new ChatAdapter(messageList);
        recyclerView.setAdapter(chatAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void getUserName(){

        Log.e("Chat","Error Before do method");
        //firebaseDatabase.getReference().child("Users").child(user_email);
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI

                user=dataSnapshot.getValue(Users.class);
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("Chat", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        userDatabaseReference.addValueEventListener(postListener);
    }
}
