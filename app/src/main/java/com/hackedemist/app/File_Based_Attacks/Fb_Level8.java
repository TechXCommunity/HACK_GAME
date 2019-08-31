package com.hackedemist.app.File_Based_Attacks;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.ActivityHint10;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme4;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme8;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Fb_Level8 extends Activity {

    private ImageButton termux;
    private LottieAnimationView hint10btn;
    private ImageButton prev10Btn;
    private ImageButton next10Btn;
    private LottieAnimationView submit10btn;
    private TextView coinsFb8;
    private EditText ansFb8;
    private TextView Readme8;
    private LottieAnimationView home_fb8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb__level8);




        termux = (ImageButton) findViewById(R.id.fb_termux8);

        Readme8=(TextView)findViewById(R.id.fb_readme8);

        home_fb8=(LottieAnimationView)findViewById(R.id.home_fb8);




        submit10btn=(LottieAnimationView) findViewById(R.id.fb_submit8);

        prev10Btn = (ImageButton) findViewById(R.id.fb_prev8);

        next10Btn = (ImageButton) findViewById(R.id.fb_next8);

        hint10btn=(LottieAnimationView)findViewById(R.id.fb_hint8);

        coinsFb8 = (TextView) findViewById(R.id.coinViewFb8) ;

        ansFb8 = (EditText) findViewById(R.id.fb_text8);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Fb_Level8.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        submit10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                String ans1 = ansFb8.getText().toString();

                Boolean lock = prefs.getBoolean("coinsFb8",false);

                if (ans1.equalsIgnoreCase("1"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsFb8",true).apply();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Fb_Level8.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Fb_Level8.this,Fb_Level9.class);
                                startActivity(i);
                            }
                            catch(InterruptedException e)
                            {
                                e.printStackTrace();

                            }
                        }
                    };

                    complete.start();

                }
                else
                {
                    Level_start.levelFailedCoins(sharedPreferences);
                    updateCoins();
                }
            }
        });

        next10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level8.this, Fb_Level9.class));
            }
        });


        prev10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level8.this, Fb_Level7.class));
            }
        });
        home_fb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fb_Level8.this, File_Based_Attacks.class));
            }
        });



        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level8.this, TermuxActivity.class));
            }
        });
        hint10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level8.this, ActivityHint10.class));
            }
        });
        Readme8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level8.this, Fb_Readme8.class));
            }
        });

    }
    public void updateCoins()
    {
        coinsFb8.setText(Level_start.getCoins);
    }
}
