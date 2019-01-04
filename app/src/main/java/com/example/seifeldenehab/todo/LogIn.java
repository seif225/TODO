package com.example.seifeldenehab.todo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    EditText iEmail,iPass;
    String sEmail,sPass;
    Button logIn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        iEmail=findViewById(R.id.iemail);
        iPass=findViewById(R.id.ipass);
        logIn=findViewById(R.id.signIn);

        mAuth=FirebaseAuth.getInstance();
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sEmail=iEmail.getText().toString();
                sPass=iPass.getText().toString();

                login();
            }
        });

    }

    private void login(){
        mAuth.signInWithEmailAndPassword(sEmail,sPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser currentUser=mAuth.getCurrentUser();
                    Log.e("Login", "Successful");
                    Intent i=new Intent(LogIn.this,MainActivity.class);
                    startActivity(i);
                    // updateUI(currentUser);
                }
                else
                    Log.e("Login","error");
            }
        });
    }


}
