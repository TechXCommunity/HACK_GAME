package com.hackedemist.app.HostDiscovery;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.Challenges.Host_discovery;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint2;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

import java.io.File;

public class Hd_Level3 extends Activity {

    private ImageButton termux1Btn;
    private LottieAnimationView hint2Btn;
    private LottieAnimationView submit2Btn;
    private EditText osTxt;
    private ImageButton next2Btn;
    private ImageButton prev2Btn;
    private TextView coinsHd3;
    private LottieAnimationView home_hd3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level3);

        //Coins
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        termux1Btn = (ImageButton) findViewById(R.id.termux1Btn);
        osTxt = (EditText) findViewById(R.id.osTxt);
        submit2Btn=(LottieAnimationView) findViewById(R.id.submit2Btn);
        next2Btn=(ImageButton) findViewById(R.id.next2Btn);
        hint2Btn = (LottieAnimationView) findViewById(R.id.hint2Btn);
        prev2Btn = (ImageButton) findViewById(R.id.prev2Btn);
        coinsHd3 = (TextView) findViewById(R.id.coinsHd3);
        home_hd3=(LottieAnimationView)findViewById(R.id.home_hd3);


        //SharedPrefs
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level3.this);


        Level_start.loadCoins(sharedPreferences);
        updateCoins();

        hint2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Hd_Level3.this, ActivityHint2.class));
            }
        });


        prev2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level3.this, Hd_Level2.class));
            }
        });

        next2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level3.this, Hd_Level4.class));
            }
        });



        submit2Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String os;
                os=osTxt.getText().toString();

                Boolean lock = prefs.getBoolean("coinsHd3",false);


                if(os.equalsIgnoreCase("linux"))
                {
                    Toast.makeText(Hd_Level3.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        prefs.edit().putBoolean("coinsHd3",true).apply();
                        updateCoins();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level3.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level3.this,Hd_Level4.class);
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
                    Toast.makeText(Hd_Level3.this,"Oops!...Incorrect OS",Toast.LENGTH_LONG).show();

                }


            }
        });

        termux1Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Hd_Level3.this, TermuxActivity.class));
            }
        });

        home_hd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hd_Level3.this, File_Based_Attacks.class));
            }
        });




    }

    public void updateCoins()
    {
        coinsHd3.setText(Level_start.getCoins);
    }
}
