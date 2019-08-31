package com.hackedemist.app.WebApplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.Challenges.Web_Application;
import com.hackedemist.app.HostDiscovery.Hd_Level2;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.WebApplication.Hints.ActivityHint7;
import com.hackedemist.app.ActivityLevel8;
import com.hackedemist.app.HostDiscovery.Hd_Level6;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

import java.util.logging.SocketHandler;

public class Wa_Level1 extends Activity {


    private LottieAnimationView submit;
    private Button openWebsite;
    private ImageButton termux7Btn;
    private LottieAnimationView hint7Btn;
    private EditText password;
    private ImageButton next7Btn;
    private ImageButton prev7Btn;
    private TextView coinsWa1;
    private LottieAnimationView home_wa1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wa_level1);

        submit = (LottieAnimationView) findViewById(R.id.submit7Btn);
        home_wa1=(LottieAnimationView) findViewById(R.id.home_wa1);
        openWebsite = (Button) findViewById(R.id.website7Btn);
        termux7Btn = (ImageButton) findViewById(R.id.termux7Btn);
        hint7Btn = (LottieAnimationView) findViewById(R.id.hint7Btn);
        password = (EditText) findViewById(R.id.pass7Txt);
        next7Btn = (ImageButton) findViewById(R.id.next7Btn);
        prev7Btn = (ImageButton) findViewById(R.id.prev7Btn);
        coinsWa1 = (TextView) findViewById(R.id.coinViewWa1);

        //SharedPrefs

        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Wa_Level1.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean lock = prefs.getBoolean("coinsWa1",false);

                if(password.getText().toString().equals("als!2js0"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsWa1",true).apply();
                    }

                    Toast.makeText(Wa_Level1.this,"Level Completed ",Toast.LENGTH_LONG).show();


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Wa_Level1.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Wa_Level1.this,Wa_Level2.class);
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


                else {
                    Level_start.levelFailedCoins(sharedPreferences);
                    updateCoins();
                    Toast.makeText(Wa_Level1.this,"Oops!..Incorrect Password",Toast.LENGTH_LONG).show();
                }
            }
        });

        openWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level1.this, Level1WebView.class));
            }
        });

        termux7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level1.this, TermuxActivity.class));
            }
        });

        home_wa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wa_Level1.this, Web_Application.class));
            }
        });


        hint7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Wa_Level1.this, ActivityHint7.class));
            }
        });

        next7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level1.this,Wa_Level2.class));
            }
        });


        prev7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level1.this, Level_next.class));
            }
        });

    }

    public void updateCoins()
    {
        coinsWa1.setText(Level_start.getCoins);
    }

}
