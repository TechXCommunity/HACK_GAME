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
import com.hackedemist.app.Level_start;
import com.hackedemist.app.WebApplication.Wa_Level1;
import com.hackedemist.app.WebApplication.Wa_Level2;
import com.hackedemist.app.WebApplication.Wa_Level3;
import com.termux.R;


public class Web_Application extends Activity {

    private ImageButton wa1;
    private ImageButton wa2;
    private ImageButton wa3;
    private LottieAnimationView home_wa;

    //locks for level
    private Boolean lock2;
    private Boolean lock3;

    private long back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_application);

        wa1 =(ImageButton)findViewById(R.id.wa_level1);
        wa2=(ImageButton)findViewById(R.id.wa_level2);
        wa3 =(ImageButton)findViewById(R.id.wa_level3);
        home_wa=(LottieAnimationView) findViewById(R.id.home_wa);


        //Coins Management
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Web_Application.this);
        lock2 = prefs.getBoolean("coinsWa1",false);
        lock3 = prefs.getBoolean("coinsWa2",false);

        updateLocks();


        wa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Web_Application.this, Wa_Level1.class));
            }
        });




        wa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock2)
                    Toast.makeText(Web_Application.this,"Level 2 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Web_Application.this, Wa_Level2.class));
                }

            }
        });


        wa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock3)
                    Toast.makeText(Web_Application.this,"Level 3 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Web_Application.this, Wa_Level3.class));
                }
            }
        });

        home_wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Web_Application.this, Level_start.class));
            }
        });







    }

    public void updateLocks()
    {


        //checking for lock for setting up the lock images
        if(!lock2)
        {
            wa2.setImageResource(R.drawable.lock);
        }

        if(!lock3)
        {
            wa3.setImageResource(R.drawable.lock);
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
