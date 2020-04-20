package com.example.factorial_deltat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.Random;

public class Gameplus extends AppCompatActivity {

    TextView time, co1, co2, co3, que,sc;
    ProgressBar pb;
    private static int SPLASH=200;
    int q,e,f,b,u=0,a,p;
    View view;


    int tl=10;
    public static final long sr = 10000;






        CountDownTimer timer = new CountDownTimer(sr, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                time.setText("TIME REMAINING: " + tl+ " s");
                pb.setProgress((int)(10-tl)*10);
                tl--;


            }

            @Override
            public void onFinish() {
                co1.setEnabled(false);
                co2.setEnabled(false);
                co3.setEnabled(false);
                pb.setProgress(0);

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
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        co1 = findViewById(R.id.co1);
        co2 = findViewById(R.id.co2);
        co3 = findViewById(R.id.co3);
        que = findViewById(R.id.que);
        time= findViewById(R.id.time);
        sc= findViewById(R.id.sc);
        pb=(ProgressBar)findViewById(R.id.pb);
        pb.getProgressDrawable().setColorFilter(Color.WHITE,android.graphics.PorterDuff.Mode.SRC_IN);
        LinearLayout constraintLayout = findViewById(R.id.layout1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(100);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        view=this.getWindow().getDecorView();
        call();

    }

    private void call() {
        Log.w(TAG,"Continue");

        if(u>0&&u%10==0){
            que.setBackgroundResource(R.drawable.buttonw);
            functionbonus();



        }

        else {
            que.setBackgroundResource(R.drawable.button);


            function();


        }



        sc.setText("SCORE : "+u);
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
        int[] x = new int[100];
        int[] y = new int[100];

        int i = 0;
        b = 0;
        if (p > 3) {

            while (a > 0) {
                if (p % a == 0) {
                    x[i] = a;
                    i++;

                }
                a = a - 1;
            }

            if(i>1){
                i=i-1;
            }


            final int random = new Random().nextInt(i);
            a = x[random];
            b = a;


            final int rando=new Random().nextInt(p-2)+2;
            e=rando;

            while (p%e==0) {
                final int rand=new Random().nextInt(p-2)+2;
                e=rand;

            }
            final int ran=new Random().nextInt(p-2)+2;
            f=ran;

            while (p%f==0|e==f) {
                final int ra=new Random().nextInt(p-2)+2;
                f=ra;

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
                    co1.setBackgroundResource(R.drawable.buttonr);





                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            co1.setBackgroundResource(R.drawable.button);



                        }
                    },SPLASH);

                    u++;
                    call();






                } else {
                    timer.cancel();

                    co1.setBackgroundResource(R.drawable.buttonw);

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
                    Log.w(TAG,"end");
                    co2.setBackgroundResource(R.drawable.buttonr);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            co2.setBackgroundResource(R.drawable.button);


                        }
                    },SPLASH);



                    u++;

                    call();


                } else {
                    timer.cancel();
                    co2.setBackgroundResource(R.drawable.buttonw);

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
                    Log.w(TAG,"end");
                    co3.setBackgroundResource(R.drawable.buttonr);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            co3.setBackgroundResource(R.drawable.button);



                        }
                    },SPLASH);
                    u++;



                    call();

                } else {
                    timer.cancel();
                    co3.setBackgroundResource(R.drawable.buttonw);

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





    private void functionbonus() {



        Log.w(TAG,"qwertyuiop");
        final int rr = new Random().nextInt(9000) + 1000;
        p = rr;
        b = 1;
        a = p / 2;
        e = 0;
        f = 0;
        int[] x = new int[100];
        int[] y = new int[100];

        int i = 0;
        b = 0;
        if (p > 4) {

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
            if(i>1){
                i--;
            }



            final int random = new Random().nextInt(i);
            a = x[random];
            b = a;


            final int rando=new Random().nextInt(p-2)+2;
            e=rando;

            while (p%e==0) {
                final int rand=new Random().nextInt(p-2)+2;
                e=rand;

            }
            final int ran=new Random().nextInt(p-2)+2;
            f=ran;

            while (p%f==0|e==f) {
                final int ra=new Random().nextInt(p-2)+2;
                f=ra;
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
            e = 6;
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
                    co1.setBackgroundResource(R.drawable.buttonr);





                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            co1.setBackgroundResource(R.drawable.button);



                        }
                    },SPLASH);

                    u=u+3;
                    call();






                } else {
                    timer.cancel();

                    co1.setBackgroundResource(R.drawable.buttonw);

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
                    Log.w(TAG,"end");
                    co2.setBackgroundResource(R.drawable.buttonr);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            co2.setBackgroundResource(R.drawable.button);


                        }
                    },SPLASH);



                    u=u+3;

                    call();


                } else {
                    timer.cancel();
                    co2.setBackgroundResource(R.drawable.buttonw);

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
                    u=u+3;
                    Log.w(TAG,"end");
                    co3.setBackgroundResource(R.drawable.buttonr);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            co3.setBackgroundResource(R.drawable.button);



                        }
                    },SPLASH);
                    u++;



                    call();

                } else {
                    timer.cancel();
                    co3.setBackgroundResource(R.drawable.buttonw);

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