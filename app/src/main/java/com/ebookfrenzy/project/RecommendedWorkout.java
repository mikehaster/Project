package com.ebookfrenzy.project;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ebookfrenzy.project.R;

import java.util.Random;

public class RecommendedWorkout extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoworkout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


        });
        final Random r = new Random();
        int num = r.nextInt(5); //random generated number from 0 to 5
//cases for workouts
        String workout;
        switch (num) {
            case 1:
                workout = "Push-ups";
                break;
            case 2:
                workout = "Sit-ups";
                break;
            case 3:
                workout = "Pull-ups";
                break;
            case 4:
                workout = "Dips";
                break;
            case 5:
                workout = "Chest press";
                break;
            default:
                workout = "Run"; //if the number is 0, then run is chosen
                break;
        }


        //setting the workout string into textView4
        setContentView(R.layout.content_recoworkout);
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(workout);


        // switchButton (button7 in activity_timer) starts Timer
        Button switchButton = (Button)findViewById(R.id.button7);
        final Intent intentForSecondActivity =
                new Intent(this, Timer.class);
        switchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentForSecondActivity);
            }
        });
    }



}

