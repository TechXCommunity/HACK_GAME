package com.hackedemist.app.Cryptography;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Challenges.Cryptography;
import com.hackedemist.app.Cryptography.Crypto_hints.Crypto_hints2;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.hackedemist.app.UserEnumeration.Ue_Readme.Ue_Readme1;
import com.termux.R;

    public class Crypto_Level2 extends Activity {


    private LottieAnimationView submit;
    private EditText cr_pass;
    private ImageButton Termuxbtn5;
    private LottieAnimationView hint5btn;
    private ImageButton crNext1Btn;
    private ImageButton prev5Btn;
    private TextView coinsUe1;
    private LottieAnimationView home_cr2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto__level2);

        submit=(LottieAnimationView) findViewById(R.id.cr_sub2btn);
        cr_pass=(EditText)findViewById(R.id.cr_txt2);
        Termuxbtn5=(ImageButton)findViewById(R.id.cr_termux2btn);
        hint5btn=(LottieAnimationView) findViewById(R.id.cr_hint2btn);
        crNext1Btn=(ImageButton) findViewById(R.id.cr_next2Btn);
        prev5Btn = (ImageButton) findViewById(R.id.cr_prev2Btn);

        coinsUe1 = (TextView) findViewById(R.id.coinViewcr2) ;

        home_cr2=(LottieAnimationView)findViewById(R.id.home_cr2);



        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Crypto_Level2.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        prev5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Crypto_Level2.this,Crypto_Level1.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users;
                users=cr_pass.getText().toString();

                Boolean lock = prefs.getBoolean("coinsCr2",false);

                if(users.equalsIgnoreCase("1")){
                    Toast.makeText(Crypto_Level2.this,"Level Completed",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsCr2",true).apply();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Crypto_Level2.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Crypto_Level2.this, Crypto_Level3.class);
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
                    Toast.makeText(Crypto_Level2.this,"Oops!..Wrong Password Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });

        crNext1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Crypto_Level2.this, Crypto_Level3.class));
            }
        });



        Termuxbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Crypto_Level2.this, TermuxActivity.class));
            }
        });


        hint5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Crypto_Level2.this, Crypto_hints2.class));
            }
        });

        home_cr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Crypto_Level2.this, Cryptography.class));
            }
        });



    }

    public void updateCoins()
    {
        coinsUe1.setText(Level_start.getCoins);
    }


}
