package com.example.seifeldenehab.todo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private EditText eEmail,ePassword,eName;
    private Button signUp;
    private Button signIn;//test delete
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    String email,pass,userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // connect Edit text and buttom with xml
        eEmail=findViewById(R.id.uEmail);
        ePassword=findViewById(R.id.uPass);
        eName=findViewById(R.id.uName);
        signUp=findViewById(R.id.signUup);
        signIn=findViewById(R.id.signin);// test delete
        //initialize the instance
        mAuth=FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=eEmail.getText().toString();
                pass=ePassword.getText().toString();
                userName=eName.getText().toString();
                createNewUser();
            }
        });
        //Database
            firebaseDatabase=FirebaseDatabase.getInstance();
            databaseReference=firebaseDatabase.getReference().child("Users");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i= new Intent(SignUp.this,LogIn.class);
               startActivity(i);
            }
        });



    }
    private void createNewUser(){
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser currentUser=mAuth.getCurrentUser();
                    Log.e("SignUp","Task Success");
                    databaseReference.push().setValue(new Users(userName,email,pass));
                    Intent i=new Intent(SignUp.this,MainActivity.class);
                    startActivity(i);
                   // updateUI(currentUser);
                }

            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    Log.e("Invalid password","password");
                } else if (e instanceof FirebaseAuthInvalidUserException) {
                    Log.e("email","Incorrect email address");
                } else {
                    Log.e("elsee",""+e.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
}
