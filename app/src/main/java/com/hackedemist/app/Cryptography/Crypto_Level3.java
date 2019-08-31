package com.hackedemist.app.Cryptography;

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
import com.hackedemist.app.Challenges.Cryptography;
import com.hackedemist.app.Cryptography.Crypto_hints.Crypto_Hints3;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.hackedemist.app.UserEnumeration.Ue_Readme.Ue_Readme1;
import com.termux.R;

public class Crypto_Level3 extends Activity {



private LottieAnimationView submit;
    private EditText cr_pass;
    private ImageButton Termuxbtn5;
    private LottieAnimationView hint5btn;
    private ImageButton crNext1Btn;
    private ImageButton prev5Btn;
    private LottieAnimationView home_cr3;
    private TextView coinsUe1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto__level3);

        submit=(LottieAnimationView) findViewById(R.id.cr_sub3btn);
        cr_pass=(EditText)findViewById(R.id.cr_txt3);
        Termuxbtn5=(ImageButton)findViewById(R.id.cr_termux3btn);
        hint5btn=(LottieAnimationView) findViewById(R.id.cr_hint3btn);
        crNext1Btn=(ImageButton) findViewById(R.id.cr_next3Btn);
        prev5Btn = (ImageButton) findViewById(R.id.cr_prev3Btn);
        home_cr3=(LottieAnimationView) findViewById(R.id.home_cr3);

        coinsUe1 = (TextView) findViewById(R.id.coinViewcr3) ;



        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Crypto_Level3.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        prev5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Crypto_Level3.this,Crypto_Level2.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users;
                users=cr_pass.getText().toString();

                Boolean lock = prefs.getBoolean("coinsCr3",false);

                if(users.equalsIgnoreCase("1")){
                    Toast.makeText(Crypto_Level3.this,"Level Completed",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsCr3",true).apply();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Crypto_Level3.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Crypto_Level3.this, Crypto_Level4.class);
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
                    Toast.makeText(Crypto_Level3.this,"Oops!..Wrong Password Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });

        crNext1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Crypto_Level3.this, Crypto_Level4.class));
            }
        });

        home_cr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Crypto_Level3.this, Cryptography.class));
            }
        });



        Termuxbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Crypto_Level3.this, TermuxActivity.class));
            }
        });


        hint5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Crypto_Level3.this, Crypto_Hints3.class));
            }
        });



    }

    public void updateCoins()
    {
        coinsUe1.setText(Level_start.getCoins);
    }
}
