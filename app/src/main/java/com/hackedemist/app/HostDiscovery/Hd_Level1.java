package com.hackedemist.app.HostDiscovery;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.Challenges.Host_discovery;
import com.hackedemist.app.LevelCompleteAnimation;
import com.hackedemist.app.File_Based_Attacks.Fb_Hints.ActivityHint5;
import com.hackedemist.app.Level_next;
import com.hackedemist.app.Level_start;
import com.hackedemist.app.TermuxActivity;
import com.termux.R;

public class Hd_Level1 extends Activity {



    private LottieAnimationView submit;
    private EditText Domaintxt;
    private EditText Registrartxt;
    private EditText Iploctxt;
    private ImageButton Termuxbtn5;
    private LottieAnimationView hint5btn;
    private ImageButton next5btn;
    private ImageButton prev5Btn;
    private TextView coinsHd;
    private LottieAnimationView home_hd1;

    private TextView testView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hd_level1);

        //Coins
        SharedPreferences sharedPreferences = getSharedPreferences(Level_start.SHARED_PREFS,MODE_PRIVATE);



        submit=(LottieAnimationView) findViewById(R.id.level5btn);
        home_hd1=(LottieAnimationView)findViewById(R.id.home_hd1);
        Domaintxt=(EditText)findViewById(R.id.domaintxt);
        Registrartxt=(EditText)findViewById(R.id.Registrartxt);
        Iploctxt=(EditText)findViewById(R.id.iploctxt);
        Termuxbtn5=(ImageButton)findViewById(R.id.termux5Btn);
        hint5btn=(LottieAnimationView) findViewById(R.id.hint5Btn);
        next5btn=(ImageButton) findViewById(R.id.next5Btn);
        prev5Btn = (ImageButton) findViewById(R.id.prev5Btn);
        coinsHd = (TextView) findViewById(R.id.coinsHd1);
        testView = (TextView) findViewById(R.id.TestView2);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Hd_Level1.this);




        Level_start.loadCoins(sharedPreferences);
        updateCoins();

        prev5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level1.this,Level_next.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String domain,Registrar,Iploca;
                domain=Domaintxt.getText().toString();
                Registrar=Registrartxt.getText().toString();
                Iploca=Iploctxt.getText().toString();

                Boolean lock = prefs.getBoolean("coins1",false);

                testView.setText(Boolean.toString(lock));



                //domain.equalsIgnoreCase("www.hackedemist.com")&&Registrar.equalsIgnoreCase("BigRock Solutions Limited")&&Iploca.equalsIgnoreCase("United States")||domain.equalsIgnoreCase("www.hackedemist.com")&&Registrar.equalsIgnoreCase("BigRock")&&Iploca.equalsIgnoreCase("usa")||domain.equalsIgnoreCase("www.hackedemist.com")&&Registrar.equalsIgnoreCase("BigRock Solution")&&Iploca.equalsIgnoreCase("US")
                if(domain.equalsIgnoreCase("1")&&Registrar.equalsIgnoreCase("2")&&Iploca.equalsIgnoreCase("3")){
                    Toast.makeText(Hd_Level1.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();



                    if(!lock)
                    {
                        Level_start.levelCompleteCoins(sharedPreferences);
                        prefs.edit().putBoolean("coins1",true).apply();
                        testView.setText(Boolean.toString(lock));
                        updateCoins();
                    }


                    Thread complete =new Thread(){
                        @Override
                        public void run() {
                            try {
                                Intent i = new Intent(Hd_Level1.this, LevelCompleteAnimation.class);
                                startActivity(i);
                                sleep(3000);
                                i = new Intent(Hd_Level1.this,Hd_Level2.class);
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
                    Toast.makeText(Hd_Level1.this,"Oops!..Wrong Inputs Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });

        next5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level1.this, Hd_Level2.class));
            }
        });



        Termuxbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hd_Level1.this, TermuxActivity.class));
            }
        });


        hint5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level_start.levelHintCoins(sharedPreferences);
                updateCoins();
                startActivity(new Intent(Hd_Level1.this, ActivityHint5.class));
            }
        });
       home_hd1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Hd_Level1.this, Host_discovery.class));
           }
       });


    }

    public void updateCoins() {

        coinsHd.setText(Level_start.getCoins);
    }

}
