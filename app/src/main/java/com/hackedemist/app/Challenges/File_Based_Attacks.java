package com.hackedemist.app.Challenges;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.File_Based_Attacks.Fb_Level1;
import com.hackedemist.app.File_Based_Attacks.Fb_Level10;
import com.hackedemist.app.File_Based_Attacks.Fb_Level2;
import com.hackedemist.app.File_Based_Attacks.Fb_Level3;
import com.hackedemist.app.File_Based_Attacks.Fb_Level4;
import com.hackedemist.app.File_Based_Attacks.Fb_Level5;
import com.hackedemist.app.File_Based_Attacks.Fb_Level6;
import com.hackedemist.app.File_Based_Attacks.Fb_Level7;
import com.hackedemist.app.File_Based_Attacks.Fb_Level8;
import com.hackedemist.app.File_Based_Attacks.Fb_Level9;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.UserEnumeration.Ue_Level1;
import com.termux.R;

import java.io.File;

public class File_Based_Attacks extends Activity {

    private ImageButton fb1;
    private ImageButton fb2;
    private ImageButton fb3;
    private ImageButton fb4;
    private ImageButton fb5;
    private ImageButton fb6;
    private ImageButton fb7;
    private ImageButton fb8;
    private ImageButton fb9;
    private ImageButton fb10;

    private LottieAnimationView home_fb;

    //Level Lock Bools
    private Boolean lock2;
    private Boolean lock3;
    private Boolean lock4;
    private Boolean lock5;
    private Boolean lock6;
    private Boolean lock7;
    private Boolean lock8;
    private Boolean lock9;
    private Boolean lock10;

    private long back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file__based__attacks);

        fb1=(ImageButton)findViewById(R.id.fa1);
        fb2=(ImageButton)findViewById(R.id.fa2);
        fb3=(ImageButton)findViewById(R.id.fa3);
        fb4=(ImageButton)findViewById(R.id.fa4);
        fb5=(ImageButton)findViewById(R.id.fa5);
        fb6=(ImageButton)findViewById(R.id.fa6);
        fb7=(ImageButton)findViewById(R.id.fa7);
        fb8=(ImageButton)findViewById(R.id.fa8);
        fb9=(ImageButton)findViewById(R.id.fa9);
        fb10=(ImageButton)findViewById(R.id.fa10);

        home_fb=(LottieAnimationView) findViewById(R.id.home_fb);

        //lock mechanism
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(File_Based_Attacks.this);

        lock2 = prefs.getBoolean("coinsFb1",false);
        lock3 = prefs.getBoolean("coinsFb2",false);
        lock4 = prefs.getBoolean("coinsFb3",false);
        lock5 = prefs.getBoolean("coinsFb4",false);
        lock6 = prefs.getBoolean("coinsFb5",false);
        lock7 = prefs.getBoolean("coinsFb6",false);
        lock8 = prefs.getBoolean("coinsFb7",false);
        lock9 = prefs.getBoolean("coinsFb8",false);
        lock10 = prefs.getBoolean("coinsFb9",false);

        updateLocks();

        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(File_Based_Attacks.this, Fb_Level1.class));
            }
        });


        fb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (!lock2)
                   Toast.makeText(File_Based_Attacks.this,"Level 2 Locked",Toast.LENGTH_SHORT).show();
                else
                startActivity(new Intent(File_Based_Attacks.this, Fb_Level2.class));
            }
        });



        fb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock3)
                    Toast.makeText(File_Based_Attacks.this,"Level 3 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level3.class));            }
        });



        fb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock4)
                    Toast.makeText(File_Based_Attacks.this,"Level 4 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level4.class));            }
        });



        fb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock5)
                    Toast.makeText(File_Based_Attacks.this,"Level 5 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level5.class));            }
        });

        home_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(File_Based_Attacks.this, Level_start.class));
            }
        });



        fb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock6)
                    Toast.makeText(File_Based_Attacks.this,"Level 6 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level6.class));            }
        });



        fb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock7)
                    Toast.makeText(File_Based_Attacks.this,"Level 7 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level7.class));            }
        });



        fb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock8)
                    Toast.makeText(File_Based_Attacks.this,"Level 8 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level8.class));            }
        });


        fb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock9)
                    Toast.makeText(File_Based_Attacks.this,"Level 9 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level9.class));            }
        });



        fb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock10)
                    Toast.makeText(File_Based_Attacks.this,"Level 10 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(File_Based_Attacks.this, Fb_Level10.class));            }
        });





    }

    public void updateLocks()
    {


        //checking for lock for setting up the lock images
        if(!lock2)
        {
            fb2.setImageResource(R.drawable.lock);
        }

        if(!lock3)
        {
            fb3.setImageResource(R.drawable.lock);
        }

        if(!lock4)
        {
            fb4.setImageResource(R.drawable.lock);
        }

        if(!lock5)
        {
            fb5.setImageResource(R.drawable.lock);
        }

        if(!lock6)
        {
            fb6.setImageResource(R.drawable.lock);
        }

        if(!lock7)
        {
            fb7.setImageResource(R.drawable.lock);
        }

        if(!lock8)
        {
            fb8.setImageResource(R.drawable.lock);
        }

        if(!lock9)
        {
            fb9.setImageResource(R.drawable.lock);
        }

        if(!lock10)
        {
            fb10.setImageResource(R.drawable.lock);
        }
    }

    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()){
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
        else{
            Toast.makeText(getBaseContext(),
                "Press once again to exit!", Toast.LENGTH_SHORT)
                .show();
        }
        back_pressed = System.currentTimeMillis();
    }
}
