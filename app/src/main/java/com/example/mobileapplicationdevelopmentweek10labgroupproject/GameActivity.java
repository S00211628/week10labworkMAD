package com.example.mobileapplicationdevelopmentweek10labgroupproject;

import static com.example.mobileapplicationdevelopmentweek10labgroupproject.R.id.btnButtonRed;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GameActivity extends AppCompatActivity {


    Button btnTest;
    Button btnButtonRed;
    Button btnButtonBlue;
    Button btnButtonYellow;
    Button btnButtonGreen;

    Button select;


    int i = 0;
    Boolean nextButton = false;


    ArrayList<Integer> sequence = new ArrayList<Integer>();


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);



        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);

        btnTest = findViewById(R.id.btnTest);

        btnButtonRed = findViewById(R.id.btnButtonRed);
        btnButtonBlue = findViewById(R.id.btnButtonBlue);
        btnButtonYellow = findViewById(R.id.btnButtonYellow);
        btnButtonGreen = findViewById(R.id.btnButtonGreen);


//        Essentially kind of useless

        Drawable red_pressed = getApplication().getResources().getDrawable(R.drawable.red_button_pressed);
        Drawable red = getApplication().getResources().getDrawable(R.drawable.red_button);

        Drawable blue_pressed = getApplication().getResources().getDrawable(R.drawable.blue_button_pressed);
        Drawable blue = getApplication().getResources().getDrawable(R.drawable.blue_button);

        Drawable green_pressed = getApplication().getResources().getDrawable(R.drawable.green_button_pressed);
        Drawable green = getApplication().getResources().getDrawable(R.drawable.green_button);

        Drawable yellow_pressed = getApplication().getResources().getDrawable(R.drawable.yellow_button_pressed);
        Drawable yellow = getApplication().getResources().getDrawable(R.drawable.yellow_button);

//        End of soon to be useless





        btnTest.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                i = 0;
                    Log.v("Message","Stage 1");
                new CountDownTimer(3000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        Log.v("Message","On Tick");
                        Log.v("Message","Stage 2");

                        if (sequence.get(i) == 1)
                        {
                            Log.v("Message","Stage 3");
                            flashColour(R.id.btnButtonBlue);
                            Log.v("Message","Stage 4");


                        }
                        else if(sequence.get(i) == 2)
                        {
                            Log.v("Message","Stage 5");
                            flashColour(R.id.btnButtonRed);
                            Log.v("Message","Stage 6");

                        }
                        Log.v("Message","Stage 7");
                        i++;
                    }
                    public void onFinish() {
                        select.clearAnimation();
                        Log.v("Message","Animation Clear");
                    }
                }.start();



            }

            private void flashColour(int id) {

                select = (Button) findViewById(id);

                Log.v("Message","flash colour method called");
                        Animation mAnimation = new AlphaAnimation(1, 0);
                        mAnimation.setDuration(500);
                        mAnimation.setInterpolator(new LinearInterpolator());
                        mAnimation.setRepeatCount(Animation.INFINITE);
                        mAnimation.setRepeatMode(Animation.REVERSE);
                        select.startAnimation(mAnimation);
                select.clearAnimation();
                Log.v("Message","End of countdown");
            }

        });
    }


}