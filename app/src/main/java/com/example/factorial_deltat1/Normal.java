package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Normal extends AppCompatActivity implements View.OnClickListener {

    EditText no;
Button done;

public static final String EXTRA_P="com.example.Factorial_DeltaT1.EXTRA_P";

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        done =(Button) findViewById(R.id.done);

        done.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.done){
            no=(EditText)findViewById(R.id.no);


            if (no.getText().toString().matches("")) {
                Toast.makeText(this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                int i=Integer.parseInt(no.getText().toString());
                Intent intent = new Intent(this, Normal2.class);
                intent.putExtra(EXTRA_P, i);
                startActivity(intent);

            }

        }
    }
}
