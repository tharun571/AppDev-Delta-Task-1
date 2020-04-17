package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Hackerplus extends AppCompatActivity {
TextView sta,mod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackerplus);


        sta=(TextView)findViewById(R.id.sta);
        mod=(TextView)findViewById(R.id.mod);


        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Hackerplus.this,Gameplus.class);
                startActivity(intent);

            }
        });



        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hackerplus.this,Dashboard.class);
                startActivity(intent);
            }
        });






    }
}
