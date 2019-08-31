package com.hackedemist.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hackedemist.app.Challenges.Cryptography;
import com.hackedemist.app.Challenges.File_Based_Attacks;
import com.hackedemist.app.Challenges.Host_discovery;
import com.hackedemist.app.Challenges.User_Enumeration;
import com.hackedemist.app.Challenges.Web_Application;
import com.termux.R;



public class Level_next extends Activity {
    private Button chall1;
    private Button chall2;
    private Button chall3;
    private Button chall4;
    private Button chall5;
    private TextView coins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_next);
        chall1=(Button)findViewById(R.id.pract1);
        chall2=(Button)findViewById(R.id.pract2);
        chall3=(Button)findViewById(R.id.pract3);
        chall4=(Button)findViewById(R.id.pract4);
        chall5=(Button)findViewById(R.id.pract5);
        coins=(TextView)findViewById(R.id.coinViewNext);

        chall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_next.this, Host_discovery.class));
            }
        });


        chall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_next.this, User_Enumeration.class));
            }
        });

        chall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_next.this, Web_Application.class));
            }
        });

        chall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_next.this, Cryptography.class));
            }
        });

        chall5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Level_next.this, File_Based_Attacks.class));
            }
        });


updateCoins();
    }

    public void updateCoins()
    {
        coins.setText(Level_start.getCoins);
    }
}
