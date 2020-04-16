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
    int t=0;

    private static final String TAG="MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {                                        //e q f b x y

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


    while(t==0){
        t=1;
        Log.w(TAG,"qwertyuiop");
            final int rr = new Random().nextInt(100) + 1;
            p = rr;
            b = 1;
            a = p / 2;
            e = 0;
            f = 0;
            int x[] = new int[100];
            int y[] = new int[100];

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


                final int rando = new Random().nextInt(p - (p / 2)) + p / 2;
                e = rando;

                while (e == p / 2) {
                    final int r = new Random().nextInt(p - (p / 2)) + p / 2;
                    e = r;
                }


                final int ran = new Random().nextInt(p - (p / 2)) + p / 2;
                f = ran;
                while (f == e) {
                    final int randoms = new Random().nextInt(p - (p / 2)) + p / 2;
                    f = randoms;
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
            }


            q = a;

            c1 = (TextView) findViewById(R.id.c1);
            c2 = (TextView) findViewById(R.id.c2);
            c3 = (TextView) findViewById(R.id.c3);
            qu = (TextView) findViewById(R.id.qu);


            qu.setText("SELECT THE RIGHT FACTOR OF " + p);
            c1.setText("" + e);
            c2.setText("" + a);
            c3.setText("" + f);

            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (e == b) {
                        u++;
                        t--;



                    } else {


                        Intent intent = new Intent(Game.this, Score.class);
                        startActivity(intent);


                    }
                }
            });

            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a == b) {
                        u++;
                        t--;


                    } else {

                        Intent intent = new Intent(Game.this, Score.class);

                        startActivity(intent);


                    }
                }
            });


            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f == b) {
                        u++;
                        t--;

                    } else {


                        Intent intent = new Intent(Game.this, Score.class);
                        startActivity(intent);


                    }
                }
            });
        }


    }
}
