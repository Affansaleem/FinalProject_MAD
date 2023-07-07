package com.example.fianlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static int splash_timeout = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TextView txtview = findViewById(R.id.textView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Read value of email

                Intent splashintent = new Intent(SplashActivity.this, Login.class);
                startActivity(splashintent);
                finish();
            }
        },splash_timeout);
        Animation myanimation = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.animation1);
        txtview.startAnimation(myanimation);

    }
}