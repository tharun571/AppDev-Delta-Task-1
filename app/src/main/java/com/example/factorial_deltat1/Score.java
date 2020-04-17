package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {
TextView ys,hs,taa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();                                                            //
        int p = intent.getIntExtra(Game.EXTRA_HS, 0);
        ys=(TextView)findViewById(R.id.ys);
        hs=(TextView)findViewById(R.id.hs);
        taa=(TextView)findViewById(R.id.taa);

        ys.setText("YOUR SCORE IS " + p);




        SharedPreferences prefs=getApplicationContext().getSharedPreferences("value",MODE_PRIVATE);
        SharedPreferences.Editor editor =prefs.edit();

        int id =prefs.getInt("id",0);

        if(p>id){

            editor.putInt("id",p);
            editor.apply();
            hs.setText("HIGH SCORE: " + p);
        }


        else {
            hs.setText("HIGH SCORE: " + id);
        }

        taa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this , Hacker.class);
                startActivity(intent);
            }
        });




    }
}
