package com.ebookfrenzy.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "org.knowlass.eb.knowlass1statechange";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view){
                startActivity(new Intent(MainActivity.this, ListWorkouts.class)); //click leads to All Workouts screen
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view1){
                startActivity(new Intent(MainActivity.this, RecommendedWorkout.class)); //click leads to Recommended Workout screen
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view2){
                startActivity(new Intent(MainActivity.this, Profile.class)); //click leads to Profile screen
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view2){
                startActivity(new Intent(MainActivity.this, Timer.class)); //click leads to Time screen
            }
        });
        Button button8 = (Button) findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view2){
                startActivity(new Intent(MainActivity.this, CalculateBMI.class)); //click leads to CalculateBMI screen
            }
        });
        Button button9 = (Button) findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view2){
                startActivity(new Intent(MainActivity.this, ContactTrainer.class)); //click leads to ContactTrainer screen
            }
        });
        Button button15 = (Button) findViewById(R.id.button15);

        button15.setOnClickListener(new View.OnClickListener(){//button on click
            @Override
            public void onClick (View view2){
                startActivity(new Intent(MainActivity.this, Squats.class)); //click leads to Squats screen
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Menu.FIRST, 0, "PROFILE");
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ebookfrenzy.project/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ebookfrenzy.project/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    //save state for text
    public class StateChangeActivity extends AppCompatActivity{
        protected void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            final EditText textBox =
                    (EditText) findViewById(R.id.editText2);
            CharSequence userText = textBox.getText();
            outState.putCharSequence("savedText", userText);

        }

    }



}
