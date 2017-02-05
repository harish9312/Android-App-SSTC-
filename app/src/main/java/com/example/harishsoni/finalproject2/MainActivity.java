package com.example.harishsoni.finalproject2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView tvDev,tvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface myTypeFace1 = Typeface.createFromAsset(getAssets(), "font/Bistecca.ttf");
        Typeface myType = Typeface.createFromAsset(getAssets(),"font/FontleroyBrownNF.ttf");
        tvMain = (TextView) findViewById(R.id.tvMain);
        tvDev = (TextView) findViewById(R.id.tvDev);
        tvMain.setTypeface(myTypeFace1);
        tvDev.setTypeface(myType);
        //Applying Thread So it Splashes For 2 SECONDS
        new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
