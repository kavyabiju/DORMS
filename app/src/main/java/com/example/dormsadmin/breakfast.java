package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class breakfast extends AppCompatActivity {
    Button add_break,view_break;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        add_break = findViewById(R.id.add_break);
        view_break = findViewById(R.id.view_break);

        add_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(breakfast.this,add_breakfast.class);
                startActivity(i);
            }
        });
        view_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(breakfast.this,view_breakfast.class);
                startActivity(i);
            }
        });

    }
}