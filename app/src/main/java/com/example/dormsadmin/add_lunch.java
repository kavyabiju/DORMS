package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class add_lunch extends AppCompatActivity {

    Button add_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        add_button2 = findViewById(R.id.add_button2);

        add_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(add_lunch.this,"Added Successfully",Toast.LENGTH_SHORT).show();
                openview_menu();
            }
        });
    }
    public void openview_menu(){
        Intent intent = new Intent(this, view_menu.class);
        startActivity(intent);
    }
}