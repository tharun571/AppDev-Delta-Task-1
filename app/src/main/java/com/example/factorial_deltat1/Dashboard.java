package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
Button n,h,hp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        n= findViewById(R.id.n);
        h= findViewById(R.id.h);
        hp= findViewById(R.id.hp);

        n.setOnClickListener(this);
        h.setOnClickListener(this);
        hp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.n) {
            Intent intent = new Intent(Dashboard.this,Normal.class);
            startActivity(intent);

        }

        if(v.getId()==R.id.h) {
            Intent intent = new Intent(Dashboard.this,Hacker.class);
            startActivity(intent);


        }
        if(v.getId()==R.id.hp) {
            Intent intent = new Intent(Dashboard.this,Hackerplus.class);
            startActivity(intent);


        }
    }
}
