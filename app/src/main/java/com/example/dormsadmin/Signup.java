package com.example.dormsadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText musername,memail,mphoneNo,mpassword;
    Button mgo_reg,malready;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        musername = findViewById(R.id.username);
        memail = findViewById(R.id.email);
        mphoneNo = findViewById(R.id.phoneNo);
        mpassword = findViewById(R.id.password);
        mgo_reg = findViewById(R.id.go_reg);
        malready = findViewById(R.id.already);

        fAuth = FirebaseAuth.getInstance();

        mgo_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    memail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpassword.setError("Password is Required");
                    return;
                }
                if (password.length()< 6){
                    mpassword.setError("Password Must be >=6 Character");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Signup.this,"User Created", Toast.LENGTH_SHORT).show();
                            SharedPreferences.Editor editor = getSharedPreferences("PREF_DORMS",MODE_PRIVATE).edit();
                            editor.putBoolean("IS_LOGIN",true);
                            editor.commit();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }else {
                            Toast.makeText(Signup.this,"Error ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }


        });
    }
}