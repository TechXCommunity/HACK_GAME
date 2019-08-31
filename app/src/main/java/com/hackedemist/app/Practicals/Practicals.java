package com.hackedemist.app.Practicals;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.termux.R;

public class Practicals extends Activity {
    private Button pract1;
    private Button pract2;
    private Button prac3;
    private Button prac4;
    private Button prac5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicals);

        pract1=(Button)findViewById(R.id.pract1);
        pract2=(Button)findViewById(R.id.pract2);
        prac3= (Button) findViewById(R.id.pract3);
        prac4= (Button) findViewById(R.id.pract4);
        prac5= (Button) findViewById(R.id.pract5);


        pract1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Practicals.this, Practical_Hackthebox.class));
            }
        });

        prac5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });

        pract2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Practicals.this, Practical_Metasploit.class));
            }
        });

        prac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practicals.this,Practical_Webgoat.class));
            }
        });


        prac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Practicals.this,Practical_Setoolkit.class));
            }
        });
    }
}
