package com.namankhurpia.paper.view.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.namankhurpia.paper.R;
import com.namankhurpia.paper.view.adapters.onboarding_slider_adapter;

public class onboarding extends AppCompatActivity {

    private ViewPager viewPager;
    private onboarding_slider_adapter myadapter;
    private ImageButton skip_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboarding);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new onboarding_slider_adapter(this);
        viewPager.setAdapter(myadapter);
        skip_button=(ImageButton)findViewById(R.id.skip_button);


        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(onboarding.this,home_screen.class);
                startActivity(i);

            }
        });
    }
}
