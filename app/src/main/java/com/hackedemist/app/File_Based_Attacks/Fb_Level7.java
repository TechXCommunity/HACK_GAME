package com.hackedemist.app.File_Based_Attacks;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.ActivityHint10;
import com.hackedemist.app.ActivityLevel11;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme4;
import com.hackedemist.app.File_Based_Attacks.Fb_Readem.Fb_Readme7;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

import org.w3c.dom.Text;

public class Fb_Level7 extends Activity {

    private ImageButton termux;
    private LottieAnimationView hint10btn;
    private ImageButton prev10Btn;
    private ImageButton next10Btn;
    private LottieAnimationView submit10btn;
    private EditText ansFb7;
    private TextView coinsFb7;
    private TextView Readme7;
    private LottieAnimationView home_fb7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb__level7);




        termux = (ImageButton) findViewById(R.id.fb_termux7);



        home_fb7=(LottieAnimationView)findViewById(R.id.home_fb7);


        submit10btn=(LottieAnimationView) findViewById(R.id.fb_submit7);

        prev10Btn = (ImageButton) findViewById(R.id.fb_prev7);

        next10Btn = (ImageButton) findViewById(R.id.fb_next7);

        hint10btn=(LottieAnimationView)findViewById(R.id.fb_hint7);

        coinsFb7 = (TextView) findViewById(R.id.coinViewFb7) ;

        ansFb7 = (EditText) findViewById(R.id.fb_text7);


        //SharedPrefs
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Fb_Level7.this);
        Level_start.loadCoins(sharedPreferences);
        updateCoins();

        submit10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                String ans1 = ansFb7.getText().toString();

                Boolean lock = prefs.getBoolean("coinsFb7",false);

                if (ans1.equalsIgnoreCase("1"))
                {
                    if (!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        updateCoins();
                        prefs.edit().putBoolean("coinsFb7",true).apply();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Fb_Level7.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Fb_Level7.this,Fb_Level8.class);
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
                else
                {
                    Level_start.levelFailedCoins(sharedPreferences);
                    updateCoins();
                }
            }
        });

        next10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level7.this, Fb_Level8.class));
            }
        });


        prev10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level7.this, Fb_Level6.class));
            }
        });



        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fb_Level7.this, TermuxActivity.class));
            }
        });
        hint10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Fb_Level7.this, ActivityHint10.class));
            }
        });

        home_fb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fb_Level7.this, File_Based_Attacks.class));
            }
        });
Readme7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(Fb_Level7.this, Fb_Readme7.class));
    }
});
    }
    public void updateCoins()
    {
        coinsFb7.setText(Level_start.getCoins);
    }
}
