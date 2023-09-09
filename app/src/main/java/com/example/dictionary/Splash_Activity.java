package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class Splash_Activity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.splash_iv);

        AlphaAnimation alpha = new AlphaAnimation(0,1);
        alpha.setDuration(3000);
        //alpha.setRepeatCount(3);
        imageView.startAnimation(alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new ConstantMethod(Splash_Activity.this,MainActivity.class);
                finish();
            }
        },3500);
    }
}