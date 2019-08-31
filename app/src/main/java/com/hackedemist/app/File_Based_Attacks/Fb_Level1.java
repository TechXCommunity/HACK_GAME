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
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme1;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Fb_Level1 extends Activity {

    private ImageButton termux;
    private LottieAnimationView hint10btn;
    private ImageButton prev10Btn;
    private ImageButton next10Btn;
    private LottieAnimationView submit10btn;
    private TextView coinsFb1;
    private EditText ans1;
    private TextView Readme1;
    private LottieAnimationView home_fb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb__level1);




        termux = (ImageButton) findViewById(R.id.fb_termux);

        home_fb1=(LottieAnimationView)findViewById(R.id.home_fb1);


        submit10btn=(LottieAnimationView) findViewById(R.id.fb_submit1);

        prev10Btn = (ImageButton) findViewById(R.id.fb_prev1);

        next10Btn = (ImageButton) findViewById(R.id.fb_next1);

        hint10btn=(LottieAnimationView)findViewById(R.id.fb_hint);

        coinsFb1 = (TextView) findViewById(R.id.coinViewFb1);

        ans1 = (EditText) findViewById(R.id.fb_text);

        Readme1=(TextView)findViewById(R.id.fb_readme1);

        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Fb_Level1.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        submit10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ans = ans1.getText().toString();

                Boolean lock = prefs.getBoolean("coinsFb1",false);

                if (ans.equalsIgnoreCase("1"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsFb1",true).apply();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Fb_Level1.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Fb_Level1.this,Fb_Level2.class);
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
                //
            }
        });

        next10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level1.this, Fb_Level2.class));
            }
        });


        prev10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level1.this, Level_next.class));
            }
        });



        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level1.this, TermuxActivity.class));
            }
        });
        hint10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level1.this, ActivityHint10.class));
            }
        });

        Readme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fb_Level1.this, Fb_Readme1.class));
            }
        });

        home_fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fb_Level1.this, File_Based_Attacks.class));
            }
        });
    }


    public void updateCoins()
    {
        coinsFb1.setText(Level_start.getCoins);
    }

}
