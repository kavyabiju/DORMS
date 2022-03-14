package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    CardView room_details;
    CardView food_menu;
    CardView queries;
    CardView profile;
    CardView logout;
    CardView stu_details;

    AppCompatImageButton room, fee, mess, student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        room_details = findViewById(R.id.card_room_details);
        food_menu = findViewById(R.id.food);
        queries = findViewById(R.id.queries);
        profile = findViewById(R.id.profile);
        logout = findViewById(R.id.logout);
        stu_details = findViewById(R.id.stu_details);


        room_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,view_room.class);
                startActivity(i);
            }
        });
        food_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,food_menu.class);
                startActivity(i);
            }
        });
        stu_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,StudentDetailsActivity.class);
                startActivity(i);
            }
        });
        queries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,queries.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,profile.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
                openlogin_dorms();
            }
        });


    }
    public void openlogin_dorms(){
        Intent intent = new Intent(this, Login_dorms.class);
        startActivity(intent);
        SharedPreferences.Editor editor = getSharedPreferences("PREF_DORMS",MODE_PRIVATE).edit();
        editor.putBoolean("IS_LOGIN",false);
        editor.commit();
    }

    }
