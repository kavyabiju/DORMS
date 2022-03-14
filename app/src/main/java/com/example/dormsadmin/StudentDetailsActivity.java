package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dormsadmin.databinding.ActivityStudentDetailsBinding;

public class StudentDetailsActivity extends AppCompatActivity {


    ActivityStudentDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStudentDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding = ActivityStudentDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentDetailsActivity.this,add_student.class);
                startActivity(i);
            }
        });
        binding.viewStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentDetailsActivity.this,view_student.class);
                startActivity(i);
            }
        });

    }
}