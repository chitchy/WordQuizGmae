package com.example.wordquizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game2Activity extends Activity {
    DrawView dv;
    LinearLayout scene;
    static int num = 0;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        scene = (LinearLayout)findViewById(R.id.scene);
        dv = new DrawView(Game2Activity.this, getWindowManager().getDefaultDisplay());
        draw();

        Button buttonReset = (Button)findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //dv.reset();
                num++;
                Log.d("5April", "You Click Label = " + num);
                if(num<=4){
                    restartActvity();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Game2Activity.this);
                    builder.setTitle("Game End");
                    builder.setMessage("คุณเล่นครบ " + num + " ข้อแล้ว");
                    builder.setCancelable(false);
                    builder.setPositiveButton("ไปหน้าเลือกเกม", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent objIntent = new Intent(Game2Activity.this, ShowGameActivity.class);
                            startActivity(objIntent);
                        }
                    });

                             builder.show();
                }
            }
        });

    }


    private void restartActvity() {
        Intent objIntent = new Intent(Game2Activity.this, Game2Activity.class);
        objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(objIntent);
    }

    public void draw() {
        try {
            scene.removeView(dv);
        } catch (Exception e) { }
        scene.addView(dv);
    }

    public void removeView() {
        try {
            scene.removeView(dv);
        } catch (Exception e) { }
    }

    protected void onResume() {
        super.onResume();
        Music.play(this, R.raw.game);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Music.stop();
    }

}