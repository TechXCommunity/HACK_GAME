package com.hackedemist.app.HostDiscovery;


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
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint6;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Hd_Level6 extends Activity {

    private ImageButton termux;
    private LottieAnimationView submit;
    private EditText no_ip;
    private EditText no_subdomain;
    private LottieAnimationView hint6btn;
    private ImageButton prev6Btn;
    private ImageButton next6Btn;
    private TextView coinsHd6;
    private LottieAnimationView home_hd6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level6);


        submit = (LottieAnimationView) findViewById(R.id.level6Btn);

        home_hd6=(LottieAnimationView)findViewById(R.id.home_hd6);

        no_ip = (EditText) findViewById(R.id.no_ips);

        no_subdomain = (EditText) findViewById(R.id.no_subdomain);

        termux = (ImageButton) findViewById(R.id.termux6Btn);

        prev6Btn = (ImageButton) findViewById(R.id.prev6Btn);

        next6Btn = (ImageButton) findViewById(R.id.next6Btn);

        hint6btn=(LottieAnimationView) findViewById(R.id.hint6Btn);

        coinsHd6 = (TextView) findViewById(R.id.coinsHd6);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS, MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level6.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();

        next6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level6.this, Hd_Level7.class));
            }
        });


        prev6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level6.this, Hd_Level5.class));
            }
        });

        home_hd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hd_Level6.this, File_Based_Attacks.class));
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ip=no_ip.getText().toString();
                String subdomains=no_subdomain.getText().toString();

                Boolean lock = prefs.getBoolean("coinsHd6",false);

                if(ip.equals("25")&&subdomains.equals("9")){
                    Toast.makeText(Hd_Level6.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsHd6",true).apply();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level6.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level6.this,Hd_Level7.class);
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
                    Toast.makeText(Hd_Level6.this,"Oops!..Incorrect Values",Toast.LENGTH_LONG).show();

                    Level_start.levelFailedCoins(sharedPreferences);
                    updateCoins();
                }
            }


        });


        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level6.this, TermuxActivity.class));
            }
        });
        hint6btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Hd_Level6.this, ActivityHint6.class));
            }
        });


            }

            public  void updateCoins()
            {
                coinsHd6.setText(Level_start.getCoins);
            }
        }
