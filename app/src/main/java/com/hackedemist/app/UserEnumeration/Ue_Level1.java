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
import com.hackedemist.app.UserEnumeration.Ue_Readme.Ue_Readme1;
import com.termux.R;

public class Ue_Level1 extends Activity {


    private LottieAnimationView submit;
    private ImageButton Termuxbtn5;
    private LottieAnimationView hint5btn;
    private ImageButton next5btn;
    private ImageButton prev5Btn;
    private TextView coinsUe1;
    private EditText ansUe1;
    private LottieAnimationView home_ue1;
    private TextView Readme1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ue__level1);

        submit=(LottieAnimationView) findViewById(R.id.ue_submitbtn);
        Termuxbtn5=(ImageButton)findViewById(R.id.ue_termuxBtn);
        hint5btn=(LottieAnimationView) findViewById(R.id.ue_hintbtn);
        next5btn=(ImageButton) findViewById(R.id.ue_nextBtn);
        prev5Btn = (ImageButton) findViewById(R.id.ue_prevBtn);
        home_ue1=(LottieAnimationView) findViewById(R.id.home_ue1);

        coinsUe1 = (TextView) findViewById(R.id.coinViewUe1) ;
        Readme1=(TextView)findViewById(R.id.ue_readme1);


        ansUe1 = (EditText) findViewById(R.id.ue_text1);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Ue_Level1.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        prev5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level1.this, Level_next.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users;
                users=ansUe1.getText().toString();

                Boolean lock = prefs.getBoolean("coinsUe1",false);

                if(users.equalsIgnoreCase("1")){
                    Toast.makeText(Ue_Level1.this,"User_Enumeration Completed",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsUe1",true).apply();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Ue_Level1.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Ue_Level1.this, Ue_Level2.class);
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
                    Toast.makeText(Ue_Level1.this,"Oops!..Wrong Inputs Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });

        next5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level1.this, Ue_Level2.class));
            }
        });



        Termuxbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level1.this, TermuxActivity.class));
            }
        });

        home_ue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ue_Level1.this, User_Enumeration.class));
            }
        });


        hint5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Ue_Level1.this, ActivityHint5.class));
            }
        });

        Readme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Ue_Level1.this, Ue_Readme1.class));
            }
        });


    }

    public void updateCoins()
    {
        coinsUe1.setText(Level_start.getCoins);
    }
}
