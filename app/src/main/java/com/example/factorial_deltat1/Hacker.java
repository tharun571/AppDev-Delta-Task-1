package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Hacker extends AppCompatActivity implements View.OnClickListener {
TextView st,mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacker);

       st=(TextView)findViewById(R.id.st);

       mode=(TextView)findViewById(R.id.mode);

        st.setOnClickListener(this);

        mode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.st){
            Intent intent = new Intent(Hacker.this,Game.class);
            startActivity(intent);

        }

        if (v.getId()==R.id.mode){
            Intent intent = new Intent(Hacker.this,Dashboard.class);
            startActivity(intent);

        }
    }
}
