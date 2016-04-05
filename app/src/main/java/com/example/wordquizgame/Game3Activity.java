package com.example.wordquizgame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game3Activity extends ActionBarActivity {

    //
    private ImageView imageView;
    private TextView textView;
    private LinearLayout linearLayout;
    private int[] qestionImageInts;
    private  String[] answerStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView3);

        linearLayout = (LinearLayout) findViewById(R.id.linButton);

        MyDatalmage myDatalmage = new MyDatalmage();
        qestionImageInts = myDatalmage.questionImageInts;
        answerStrings = myDatalmage.answerStrings;

        showQuestionImage(0);

        clearAnswer();
        
        createButton(0);
    }//Main method

    private void createButton(int intIndex) {

        char[] answerChars = answerStrings[intIndex].toCharArray();




        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i=0;i< answerChars.length;i++){
            Button button = new Button(this);
            button.setId(i + 1);
            button.setText(String.valueOf(answerChars[i]));

            linearLayout.addView(button);


        }


    }

    private void clearAnswer() {

        textView.setText("");


    }

    private void showQuestionImage(int intIndex) {

        imageView.setImageResource(qestionImageInts[intIndex]);
    }


} // Main Class
