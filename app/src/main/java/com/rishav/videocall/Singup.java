package com.rishav.videocall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Singup extends AppCompatActivity {

    FirebaseAuth auth;
    EditText emailBox,passwordBox,nameBox;
    Button loginButton,singupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        auth=FirebaseAuth.getInstance();

        emailBox=findViewById(R.id.Emailtxt);
        passwordBox=findViewById(R.id.Passwordtxt);
        nameBox=findViewById(R.id.Nameedtxt);
        loginButton=findViewById(R.id.Loginbtn);
        singupButton=findViewById(R.id.CrtAcnt);

        singupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass,name;
                email=emailBox.getText().toString();
                pass=passwordBox.getText().toString();
                name=nameBox.getText().toString();

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                        }else {
                            Toast.makeText(Singup.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}