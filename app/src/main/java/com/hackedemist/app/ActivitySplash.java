package com.hackedemist.app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.termux.R;

public class ActivitySplash extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(2000);
                    Intent intent= new Intent(getApplicationContext(), Second.class);
                    startActivity(intent);
                    finish();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();

                }
            }
        };
        myThread.start();
    }

}
