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
import com.hackedemist.app.WebApplication.Wa_Level1;
import com.termux.R;

public class ActivityLevel8 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level8);
        ImageButton termuxBtn = (ImageButton) findViewById(R.id.termux8Btn);
        EditText pswdtxt = (EditText) findViewById(R.id.pass8Btn);
        Button level8btn = (Button) findViewById(R.id.level8btn);
        ImageButton next8Btn = (ImageButton) findViewById(R.id.next8Btn);
        ImageButton hint8Btn = (ImageButton) findViewById(R.id.hint8Btn);
        ImageButton prev8Btn = (ImageButton) findViewById(R.id.prev8Btn);


        level8btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pswd;
                pswd=pswdtxt.getText().toString();
                if(pswd.equals("Hackedemist has approved you to move to next dimension")){
                    Toast.makeText(ActivityLevel8.this,"Host_discovery Completed ",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ActivityLevel8.this, Hd_Level7.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(ActivityLevel8.this,"Oops!...Password Incorrect",Toast.LENGTH_LONG).show();

                }


            }
        });


        prev8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel8.this, Wa_Level1.class));
            }
        });

        next8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel8.this, Hd_Level7.class));
            }
        });

        termuxBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel8.this,TermuxActivity.class));
            }
        });




        hint8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLevel8.this, ActivityHint8.class));
            }
        });


    }
}
