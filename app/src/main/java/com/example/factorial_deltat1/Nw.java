package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Nw extends AppCompatActivity implements View.OnClickListener {
TextView ta,answer;



@Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent in = getIntent();
        int l = in.getIntExtra(Normal2.EXTRA_QW,0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nw);

        answer=(TextView)findViewById(R.id.answer);
        ta=(TextView)findViewById(R.id.ta);

        answer.setText("Right answer is "+l);

        ta.setOnClickListener(this);


}

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ta){
            Intent intent= new Intent(Nw.this,Normal.class);
            startActivity(intent);

        }
    }




}
