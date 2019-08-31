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
import com.hackedemist.app.Challenges.Host_discovery;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint3;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

import java.io.File;

public class Hd_Level4 extends Activity {

    private ImageButton termuxbtn3;
    private LottieAnimationView submit3Btn;
    private EditText porttxt;
    private LottieAnimationView hint3btn;
    private ImageButton next3Btn;
    private ImageButton prev3Btn;
    private TextView coinsHd4;
    private LottieAnimationView home_hd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level4);

        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        termuxbtn3 = (ImageButton) findViewById(R.id.termux3Btn);
        submit3Btn=(LottieAnimationView) findViewById(R.id.submit3Btn);
        porttxt=(EditText)findViewById(R.id.porttxt);
        hint3btn=(LottieAnimationView) findViewById(R.id.hint3Btn);
        next3Btn=(ImageButton) findViewById(R.id.next3Btn);
        prev3Btn = (ImageButton) findViewById(R.id.prev3Btn);
        coinsHd4 = (TextView) findViewById(R.id.coinsHd4);
        home_hd4=(LottieAnimationView)findViewById(R.id.home_hd4);


        //SharedPrefs
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level4.this);


        Level_start.loadCoins(sharedPreferences);
        updateCoins();



        prev3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level4.this, Hd_Level3.class));
            }
        });

        submit3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String port;
                port=porttxt.getText().toString();

                Boolean lock = prefs.getBoolean("coinsHd4",false);


                if(port.equals("21")){
                    Toast.makeText(Hd_Level4.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        prefs.edit().putBoolean("coinsHd4",true).apply();
                        updateCoins();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level4.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level4.this,Hd_Level5.class);
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
                    Toast.makeText(Hd_Level4.this,"Oops!..Port incorrect",Toast.LENGTH_LONG).show();

                }


            }
        });

        termuxbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level4.this, TermuxActivity.class));
            }
        });


        hint3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Hd_Level4.this, ActivityHint3.class));
            }
        });

        next3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level4.this, Hd_Level5.class));
            }
        });

        home_hd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hd_Level4.this, File_Based_Attacks.class));
            }
        });




    }

    public void updateCoins()
    {
        coinsHd4.setText(Level_start.getCoins);
    }
}
