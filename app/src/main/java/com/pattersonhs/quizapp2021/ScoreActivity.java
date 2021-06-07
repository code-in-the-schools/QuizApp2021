package com.pattersonhs.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    // declaring variables
    TextView scoreTV;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // retrieving the "int extra" (i.e. score) we put into the intent
        // when we started this activity
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        // inflating UI element variables
        scoreTV = (TextView) findViewById(R.id.score_TV);

        //concatenating the string score with the numerical score
        scoreTV.setText("Score: " + score);

    }
}