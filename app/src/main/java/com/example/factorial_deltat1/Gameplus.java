package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.Random;

public class Gameplus extends AppCompatActivity {

    TextView time, co1, co2, co3, que;
    int q,e,f,b,u=0,a,p;
    View view;

    int tl=10;
    public static final long sr = 10000;





        CountDownTimer timer = new CountDownTimer(sr, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                time.setText("Time remaining: " + tl+ " sec");
                tl--;


            }

            @Override
            public void onFinish() {
                co1.setEnabled(false);
                co2.setEnabled(false);
                co3.setEnabled(false);

                view.setBackgroundColor(Color.RED);
                Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vi.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    vi.vibrate(400);
                }


                Intent intent = new Intent(Gameplus.this, Scoreplus.class);
                intent.putExtra(EXTRA_HSS, u);
                startActivity(intent);


            }
        };





    public static final String EXTRA_HSS="com.example.Factorial_DeltaT1.EXTRA_HS";

    private static final String TAG="MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplus);
        co1 = (TextView) findViewById(R.id.co1);
        co2 = (TextView) findViewById(R.id.co2);
        co3 = (TextView) findViewById(R.id.co3);
        que = (TextView) findViewById(R.id.que);
        time=(TextView)findViewById(R.id.time);

        view=this.getWindow().getDecorView();
        call();

    }

    private void call() {
        Log.w(TAG,"Continue");
        function();


        timer.cancel();
        tl=10;


        timer.start();





    }


    private void function() {



        Log.w(TAG,"qwertyuiop");
        final int rr = new Random().nextInt(1000) + 1;
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


        q = a;







        que.setText("SELECT THE RIGHT FACTOR OF " + p);
        co1.setText("" + e);
        co2.setText("" + a);
        co3.setText("" + f);

        co1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e == b) {
                    Log.w(TAG,"end");
                    view.setBackgroundColor(Color.GREEN);




                    u++;
                    call();




                } else {
                    timer.cancel();

                    view.setBackgroundColor(Color.RED);

                    Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vi.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vi.vibrate(500);
                    }






                    Intent intent = new Intent(Gameplus.this, Scoreplus.class);
                    intent.putExtra(EXTRA_HSS,u);
                    startActivity(intent);



                }
            }
        });

        co2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a == b) {
                    Log.w(TAG,"end");view.setBackgroundColor(Color.GREEN);



                    u++;
                    call();


                } else {
                    timer.cancel();
                    view.setBackgroundColor(Color.RED);

                    Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vi.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vi.vibrate(500);
                    }



                    Intent intent = new Intent(Gameplus.this, Scoreplus.class);
                    intent.putExtra(EXTRA_HSS,u);



                    startActivity(intent);



                }
            }
        });


        co3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (f == b) {
                    u++;
                    Log.w(TAG,"end");view.setBackgroundColor(Color.GREEN);



                    call();

                } else {
                    timer.cancel();
                    view.setBackgroundColor(Color.RED);

                    Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vi.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vi.vibrate(500);
                    }



                    Intent intent = new Intent(Gameplus.this, Scoreplus.class);
                    intent.putExtra(EXTRA_HSS,u);
                    startActivity(intent);


                }
            }
        });
    }



}

