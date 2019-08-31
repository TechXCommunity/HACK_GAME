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
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint9;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.hackedemist.app.UserEnumeration.Ue_Level1;
import com.termux.R;

public class Hd_Level7 extends Activity {

    private ImageButton termux9Btn;
    private LottieAnimationView hint9Btn;
    private EditText MailServer;
    private ImageButton next9Btn;
    private ImageButton prev9Btn;
    private LottieAnimationView Level9btn;
    private TextView coinsHd7;
    private LottieAnimationView home_hd7;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level7);


        termux9Btn = (ImageButton) findViewById(R.id.termux9Btn);
        home_hd7=(LottieAnimationView)findViewById(R.id.home_hd7);
        hint9Btn = (LottieAnimationView) findViewById(R.id.hint9Btn);
        MailServer = (EditText) findViewById(R.id.MailServer);
        next9Btn = (ImageButton) findViewById(R.id.next9Btn);
        prev9Btn=(ImageButton) findViewById(R.id.prev9Btn);
        Level9btn=(LottieAnimationView) findViewById(R.id.level9btn);
        coinsHd7 = (TextView) findViewById(R.id.coinsHd7);


        //SharedPrefs

        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level7.this);


        Level_start.loadCoins(sharedPreferences);
        updateCoins();





        Level9btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean lock = prefs.getBoolean("coinsHd7",false);

                if(MailServer.getText().toString().equals("3"))
                {
                    Toast.makeText(Hd_Level7.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();

                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        prefs.edit().putBoolean("coinsHd7",true).apply();
                        updateCoins();
                    }

                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level7.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level7.this,Level_next.class);
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
                    Toast.makeText(Hd_Level7.this,"Oops!..Incorrect ",Toast.LENGTH_LONG).show();
                }
            }
        });

        home_hd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hd_Level7.this, File_Based_Attacks.class));
            }
        });



        termux9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level7.this, TermuxActivity.class));
            }
        });

        hint9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                Intent i=new Intent(getApplicationContext(), ActivityHint9.class);
                startActivity(i);
            }
        });

        next9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level7.this, Ue_Level1.class));
            }
        });


        prev9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level7.this, Host_discovery.class));
            }
        });

    }

    public void updateCoins()
    {
        coinsHd7.setText(Level_start.getCoins);
    }
}
