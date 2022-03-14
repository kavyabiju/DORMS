package com.example.dormsadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class view_breakfast extends AppCompatActivity {
    RecyclerView break1;
    ArrayList<model>list;
    breakfastadapter breakfastadapter;
    DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("ADD ITEM");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_breakfast);
        break1 = findViewById(R.id.breakfast);

        break1.setHasFixedSize(true);
        break1.setLayoutManager(new LinearLayoutManager(this));
        break1.setAdapter(breakfastadapter);
        list = new ArrayList<>();
        breakfastadapter = new breakfastadapter(this,list);
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    model model = dataSnapshot.getValue(model.class);
                    list.add(model);
                }
                breakfastadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}