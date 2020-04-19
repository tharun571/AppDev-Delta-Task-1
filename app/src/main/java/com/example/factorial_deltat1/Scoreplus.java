package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Scoreplus extends AppCompatActivity {
TextView yss,hss,taaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreplus);
        Intent intent = getIntent();                                                            //
        int p = intent.getIntExtra(Gameplus.EXTRA_HSS, 0);
        yss= findViewById(R.id.yss);
        hss= findViewById(R.id.hss);
        taaa= findViewById(R.id.taaa);

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
