package com.example.wordquizgame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseGameAcitvity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game_acitvity);
    }

    public void clickChooseGame(View view) {
        Intent objIntent = new Intent(ChooseGameAcitvity.this, ShowGameActivity.class);
        startActivity(objIntent);

    }
    public void ScoreGame(View view) {
        Intent objIntent = new Intent(ChooseGameAcitvity.this, HighScoreActivity.class);
        startActivity(objIntent);

    }


    protected void onResume() {
        super.onResume();
        Music.play(this, R.raw.main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Music.stop();
    }
}
