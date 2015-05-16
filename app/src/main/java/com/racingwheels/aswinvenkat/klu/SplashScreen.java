package com.racingwheels.aswinvenkat.klu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by aswin venkat on 5/5/2015.
 */
public class SplashScreen extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread background = new Thread() {
            public void run() {

                try {
                    sleep(3000);
                    Intent i=new Intent(getBaseContext(),HomeScreen.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
            }
        };

        background.start();
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
    }

