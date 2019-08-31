package com.hackedemist.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hackedemist.app.HostDiscovery.Hd_Level7;
import com.termux.R;

public class ActivityLevel11 extends Activity {

    private ImageButton termuxBtn;
    private ImageButton hint11Btn;
    private Button level11btn;
    private EditText hoptxt;
    private ImageButton next11Btn;
    private ImageButton prev11Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level11);


        termuxBtn = (ImageButton) findViewById(R.id.termuxBtn);
        hoptxt=(EditText)findViewById(R.id.hoptxt);
        level11btn=(Button)findViewById(R.id.level11btn);
        next11Btn=(ImageButton) findViewById(R.id.next11Btn);
        hint11Btn = (ImageButton) findViewById(R.id.hint11Btn);
        prev11Btn = (ImageButton) findViewById(R.id.prev11Btn);


        level11btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hop;
                hop=hoptxt.getText().toString();
                if(hop.equals("30")){
                    Toast.makeText(ActivityLevel11.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ActivityLevel11.this, ActivityLevel11.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(ActivityLevel11.this,"Oops!...IP hop",Toast.LENGTH_LONG).show();

                }


            }
        });


        prev11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel11.this, Hd_Level7.class));
            }
        });

        next11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel11.this, ActivityLevel11.class));
            }
        });

        termuxBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel11.this, TermuxActivity.class));
            }
        });




        hint11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel11.this, ActivityHint11.class));
            }
        });


    }
}
