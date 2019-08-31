package com.hackedemist.app.HostDiscovery;

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
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.Challenges.Host_discovery;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint1;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Hd_Level2 extends Activity {

    private ImageButton termuxBtn;
    private LottieAnimationView hintBtn;
    private LottieAnimationView level1btn;
    private EditText iptxt;
    private ImageButton next1Btn;
    private ImageButton prev1Btn;
    private TextView coinsHd2;
    private LottieAnimationView home_hd2;

    private TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level2);

        //Coins
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);


        termuxBtn = (ImageButton) findViewById(R.id.termuxBtn);
        iptxt=(EditText)findViewById(R.id.iptxt);
        level1btn=(LottieAnimationView) findViewById(R.id.level1btn);
        next1Btn=(ImageButton) findViewById(R.id.next1Btn);
        hintBtn = (LottieAnimationView) findViewById(R.id.hint1Btn);
        prev1Btn = (ImageButton) findViewById(R.id.prev1Btn);
        coinsHd2 = (TextView) findViewById(R.id.coinsHd2);
        home_hd2=(LottieAnimationView)findViewById(R.id.home_hd2);

        test = (TextView) findViewById(R.id.TestView);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level2.this);


        Level_start.loadCoins(sharedPreferences);
        updateCoins();


        level1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip;
                ip=iptxt.getText().toString();

                Boolean lock = prefs.getBoolean("coins2",false);

                test.setText(Boolean.toString(lock));


                if(ip.equals("192.185.129.21")){

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        prefs.edit().putBoolean("coins2",true).apply();
                        test.setText(Boolean.toString(lock));
                        updateCoins();
                    }



                    Toast.makeText(Hd_Level2.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();
                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level2.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level2.this,Hd_Level3.class);
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
                    Toast.makeText(Hd_Level2.this,"Oops!...IP incorrect",Toast.LENGTH_LONG).show();

                }


            }
        });


        prev1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level2.this, Hd_Level1.class));
            }
        });

        next1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level2.this, Hd_Level3.class));
            }
        });

        termuxBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level2.this, TermuxActivity.class));
            }
        });




        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Hd_Level2.this, ActivityHint1.class));
            }
        });

        home_hd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hd_Level2.this, File_Based_Attacks.class));
            }
        });


    }

    public void updateCoins(){

        coinsHd2.setText(Level_start.getCoins);
    }
    }

