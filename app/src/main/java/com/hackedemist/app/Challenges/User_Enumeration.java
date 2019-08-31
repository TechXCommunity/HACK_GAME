package com.hackedemist.app.Challenges;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.UserEnumeration.Ue_Level1;
import com.hackedemist.app.UserEnumeration.Ue_Level2;
import com.termux.R;

public class User_Enumeration extends Activity {
    private ImageButton ue1;
    private ImageButton ue2;
    private Boolean lock2;
    private LottieAnimationView home_ue;

    private long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__enumeration);

        ue1=(ImageButton)findViewById(R.id.ue1);
        ue2=(ImageButton)findViewById(R.id.ue2);
        home_ue=(LottieAnimationView) findViewById(R.id.home_ue);

        //Coins Management
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(User_Enumeration.this);
        lock2 = prefs.getBoolean("coinsUe1",false);

        updateLocks();

        ue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(User_Enumeration.this, Ue_Level1.class));
            }
        });

        home_ue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_Enumeration.this, Level_start.class));
            }
        });



        ue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!lock2)
                    Toast.makeText(User_Enumeration.this,"Level 2 Locked",Toast.LENGTH_SHORT).show();
                else{
                    startActivity(new Intent(User_Enumeration.this, Ue_Level2.class));
                }
            }
        });
    }

    public void updateLocks()
    {


        //checking for lock for setting up the lock images
        if(!lock2)
        {
            ue2.setImageResource(R.drawable.lock);
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
