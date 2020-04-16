package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Animation top,bottom;
TextView hi,fact;


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

      hi.setAnimation(top);
      fact.setAnimation(bottom);


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
