package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view_room extends AppCompatActivity {
    Button add_room, view_room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room);
        add_room = findViewById(R.id.add_room);
        view_room = findViewById(R.id.bview_room);

        add_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view_room.this,Room_details.class);
                startActivity(i);
            }
        });
        view_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view_room.this,view_roomdetails.class));
            }
        });
    }
}