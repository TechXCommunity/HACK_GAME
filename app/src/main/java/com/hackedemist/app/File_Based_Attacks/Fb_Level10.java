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
import com.hackedemist.app.ActivityLevel11;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme10;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme4;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Fb_Level10 extends Activity {

    private ImageButton termux;
    private LottieAnimationView hint10btn;
    private ImageButton prev10Btn;
    private ImageButton next10Btn;
    private LottieAnimationView submit10btn;
    private TextView coinsFb10;
    private EditText ansFb10;
    private TextView Readme10;
    private LottieAnimationView home_fb10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb__level10);




        termux = (ImageButton) findViewById(R.id.fb_termux10);

        home_fb10=(LottieAnimationView)findViewById(R.id.home_fb10);

        Readme10=(TextView)findViewById(R.id.fb_readme10);


        submit10btn=(LottieAnimationView) findViewById(R.id.fb_submit10);

        prev10Btn = (ImageButton) findViewById(R.id.fb_prev10);

        next10Btn = (ImageButton) findViewById(R.id.fb_next10);

        hint10btn=(LottieAnimationView)findViewById(R.id.fb_hint10);

        coinsFb10 = (TextView) findViewById(R.id.coinViewFb10) ;

        ansFb10 = (EditText) findViewById(R.id.fb_text10);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Fb_Level10.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        submit10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //

                String ans1 = ansFb10.getText().toString();

                Boolean lock = prefs.getBoolean("coinsFb10",false);

                if (ans1.equalsIgnoreCase("1"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsFb10",true).apply();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Fb_Level10.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Fb_Level10.this,Level_next.class);
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
                startActivity(new Intent(Fb_Level10.this, Level_next.class));
            }
        });


        prev10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level10.this, Fb_Level9.class));
            }
        });



        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level10.this, TermuxActivity.class));
            }
        });
        hint10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level10.this, ActivityHint10.class));
            }
        });

        Readme10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level10.this, Fb_Readme10.class));
            }
        });
        home_fb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fb_Level10.this, File_Based_Attacks.class));
            }
        });
    }
    public void updateCoins()
    {
        coinsFb10.setText(Level_start.getCoins);
    }
}
