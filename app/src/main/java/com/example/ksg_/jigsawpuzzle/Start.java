package com.example.ksg_.jigsawpuzzle;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Start extends AppCompatActivity {

    ImageView imgView;
    static ArrayList<Bitmap> smallimage;
    public void selectImage(View view)
    {
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Setting.vi==0)
        {
            vibe.vibrate(100);
        }
        //Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //startActivityForResult(galleryIntent,RESULT_LOAD);
    }

    public void playGame(View view)
    {
        MainActivity.clickSound(this);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Setting.vi==0)
        {
            vibe.vibrate(100);
        }
        try {
            Intent intent = new Intent(Start.this, MainActivityNext.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.i("See","Error  1");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        imgView = (ImageView) findViewById(R.id.im1);
        splitImage(imgView, Level.smallimage_Numbers);
    }

        @Override
        public void onBackPressed()
        {
            finish();
            Intent intent = new Intent(getApplication(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            if (resultCode == RESULT_OK && requestCode == RESULT_LOAD && null != data) {
//                Uri selectedImage = data.getData();
//                String[] filePathColumn = {MediaStore.Images.Media.DATA};
//                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//                cursor.moveToFirst();
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                img_Decodable_Str = cursor.getString(columnIndex);
//                cursor.close();
//                bitmap = BitmapFactory.decodeFile(img_Decodable_Str);
//                imgView.setImageBitmap(bitmap);
//            }
//        } catch (Exception e) {
//            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_LONG).show();
//        }
//    }

    private void splitImage(ImageView image, int smallimage_Numbers) {

        int rows,cols;

        int smallimage_Height,smallimage_Width;

        smallimage = new ArrayList<Bitmap>(smallimage_Numbers);

        BitmapDrawable mydrawable = (BitmapDrawable) image.getDrawable();

        Bitmap bitmap = mydrawable.getBitmap();

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);



        rows = cols = (int) Math.sqrt(smallimage_Numbers);

        smallimage_Height = bitmap.getHeight()/rows;

        smallimage_Width = bitmap.getWidth()/cols;

        int yCo = 0;

        for(int x=0; x<rows; x++){

            int xCo = 0;

            for(int y=0; y<cols; y++){

                smallimage.add(Bitmap.createBitmap(scaledBitmap, xCo, yCo, smallimage_Width, smallimage_Height));

                xCo += smallimage_Width;

            }

            yCo+= smallimage_Height;

        }

    }

}
