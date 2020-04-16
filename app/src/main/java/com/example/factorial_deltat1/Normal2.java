package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Normal2 extends AppCompatActivity implements View.OnClickListener {

    TextView o1, o2, o3;
    int q,e,f,b;
    public static final String EXTRA_QW = "com.example.Factorial_DeltaT1.EXTRA_QW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {                                        //e is p/2
        Intent intent = getIntent();                                                            //
        int p = intent.getIntExtra(Normal.EXTRA_P, 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal2);
        b=1;
        int a = p / 2; e = 0; f = 0;
        int x[]=new int[100];
        int y[]= new int[100];

        int i=0; b=0;
        if(p>3) {

            while (a > 0) {
                if (p % a == 0) {
                    x[i]=a;i++;
                    if(i==1){
                        e=a;
                    }
                }
                a = a - 1;
            }


            final int random= new Random().nextInt(i);
            a=x[random];
            b=a;


            final int rando = new Random().nextInt(p - (p/2)) + p/2;
            e= rando;

            while(e==p/2) {
                final int r = new Random().nextInt(p - (p/2)) + p/2;
                e= r;
            }




            final int ran = new Random().nextInt(p - (p/2)) + p/2;
            f= ran;
            while(f==e) {
                final int randoms = new Random().nextInt(p - (p/2)) + p/2;
                f= randoms;
            }

            y[0]=a;
            y[1]=e;
            y[2]=f;


            final int ra =new Random().nextInt(3);
            a=y[ra];

            for(int j=ra;j<3;j++){
                y[j]=y[j+1];
            }

            final int rand=new Random().nextInt(2);
            e=y[rand];

            for(int j=rand;j<2;j++){
                y[j]=y[j+1];
            }

            f=y[0];
        }
        else{
            a=1;e=4;f=5;
        }


        q=a;
        o1 = (TextView) findViewById(R.id.o1);
        o2 = (TextView) findViewById(R.id.o2);
        o3 = (TextView) findViewById(R.id.o3);

        o1.setText("" + e);
        o2.setText("" + a);
        o3.setText("" + f);

        o1.setOnClickListener(this);
        o2.setOnClickListener(this);
        o3.setOnClickListener(this);

    }
        @Override
        public void onClick (View v){
            if (v.getId() == R.id.o1) {
                if (e==b){
                    Intent in = new Intent(this, Nr.class);
                    startActivity(in);

                }

                else {

                    Intent in = new Intent(Normal2.this, Nw.class);
                    in.putExtra(EXTRA_QW, q);
                    startActivity(in);
                }
            }
            if (v.getId() == R.id.o2) {
                if (q==b){
                    Intent in = new Intent(this, Nr.class);
                    startActivity(in);

                }

                else {

                    Intent in = new Intent(Normal2.this, Nw.class);
                    in.putExtra(EXTRA_QW, q);
                    startActivity(in);
                }
            }
            if (v.getId() == R.id.o3) {



                if (f==b){
                    Intent in = new Intent(this, Nr.class);
                    startActivity(in);

                }

                else {

                    Intent in = new Intent(Normal2.this, Nw.class);
                    in.putExtra(EXTRA_QW, q);
                    startActivity(in);
                }
            }

        }


}




