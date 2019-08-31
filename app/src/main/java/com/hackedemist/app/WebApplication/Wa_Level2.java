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
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.hackedemist.app.WebApplication.Hints.ActivityHint7;
import com.termux.R;

public class Wa_Level2 extends Activity {

    private LottieAnimationView submit;
    private Button openWebsite;
    private ImageButton termux7Btn;
    private LottieAnimationView hint7Btn;
    private EditText password;
    private ImageButton next7Btn;
    private ImageButton prev7Btn;
    private TextView coinsWa2;
    private LottieAnimationView home_wa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wa__level2);

        submit = (LottieAnimationView) findViewById(R.id.wa_submit2Btn);
        openWebsite = (Button) findViewById(R.id.wa_website2Btn);
        termux7Btn = (ImageButton) findViewById(R.id.wa_termux2Btn);
        hint7Btn = (LottieAnimationView) findViewById(R.id.wa_hint2Btn);
        password = (EditText) findViewById(R.id.wa_pass2);
        next7Btn = (ImageButton) findViewById(R.id.wa_next2Btn);
        prev7Btn = (ImageButton) findViewById(R.id.wa_prev2Btn);
        coinsWa2 = (TextView) findViewById(R.id.coinViewWa2);
        home_wa2=(LottieAnimationView) findViewById(R.id.home_wa2);
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Wa_Level2.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean lock = prefs.getBoolean("coinsWa2",false);

                if(password.getText().toString().equals("john12Ab"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsWa2",true).apply();
                    }

                    Toast.makeText(Wa_Level2.this,"Level Completed ",Toast.LENGTH_LONG).show();
                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Wa_Level2.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                 i = new Intent(Wa_Level2.this,Wa_Level3.class);
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
                    Toast.makeText(Wa_Level2.this,"Oops!..Incorrect Password",Toast.LENGTH_LONG).show();
                }
            }
        });

        openWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level2.this, Level2WebView.class));
            }
        });

        home_wa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wa_Level2.this, Web_Application.class));
            }
        });

        termux7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level2.this, TermuxActivity.class));
            }
        });

        hint7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Wa_Level2.this, ActivityHint7.class));
            }
        });

        next7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Wa_Level2.this,Wa_Level3.class));
            }
        });


        prev7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wa_Level2.this, Wa_Level1.class));
            }
        });

    }


    public void updateCoins()
    {
        coinsWa2.setText(Level_start.getCoins);
    }

}
