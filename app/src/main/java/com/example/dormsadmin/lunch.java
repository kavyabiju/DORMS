package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dormsadmin.databinding.ActivityStudentDetailsBinding;

public class lunch extends AppCompatActivity {

    Button add_lunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        add_lunch = findViewById(R.id.add_lunch);

        add_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(lunch.this,add_lunch.class);
                startActivity(i);
            }
        });

    }
}