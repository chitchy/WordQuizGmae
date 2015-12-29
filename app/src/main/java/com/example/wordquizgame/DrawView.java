package com.example.wordquizgame;

/**
 * Created by chitchy on 29/12/2558.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class DrawView extends View {

    public int[] object = new int[]{R.drawable.animals_cat
            , R.drawable.animals_dog, R.drawable.animals_dolphin};
    public int[] target = new int[]{R.drawable.cat
            , R.drawable.dog, R.drawable.dolphin};

    public int object_size;
    public int[][] object_position;
    public int[][] object_default_position;
    public Bitmap[] object_bitmap = new Bitmap[object.length];

    public int[][] target_position;
    public Bitmap[] target_bitmap = new Bitmap[target.length];
    public boolean[] onTarget = new boolean[target.length];

    public int screen_width, screen_height;

    int object_id = -1;
    Context mContext;

    private int[] objectSourceInts, targetSourceInts;

    public DrawView(Context context, Display display) {
        super(context);
        mContext = context;

        objectSourceInts = new int[12];
        objectSourceInts[0] = R.drawable.animals_cat;
        objectSourceInts[1] = R.drawable.animals_dog;
        objectSourceInts[2] = R.drawable.animals_dolphin;
        objectSourceInts[3] = R.drawable.body_arm;
        objectSourceInts[4] = R.drawable.body_ear;
        objectSourceInts[5] = R.drawable.body_eye;
        objectSourceInts[6] = R.drawable.body_foot;
        objectSourceInts[7] = R.drawable.body_hair;
        objectSourceInts[8] = R.drawable.body_hand;
        objectSourceInts[9] = R.drawable.body_mouth;
        objectSourceInts[10] = R.drawable.body_nose;
        objectSourceInts[11] = R.drawable.body_thumb;

        targetSourceInts = new int[12];
        targetSourceInts[0] = R.drawable.cat;
        targetSourceInts[1] = R.drawable.dog;
        targetSourceInts[2] = R.drawable.dolphin;
        targetSourceInts[3] = R.drawable.arm;
        targetSourceInts[4] = R.drawable.ear;
        targetSourceInts[5] = R.drawable.eye;
        targetSourceInts[6] = R.drawable.foot;
        targetSourceInts[7] = R.drawable.hair;
        targetSourceInts[8] = R.drawable.hand;
        targetSourceInts[9] = R.drawable.mouth;
        targetSourceInts[10] = R.drawable.nose;
        targetSourceInts[11] = R.drawable.thumb;

        randomForImage();



        screen_width = display.getWidth();
        screen_height = display.getHeight();
        object_size = screen_width / 5;
        for (int i = 0; i < object.length; i++) {
            Bitmap bm = BitmapFactory.decodeResource(getResources(), target[i]);
            target_bitmap[i] = Bitmap.createScaledBitmap(bm, object_size, object_size, false);
            bm = BitmapFactory.decodeResource(getResources(), object[i]);
            object_bitmap[i] = Bitmap.createScaledBitmap(bm, object_size, object_size, false);
            onTarget[i] = false;
        }

        target_position = new int[][]{{screen_width * 6 / 8, screen_height * 2 / 8}
                , {screen_width * 6 / 8, screen_height * 4 / 8}
                , {screen_width * 6 / 8, screen_height * 6 / 8}};
        object_default_position = new int[][]{{screen_width * 2 / 8, screen_height * 2 / 8}
                , {screen_width * 2 / 8, screen_height * 4 / 8}
                , {screen_width * 2 / 8, screen_height * 6 / 8}};
        object_position = new int[][]{{object_default_position[0][0], object_default_position[0][1]}
                , {object_default_position[1][0], object_default_position[1][1]}
                , {object_default_position[2][0], object_default_position[2][1]}};
    }

    private void randomForImage() {

        int intMyRandom;
        Random objRandom = new Random();
        for (int i = 0; i < 3; i++) {

            intMyRandom = objRandom.nextInt(12) + 1;
            object[i] = chooseImage(intMyRandom);
        }
    }

    private int chooseImage(int intMyRandom) {

        int intImage = R.drawable.animals_dog;
        switch (intMyRandom){


            case 1:
                intImage = R.drawable.animals_cat;
                break;
            case 2:
                intImage = R.drawable.animals_dog;
                break;
            case 3:
                intImage = R.drawable.animals_dolphin;
                break;
            case 4:
                intImage = R.drawable.body_arm;
                break;
            case 5:
                intImage = R.drawable.body_ear;
                break;
            case 6:
                intImage = R.drawable.body_eye;
                break;
            case 7:
                intImage = R.drawable.body_foot;
                break;
            case 8:
                intImage = R.drawable.body_hair;
                break;
            case 9:
                intImage = R.drawable.body_hand;
                break;
            case 10:
                intImage = R.drawable.body_mouth;
                break;
            case 11:
                intImage = R.drawable.body_nose;
                break;
            case 12:
                intImage = R.drawable.body_thumb;
                break;

            default:
                intImage = R.drawable.animals_cat;
                break;
        }

        return intImage;
    }

    protected void onDraw(Canvas canvas) {

        Paint p = new Paint();
        p.setColor(Color.rgb(0x3e, 0x9c, 0xbc));
        p.setAntiAlias(true);
        for (int i = 0; i < target_position.length; i++) {
            canvas.drawBitmap(target_bitmap[i]
                    , target_position[i][0] - (object_size / 2)
                    , target_position[i][1] - (object_size / 2), p);
        }

        for (int i = 0; i < target_position.length; i++) {
            canvas.drawBitmap(object_bitmap[i]
                    , object_position[i][0] - (object_size / 2)
                    , object_position[i][1] - (object_size / 2), p);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int X = (int) event.getX();
        int Y = (int) event.getY();

        switch (eventaction) {

            case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on a object
                object_id = -1;
                for (int i = 0; i < object.length; i++) {
                    double radCircle = Math.sqrt(Math.pow(Math.abs(X - object_position[i][0]), 2)
                            + Math.pow(Math.abs(Y - object_position[i][1]), 2));
                    if (radCircle < object_bitmap[i].getWidth() / 2 && !onTarget[i]) {
                        object_id = i;
                    }
                }

            case MotionEvent.ACTION_MOVE:
                if (object_id != -1 && !onTarget[object_id]) {
                    object_position[object_id][0] = X;
                    object_position[object_id][1] = Y;
                }
                break;

            case MotionEvent.ACTION_UP:
                if (object_id != -1 && !onTarget[object_id]) {
                    if (Math.abs(object_position[object_id][0] - target_position[object_id][0]) < object_size / 2
                            && Math.abs(object_position[object_id][1] - target_position[object_id][1]) < object_size / 2) {
                        object_position[object_id][0] = target_position[object_id][0];
                        object_position[object_id][1] = target_position[object_id][1];
                        onTarget[object_id] = true;
                    }

                    int count = 0;
                    for (int i = 0; i < object.length; i++) {
                        if (onTarget[i])
                            count++;
                    }

                    if (count == object.length)
                        Toast.makeText(mContext, "Finish", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        invalidate();

        return true;
    }

    public void reset() {
        for (int i = 0; i < object.length; i++)
            onTarget[i] = false;

        object_position = new int[][]{{object_default_position[0][0], object_default_position[0][1]}
                , {object_default_position[1][0], object_default_position[1][1]}
                , {object_default_position[2][0], object_default_position[2][1]}};

        invalidate();
    }
}