package com.namankhurpia.paper.view.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.namankhurpia.paper.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        final
        Thread mythread=new Thread()
        {
            @Override
            public void run() {
                super.run();

                try {
                    sleep(1500);



                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean previouslyStarted = prefs.getBoolean("Alreadystarted", false);
                    if(!previouslyStarted) {
                        SharedPreferences.Editor edit = prefs.edit();
                        edit.putBoolean("Alreadystarted", Boolean.TRUE);
                        edit.commit();

                        //transfer to slide
                        Intent i=new Intent(MainActivity.this,onboarding.class);
                        startActivity(i);


                    }
                    else{
                        startActivity(new Intent(MainActivity.this,home_screen.class));
                    }


                    finish();


                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();

    }


}



