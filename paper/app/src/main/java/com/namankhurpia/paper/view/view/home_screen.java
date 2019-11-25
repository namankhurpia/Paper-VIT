package com.namankhurpia.paper.view.view;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;



import com.namankhurpia.paper.R;

import com.namankhurpia.paper.view.adapters.subject_adapter_recyclerview;

import static android.support.design.widget.TabLayout.*;

public class home_screen extends AppCompatActivity implements View.OnClickListener {

    ImageButton catone, cattwo, fat, aboutus, donate;


    //interstitial ads
    //private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //ads initialization
       /* MobileAds.initialize(this, "ca-app-pub-9666602807571879~1577101558");
        interstitialAd =new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());


        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();

                //startActivity(new Intent(home_screen.this,catone.class));
                ///interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
*/



        catone = (ImageButton) findViewById(R.id.catone_btn);
        cattwo = (ImageButton) findViewById(R.id.cattwo_btn);
        fat = (ImageButton) findViewById(R.id.fat_btn);
        aboutus = (ImageButton) findViewById(R.id.about_us_btn);
        donate = (ImageButton) findViewById(R.id.donate_btn);

        catone.setOnClickListener((View.OnClickListener) this);
        cattwo.setOnClickListener((View.OnClickListener) this);
        fat.setOnClickListener((View.OnClickListener) this);


        aboutus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_screen.this, about_us.class));

            }
        });

        donate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "adgpapervit@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Donating paper");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Attach images/pdfs/files here");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));


            }
        });


    }


















    private void startcatone() {



            Intent i=new Intent(home_screen.this,catone.class);
            startActivity(i);


    }


    private void startcattwo() {
        Intent i=new Intent(home_screen.this,cattwo.class);
        startActivity(i);
    }

    private void startfat() {
        startActivity(new Intent(home_screen.this,fat.class));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.catone_btn: {
                startcatone();
                break;

            }
            case R.id.cattwo_btn: {
                startcattwo();
                break;
            }
            case R.id.fat_btn: {
                startfat();
                break;
            }
            default:
                Toast.makeText(getApplicationContext(), "nothing", Toast.LENGTH_SHORT).show();
        }
    }



}