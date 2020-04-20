package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Animation top,bottom;
TextView hi,fact,name;


private static int SPLASH=5000;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_main);


      top= AnimationUtils.loadAnimation(this,R.anim.top);
      bottom= AnimationUtils.loadAnimation(this,R.anim.bottom);
      hi= findViewById(R.id.hi);
      fact= findViewById(R.id.fact);
      name= findViewById(R.id.name);


      hi.setAnimation(top);
      fact.setAnimation(top);
      name.setAnimation(bottom);

    LinearLayout constraintLayout = findViewById(R.id.layout);
    AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
    animationDrawable.setEnterFadeDuration(1000);
    animationDrawable.setExitFadeDuration(2000);
    animationDrawable.start();


      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(MainActivity.this,Dashboard.class);
              startActivity(intent);
              finish();
          }
      },SPLASH);







    }


}
