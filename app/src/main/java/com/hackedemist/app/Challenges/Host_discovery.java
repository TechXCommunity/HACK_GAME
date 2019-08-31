package com.hackedemist.app.Challenges;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.hackedemist.app.HostDiscovery.Hd_Level2;
import com.hackedemist.app.HostDiscovery.Hd_Level3;
import com.hackedemist.app.HostDiscovery.Hd_Level5;
import com.hackedemist.app.HostDiscovery.Hd_Level1;
import com.hackedemist.app.HostDiscovery.Hd_Level6;
import com.hackedemist.app.HostDiscovery.Hd_Level7;
import com.hackedemist.app.HostDiscovery.Hd_Level4;
import com.hackedemist.app.Level_start;
import com.termux.R;

public class Host_discovery extends Activity {


    private ImageButton hd1;
    private ImageButton hd2;
    private ImageButton hd3;
    private ImageButton hd4;
    private ImageButton hd5;
    private ImageButton hd6;
    private ImageButton hd7;
    private LottieAnimationView home_hd;

    private Boolean lock2;
    private Boolean lock3;
    private Boolean lock4;
    private Boolean lock5;
    private Boolean lock6;
    private Boolean lock7;

    private long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_discovery);


        //test for imageView
        //hd1.setImageResource(R.drawable.four);
        //////
        hd1= (ImageButton) findViewById(R.id.hd1);
        hd2= (ImageButton) findViewById(R.id.hd2);
        hd3= (ImageButton) findViewById(R.id.hd3);
        hd4= (ImageButton) findViewById(R.id.hd4);
        hd5= (ImageButton) findViewById(R.id.hd5);
        hd6= (ImageButton) findViewById(R.id.hd6);
        hd7= (ImageButton) findViewById(R.id.hd7);
        home_hd=(LottieAnimationView) findViewById(R.id.home_hd);




        //lock mechanism
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Host_discovery.this);

         lock2 = prefs.getBoolean("coins1",false);
         lock3 = prefs.getBoolean("coins2",false);
         lock4 = prefs.getBoolean("coinsHd3",false);
         lock5 = prefs.getBoolean("coinsHd4",false);
         lock6 = prefs.getBoolean("coinsHd5",false);
         lock7 = prefs.getBoolean("coinsHd6",false);

        updateLocks();



        hd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Host_discovery.this, Hd_Level1.class));
            }
        });




        hd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!lock2)
                    Toast.makeText(Host_discovery.this,"Level 2 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Host_discovery.this, Hd_Level2.class));
                }

            }
        });



        hd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!lock3)
                    Toast.makeText(Host_discovery.this,"Level 3 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Host_discovery.this, Hd_Level3.class));
                }            }
        });



        hd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!lock4)
                    Toast.makeText(Host_discovery.this,"Level 4 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Host_discovery.this, Hd_Level4.class));
                }            }
        });




        hd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!lock5)
                    Toast.makeText(Host_discovery.this,"Level 5 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Host_discovery.this, Hd_Level5.class));
                }            }
        });

        home_hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Host_discovery.this, Level_start.class));
            }
        });



        hd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!lock6)
                    Toast.makeText(Host_discovery.this,"Level 6 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Host_discovery.this, Hd_Level6.class));
                }            }
        });




        hd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!lock7)
                    Toast.makeText(Host_discovery.this,"Level 7 Locked",Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(Host_discovery.this, Hd_Level7.class));
                }            }
        });





    }

    public void updateLocks()
    {


        //checking for lock for setting up the lock images
        if(!lock2)
        {
            hd2.setImageResource(R.drawable.lock);
        }

        if(!lock3)
        {
            hd3.setImageResource(R.drawable.lock);
        }

        if(!lock4)
        {
            hd4.setImageResource(R.drawable.lock);
        }

        if(!lock5)
        {
            hd5.setImageResource(R.drawable.lock);
        }

        if(!lock6)
        {
            hd6.setImageResource(R.drawable.lock);
        }

        if(!lock7)
        {
            hd7.setImageResource(R.drawable.lock);
        }
    }

    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()){
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
        else{
            Toast.makeText(getBaseContext(),
                "Press once again to exit!", Toast.LENGTH_SHORT)
                .show();
        }

        back_pressed = System.currentTimeMillis();


    }
}
