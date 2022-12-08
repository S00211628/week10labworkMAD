package com.example.mobileapplicationdevelopmentweek10labgroupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    List<Integer> numSeq = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Random random = new Random();

                for (int i =0; i<2; i++){
                    int val = random.nextInt(5-1)+1;
                    numSeq.add(val);
                }
                System.out.println(numSeq);
            }
        });

        Intent  i = new Intent(MainActivity.this, GameActivity.class);
        startActivity(i);

    }
}