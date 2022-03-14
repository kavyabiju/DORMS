package com.example.dormsadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_dorms extends AppCompatActivity {
    EditText mu_name,mpasswd;
    Button mlogin,mf_password,msignup;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_dorms);
        mu_name = findViewById(R.id.u_name);
        mpasswd = findViewById(R.id.passwd);
        mlogin=findViewById(R.id.login);
        mf_password=findViewById(R.id.f_passwd);
        msignup=findViewById(R.id.signup);

        fAuth = FirebaseAuth.getInstance();

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mu_name.getText().toString().trim();
                String password = mpasswd.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mu_name.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpasswd.setError("Password is Required");
                    return;
                }
                if (password.length()< 6){
                    mpasswd.setError("Password Must be >=6 Character");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            SharedPreferences.Editor editor = getSharedPreferences("PREF_DORMS",MODE_PRIVATE).edit();
                            editor.putBoolean("IS_LOGIN",true);
                            editor.commit();
                            Toast.makeText(Login_dorms.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }else {
                            Toast.makeText(Login_dorms.this,"Error ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_dorms.this,Signup.class));
            }
        });
        mf_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_dorms.this,forgot_password.class);
                startActivity(intent);
            }
        });


    }

}