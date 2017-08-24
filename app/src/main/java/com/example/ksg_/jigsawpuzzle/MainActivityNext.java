package com.example.ksg_.jigsawpuzzle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivityNext extends AppCompatActivity {

    private static GestureDetectGridView mGridView;
    private static int mColumnWidth, mColumnHeight;
    static int COLUMNS;
    static int DIMENSIONS;
    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";
    public static BitmapDrawable bdrawable;
    private static String[] tileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.main);
            COLUMNS =(int) Math.sqrt(Level.smallimage_Numbers);
            DIMENSIONS = Level.smallimage_Numbers;
            init();
            scramble();
            setDimensions();
        }
        catch(Exception e)
        {
            Log.i("Error","Not working");
        }
    }

    private void init() {
        mGridView = (GestureDetectGridView) findViewById(R.id.grid);
        mGridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = tileList.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }

    private void setDimensions() {
        try {
            ViewTreeObserver vto = mGridView.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int displayWidth = mGridView.getMeasuredWidth();
                    int displayHeight = mGridView.getMeasuredHeight();

                    int statusbarHeight = getStatusBarHeight(getApplicationContext());
                    int requiredHeight = displayHeight - statusbarHeight;

                    mColumnWidth = displayWidth / COLUMNS;
                    mColumnHeight = requiredHeight / COLUMNS;

                    display(getApplicationContext());
                }
            });
        }
        catch(Exception e)
        {
            Log.i("","");
        }
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        if(Level.smallimage_Numbers==9) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);
                if (tileList[i].equals("0")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(0));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("1")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(1));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("2")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(2));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("3")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(3));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("4")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(4));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("5")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(5));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("6")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(6));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("7")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(7));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("8")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(8));
                    button.setBackground(bdrawable);
                }
                buttons.add(button);
            }
        }
       else if(Level.smallimage_Numbers==16) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);
                if (tileList[i].equals("0")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(0));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("1")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(1));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("2")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(2));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("3")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(3));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("4")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(4));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("5")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(5));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("6")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(6));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("7")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(7));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("8")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(8));
                    button.setBackground(bdrawable);
                }
                else if (tileList[i].equals("9")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(9));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("10")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(10));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("11")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(11));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("12")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(12));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("13")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(13));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("14")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(14));
                    button.setBackground(bdrawable);
                }
                else if (tileList[i].equals("15")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(15));
                    button.setBackground(bdrawable);
                }

                buttons.add(button);
            }

        }
        else if(Level.smallimage_Numbers==25) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);
                if (tileList[i].equals("0")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(0));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("1")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(1));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("2")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(2));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("3")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(3));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("4")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(4));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("5")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(5));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("6")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(6));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("7")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(7));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("8")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(8));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("9")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(9));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("10")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(10));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("11")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(11));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("12")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(12));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("13")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(13));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("14")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(14));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("15")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(15));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("16")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(16));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("17")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(17));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("18")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(18));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("19")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(19));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("20")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(20));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("21")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(21));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("22")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(22));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("23")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(23));
                    button.setBackground(bdrawable);
                } else if (tileList[i].equals("24")) {
                    bdrawable = new BitmapDrawable(context.getResources(), Start.smallimage.get(24));
                    button.setBackground(bdrawable);
                }
                buttons.add(button);
            }
        }
        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));
    }

    private static void swap(Context context, int currentPosition, int swap) {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        if (isSolved())
        {
            Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
        }
    }

    public static void moveTiles(Context context, String direction, int position) {
        MainActivity.clickSound(context);
        if (position == 0) {


            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();


        } else if (position > 0 && position < COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

        } else if (position == COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();


        } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {


                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();


        } else if (position == DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();


        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();


        } else {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, COLUMNS);
        }

    }

    private static boolean isSolved() {
        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }
        return solved;
    }
}
