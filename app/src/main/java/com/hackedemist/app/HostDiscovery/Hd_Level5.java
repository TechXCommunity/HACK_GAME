package com.hackedemist.app.HostDiscovery;

import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint4;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Hd_Level5 extends Activity {
    private ImageButton next4Btn;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private LottieAnimationView submit;
    private ImageButton termux;
    private LottieAnimationView hint4Btn;
    private ImageButton prev4Btn;
    private TextView coinsHd5;
    private LottieAnimationView home_hd5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level5);


        next4Btn=(ImageButton) findViewById(R.id.next4Btn);
        home_hd5=(LottieAnimationView)findViewById(R.id.home_hd5);

        submit = (LottieAnimationView) findViewById(R.id.submit4Btn);

        cb1= (CheckBox) findViewById(R.id.checkBox1);

        cb2= (CheckBox) findViewById(R.id.checkBox2);

        cb3= (CheckBox) findViewById(R.id.checkBox3);

        cb4= (CheckBox) findViewById(R.id.checkBox4);

        termux = (ImageButton) findViewById(R.id.termux4Btn);

        hint4Btn = (LottieAnimationView) findViewById(R.id.hint4Btn);

        prev4Btn = (ImageButton) findViewById(R.id.prev4Btn);

        coinsHd5 = (TextView) findViewById(R.id.coinsHd5);

        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level5.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();



        prev4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level5.this, Hd_Level4.class));
            }
        });

        hint4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Hd_Level5.this, ActivityHint4.class));
            }
        });


        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level5.this, TermuxActivity.class));
            }
        });

        next4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level5.this, Hd_Level6.class));
            }
        });

        home_hd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hd_Level5.this, File_Based_Attacks.class));
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean lock = prefs.getBoolean("coinsHd5",false);

                if (cb1.isChecked() && !(cb2.isChecked()) && cb3.isChecked() && !(cb4.isChecked())) {

                        Toast.makeText(Hd_Level5.this, "Host_discovery Completed ", Toast.LENGTH_LONG).show();

                        if (!lock)
                        {
                            Level_start.levelCompleteCoins(sharedPreferences);
                            prefs.edit().putBoolean("coinsHd5",true).apply();
                            updateCoins();
                        }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level5.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level5.this,Hd_Level6.class);
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
                    else{
                        Level_start.levelFailedCoins(sharedPreferences);
                        updateCoins();
                    Toast.makeText(Hd_Level5.this, "Oops!..Incorrect Options", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void updateCoins()
    {
        coinsHd5.setText(Level_start.getCoins);
    }
}
