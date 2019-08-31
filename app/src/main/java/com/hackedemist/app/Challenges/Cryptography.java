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
import com.hackedemist.app.Cryptography.Crypto_Level1;
import com.hackedemist.app.Cryptography.Crypto_Level2;
import com.hackedemist.app.Cryptography.Crypto_Level3;
import com.hackedemist.app.Cryptography.Crypto_Level4;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.Login_Activity.Login_Activity;
import com.hackedemist.app.Login_Activity.Sign_Up;
import com.hackedemist.app.WebApplication.Level3WebView;
import com.termux.R;

public class Cryptography extends Activity {

    private ImageButton cr1;
    private ImageButton cr2;
    private ImageButton cr3;
    private ImageButton cr4;
    private LottieAnimationView home_cr;

    //Levels Lock
    private Boolean lock2;
    private Boolean lock3;
    private Boolean lock4;

    private long back_pressed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptography);

        cr1=(ImageButton)findViewById(R.id.cr1);
        cr2=(ImageButton)findViewById(R.id.cr2);
        cr3=(ImageButton)findViewById(R.id.cr3);
        cr4=(ImageButton)findViewById(R.id.cr4);
        home_cr=(LottieAnimationView)findViewById(R.id.home_cr);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Cryptography.this);
        lock2 = prefs.getBoolean("coinsCr1",false);
        lock3 = prefs.getBoolean("coinsCr2",false);
        lock4 = prefs.getBoolean("coinsCr3",false);

        updateLocks();

        cr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Cryptography.this, Login_Activity.class));
            }
        });

        cr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lock2)
                    Toast.makeText(Cryptography.this,"Level 2 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(Cryptography.this, Crypto_Level2.class));            }
        });

        cr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!lock3)
                    Toast.makeText(Cryptography.this,"Level 3 Locked",Toast.LENGTH_SHORT).show();
                else
                startActivity(new Intent(Cryptography.this, Crypto_Level3.class));
            }
        });

        cr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lock4)
                    Toast.makeText(Cryptography.this,"Level 4 Locked",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(Cryptography.this, Crypto_Level4.class));
            }
        });

        home_cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cryptography.this, Level_start.class));
            }
        });


    }

    public void updateLocks()
    {


        //checking for lock for setting up the lock images
        if(!lock2)
        {
            cr2.setImageResource(R.drawable.lock);
        }

        if(!lock3)
        {
            cr3.setImageResource(R.drawable.lock);
        }

        if(!lock4)
        {
            cr4.setImageResource(R.drawable.lock);
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
