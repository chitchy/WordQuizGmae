package com.example.wordquizgame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class ShowGameActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_game);
    }

    public void clickGame1(View view) {
        startActivity(new Intent(ShowGameActivity.this, GameActivity.class));


    }

    public void clickGame2(View view) {
        startActivity(new Intent(ShowGameActivity.this, Game2Activity.class));

    }

    public void clickGame3(View view) {
        startActivity(new Intent(ShowGameActivity.this, Game3Activity.class));

    }
}
