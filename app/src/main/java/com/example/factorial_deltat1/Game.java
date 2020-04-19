package com.example.factorial_deltat1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    TextView c1, c2, c3, qu;
    int q,e,f,b,u=0,a,p;
    View view;

    public static final String EXTRA_HS="com.example.Factorial_DeltaT1.EXTRA_HS";

    private static final String TAG="MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {                                        //e q f b x y

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.w(TAG,"START");
        view=this.getWindow().getDecorView();
        call();

    }

    private void call() {
        Log.w(TAG,"Continue");
        function();



    }


    private void function() {



            Log.w(TAG,"qwertyuiop");
            final int rr = new Random().nextInt(1000) + 1;
            p = rr;
            b = 1;
            a = p / 2;
            e = 0;
            f = 0;
        int[] x = new int[100];
        int[] y = new int[100];

            int i = 0;
            b = 0;
            if (p > 3) {

                while (a > 0) {
                    if (p % a == 0) {
                        x[i] = a;
                        i++;
                        if (i == 1) {
                            e = a;
                        }
                    }
                    a = a - 1;
                }


                final int random = new Random().nextInt(i);
                a = x[random];
                b = a;

                e=b+1;
                while (p%e==0) {
                    e = e+1;
                }



                f = e+1;
                while (p%f==0) {
                    f = f+1;
                }

                y[0] = a;
                y[1] = e;
                y[2] = f;


                final int ra = new Random().nextInt(3);
                a = y[ra];

                for (int j = ra; j < 3; j++) {
                    y[j] = y[j + 1];
                }

                final int rand = new Random().nextInt(2);
                e = y[rand];

                for (int j = rand; j < 2; j++) {
                    y[j] = y[j + 1];
                }

                f = y[0];
            } else {
                a = 1;
                e = 4;
                f = 5;
                b=1;
            }




            c1 = findViewById(R.id.c1);
            c2 = findViewById(R.id.c2);
            c3 = findViewById(R.id.c3);
            qu = findViewById(R.id.qu);



            qu.setText("SELECT THE RIGHT FACTOR OF " + p);
            c1.setText("" + e);
            c2.setText("" + a);
            c3.setText("" + f);

            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (e == b) {
                        Log.w(TAG,"end");
                        view.setBackgroundColor(Color.GREEN);


                        u++;
                        call();




                    } else {
                        view.setBackgroundColor(Color.RED);






                        Intent intent = new Intent(Game.this, Score.class);
                        intent.putExtra(EXTRA_HS,u);
                        startActivity(intent);



                    }
                }
            });

            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a == b) {
                        Log.w(TAG,"end");view.setBackgroundColor(Color.GREEN);


                        u++;
                        call();


                    } else {
                        view.setBackgroundColor(Color.RED);



                        Intent intent = new Intent(Game.this, Score.class);
                        intent.putExtra(EXTRA_HS,u);



                        startActivity(intent);



                    }
                }
            });


            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f == b) {
                        u++;
                        Log.w(TAG,"end");view.setBackgroundColor(Color.GREEN);


                        call();

                    } else {
                        view.setBackgroundColor(Color.RED);



                        Intent intent = new Intent(Game.this, Score.class);
                        intent.putExtra(EXTRA_HS,u);
                        startActivity(intent);


                    }
                }
            });
        }



}

