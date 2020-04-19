package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Nr extends AppCompatActivity implements View.OnClickListener {
TextView ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nr);
        ta= findViewById(R.id.ta);

        ta.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ta){
            Intent intent= new Intent(Nr.this,Normal.class);
            startActivity(intent);

        }
    }
}
