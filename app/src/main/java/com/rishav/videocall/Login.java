package com.rishav.videocall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailBox,passwordBox;
    Button loginButton,singupButton;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();

        emailBox=findViewById(R.id.Emailtxt);
        passwordBox=findViewById(R.id.Passwordtxt);
        loginButton=findViewById(R.id.Loginbtn);
        singupButton=findViewById(R.id.CrtAcnt);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email=emailBox.getText().toString();
                password=passwordBox.getText().toString();
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"Logged In",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Login.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        singupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Singup.class));
            }
        });
    }
}