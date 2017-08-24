package com.example.ksg_.jigsawpuzzle;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

   static int vi=0;
   public void clicktoSoundOn(View view)
   {
       Button soundon = (Button) findViewById(R.id.soundon);
       Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
       if(vi==0)
       {
           vibe.vibrate(100);
       }
       if(MainActivity.so==0)
       {
           MainActivity.so=1;
           soundon.setText("Sound On");
       }
       else
       {
           MainActivity.so=0;
           soundon.setText("Sound Off");
       }
       MainActivity.clickSound(this);
   }
    public void clicktoVibrate(View view)
    {
        Button vibrate = (Button) findViewById(R.id.vibrate);
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(vi==0) {
            vi=1;
            vibrate.setText("Vibrate On");
        }
        else
        {
            vibe.vibrate(100);
            vi=0;
            vibrate.setText("Vibrate Off");
        }
    }
    public void clicktoSetLevel(View view)
    {
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(vi==0)
        {
            vibe.vibrate(100);
        }
        Intent intent= new Intent(getApplication(),Level.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }


}
