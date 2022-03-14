package com.example.dormsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;
    Animation top_anim,bottom_anim;
    ImageView dorms,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_anim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        dorms=findViewById(R.id.dorms);
        dorms.setAnimation(top_anim);
        slogan=findViewById(R.id.slogan1);
        slogan.setAnimation(bottom_anim);

        Boolean IS_LOGIN = getSharedPreferences("PREF_DORMS",MODE_PRIVATE).getBoolean("IS_LOGIN",false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!IS_LOGIN){
                    Intent intent=new Intent(MainActivity.this,Login_dorms.class);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent=new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                    finish();
                }


            }
        },SPLASH_SCREEN);

    }

}