package com.example.ksg_.jigsawpuzzle;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Level extends AppCompatActivity {
    static  int smallimage_Numbers=9;
    public void clickforEasy(View view)
    {
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Setting.vi==0)
        {
            vibe.vibrate(100);
        }
        smallimage_Numbers=9;
        Intent intent = new Intent(getApplication(),Start.class);
        startActivity(intent);
    }
    public void clickforMedium(View view)
    {
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Setting.vi==0)
        {
            vibe.vibrate(100);
        }
        smallimage_Numbers=16;
        Intent intent = new Intent(getApplication(),Start.class);
        startActivity(intent);
    }
    public void clickforHard(View view)
    {
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Setting.vi==0)
        {
            vibe.vibrate(100);
        }
        smallimage_Numbers=25;
        Intent intent = new Intent(getApplication(),Start.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }


}
