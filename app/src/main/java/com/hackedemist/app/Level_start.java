package com.hackedemist.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hackedemist.app.Practicals.Practicals;
import com.termux.R;

public class Level_start extends Activity {
    private long back_pressed;
    private Button challengebtn;
    private Button practibtn;

    //Coins Management
    private TextView coins;
    public static String getCoins;



    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String COINS = "200";
    //sharedPreferences
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_start);

        challengebtn=(Button)findViewById(R.id.Challengebtn);
        practibtn=(Button)findViewById(R.id.practbtn);

        challengebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_start.this,Level_next.class));
            }
        });

        practibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_start.this, Practicals.class));
            }
        });

        coins = (TextView) findViewById(R.id.coinView);

         SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        loadCoins(sharedPreferences);
        updateCoins();


    }
    public static void  loadCoins(SharedPreferences sharedPreferences)
    {
        getCoins = sharedPreferences.getString(COINS,"200");
    }

    public void saveCoins()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(COINS,"500");

        editor.apply();

    }

    public static void levelCompleteCoins(SharedPreferences sharedPreferences)
    {
        getCoins = sharedPreferences.getString(COINS,"200");

        int coins = Integer.parseInt(getCoins);
        coins+=50;

        getCoins= String.valueOf(coins);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(COINS,getCoins);

        editor.apply();

        loadCoins(sharedPreferences);



    }

    public static void levelFailedCoins(SharedPreferences sharedPreferences)
    {
        getCoins = sharedPreferences.getString(COINS,"200");

        int coins = Integer.parseInt(getCoins);
        coins-=20;
        if (coins<0)
        {
            coins=0;
        }

        getCoins= String.valueOf(coins);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(COINS,getCoins);

        editor.apply();

        loadCoins(sharedPreferences);

    }

    public static void levelHintCoins(SharedPreferences sharedPreferences)
    {
        getCoins = sharedPreferences.getString(COINS,"200");

        int coins = Integer.parseInt(getCoins);
        coins-=100;

        if(coins<0){
            coins=0;
        }
        getCoins= String.valueOf(coins);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(COINS,getCoins);

        editor.apply();

        loadCoins(sharedPreferences);



    }



    public void updateCoins()
    {
        coins.setText(getCoins);
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
