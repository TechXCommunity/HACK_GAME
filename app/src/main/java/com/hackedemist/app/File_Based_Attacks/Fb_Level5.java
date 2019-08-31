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
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme4;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme5;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Fb_Level5 extends Activity {

    private ImageButton termux;
    private LottieAnimationView hint10btn;
    private ImageButton prev10Btn;
    private ImageButton next10Btn;
    private LottieAnimationView submit10btn;
    private EditText ansFb5;
    private TextView coinsFb5;
    private TextView Readme5;
    private LottieAnimationView home_fb5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb__level5);




        termux = (ImageButton) findViewById(R.id.fb_termux5);

        Readme5=(TextView)findViewById(R.id.fb_readme5);

        home_fb5=(LottieAnimationView)findViewById(R.id.home_fb5);

        submit10btn=(LottieAnimationView) findViewById(R.id.fb_submit5);

        prev10Btn = (ImageButton) findViewById(R.id.fb_prev5);

        next10Btn = (ImageButton) findViewById(R.id.fb_next5);

        hint10btn=(LottieAnimationView)findViewById(R.id.fb_hint5);

        coinsFb5 = (TextView) findViewById(R.id.coinViewFb5) ;

        ansFb5 = (EditText) findViewById(R.id.fb_text5);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Fb_Level5.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        submit10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                String ans1 = ansFb5.getText().toString();

                Boolean lock = prefs.getBoolean("coinsFb5",false);

                if (ans1.equalsIgnoreCase("1"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsFb5",true).apply();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Fb_Level5.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Fb_Level5.this,Fb_Level6.class);
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
                startActivity(new Intent(Fb_Level5.this, Fb_Level6.class));
            }
        });


        prev10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level5.this, Fb_Level4.class));
            }
        });



        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level5.this, TermuxActivity.class));
            }
        });
        hint10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level5.this, ActivityHint10.class));
            }
        });

        Readme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level5.this, Fb_Readme5.class));
            }
        });

        home_fb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fb_Level5.this, File_Based_Attacks.class));
            }
        });

    }
    public void updateCoins()
    {
        coinsFb5.setText(Level_start.getCoins);
    }
}
