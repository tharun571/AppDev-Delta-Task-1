package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Scoreplus extends AppCompatActivity {
TextView yss,hss,taaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreplus);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        Intent intent = getIntent();                                                            //
        int p = intent.getIntExtra(Gameplus.EXTRA_HSS, 0);
        yss= findViewById(R.id.yss);
        hss= findViewById(R.id.hss);
        taaa= findViewById(R.id.taaa);
        LinearLayout constraintLayout = findViewById(R.id.layout1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(100);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        yss.setText("YOUR SCORE IS " + p);




        SharedPreferences prefss=getApplicationContext().getSharedPreferences("value", MODE_PRIVATE);
        SharedPreferences.Editor editor =prefss.edit();

        int id =prefss.getInt("id",0);

        if(p>id){

            editor.putInt("id",p);
            editor.apply();
            hss.setText("HIGH SCORE: " + p);
        }


        else {
            hss.setText("HIGH SCORE: " + id);
        }

        taaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scoreplus.this , Hackerplus.class);
                startActivity(intent);
            }
        });

    }
}
