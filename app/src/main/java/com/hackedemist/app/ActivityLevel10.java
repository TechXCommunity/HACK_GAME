package com.hackedemist.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.hackedemist.app.HostDiscovery.Hd_Level1;
import com.termux.R;

public class ActivityLevel10 extends Activity {

    private ImageButton termux;
    private ImageButton hint10btn;
    private ImageButton prev10Btn;
    private ImageButton next10Btn;
    private Button submit10btn;
    private Button Readme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level10);




        termux = (ImageButton) findViewById(R.id.termux10Btn);

        Readme=(Button)findViewById(R.id.Readmebtn);

        submit10btn=(Button)findViewById(R.id.submit10Btn);

        prev10Btn = (ImageButton) findViewById(R.id.prev10Btn);

        next10Btn = (ImageButton) findViewById(R.id.next10Btn);

        hint10btn=(ImageButton)findViewById(R.id.hint10Btn);

        Readme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel10.this,ReadmePop.class));
            }
        });

        submit10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
            }
        });

        next10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel10.this,ActivityLevel11.class));
            }
        });


        prev10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel10.this, Hd_Level1.class));
            }
        });



        termux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel10.this,TermuxActivity.class));
            }
        });
        hint10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel10.this, ActivityHint10.class));
            }
        });
    }
}
