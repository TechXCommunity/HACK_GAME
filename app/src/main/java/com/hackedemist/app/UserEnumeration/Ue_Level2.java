package com.hackedemist.app.UserEnumeration;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Challenges.User_Enumeration;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint5;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.hackedemist.app.UserEnumeration.Ue_Readme.Ue_Readme2;
import com.termux.R;

public class Ue_Level2 extends Activity {


    private LottieAnimationView submit;
    private EditText ue_users;
    private ImageButton Termuxbtn5;
    private LottieAnimationView hint5btn;
    private ImageButton next5btn;
    private ImageButton prev5Btn;
    private TextView coinsUe2;
    private EditText ansUe2;
    private TextView Readme2;
    private LottieAnimationView home_ue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ue__level2);

        submit=(LottieAnimationView) findViewById(R.id.ue_submit2btn);
        ue_users=(EditText)findViewById(R.id.fb_submit2);
        Termuxbtn5=(ImageButton)findViewById(R.id.ue_termux2Btn);
        hint5btn=(LottieAnimationView) findViewById(R.id.ue_hint2btn);
        next5btn=(ImageButton) findViewById(R.id.ue_next2Btn);
        prev5Btn = (ImageButton) findViewById(R.id.ue_prev2Btn);
        home_ue2=(LottieAnimationView) findViewById(R.id.home_ue2);

        coinsUe2 = (TextView) findViewById(R.id.coinViewUe2) ;

        ansUe2 = (EditText) findViewById(R.id.ue_text2);
        Readme2=(TextView)findViewById(R.id.ue_readme2);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Ue_Level2.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        prev5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level2.this, Ue_Level1.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users;
                users=ansUe2.getText().toString();

                Boolean lock = prefs.getBoolean("coinsUe2",false);

                if(users.equalsIgnoreCase("//")){
                    Toast.makeText(Ue_Level2.this,"User_Enumeration Completed",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsUe2",true).apply();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Ue_Level2.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Ue_Level2.this, Level_next.class);
                                startActivity(i);
                            }
                            catch(InterruptedException e)
                            {
                                e.printStackTrace();

                            }
                        }
                    };

                    complete.start();
                }else{
                    Level_start.levelFailedCoins(sharedPreferences);
                    updateCoins();
                    Toast.makeText(Ue_Level2.this,"Oops!..Wrong Inputs Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });

        next5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level2.this, Level_next.class));
            }
        });
        home_ue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level2.this, User_Enumeration.class));
            }
        });



        Termuxbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level2.this, TermuxActivity.class));
            }
        });


        hint5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Ue_Level2.this, ActivityHint5.class));
            }
        });

        Readme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Ue_Level2.this, Ue_Readme2.class));
            }
        });


    }

    public void updateCoins()
    {
        coinsUe2.setText(Level_start.getCoins);
    }
}
