package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class add_dinner extends AppCompatActivity {

    Button add_button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dinner);

        add_button3 = findViewById(R.id.add_button3);

        add_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(add_dinner.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                openview_menu();
            }
        });
    }

    public void openview_menu() {
        Intent intent = new Intent(this, view_menu.class);
        startActivity(intent);
    }
}