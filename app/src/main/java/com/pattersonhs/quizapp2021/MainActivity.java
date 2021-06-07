package com.pattersonhs.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Code complete through Unit 1 Lesson 8 Activities and Intents.

    // declaring the UI element variables
    TextView questionTextView;
    Button trueButton;
    Button falseButton;
    Button finishedButton;
    // declaring a score variable
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflating the UI elements
        questionTextView = (TextView) findViewById(R.id.question_text);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        finishedButton = (Button) findViewById(R.id.finished_button);

        // onClick listener and method for the true button,
        // will display toast stating they got it wrong
        // and set the score to 0%
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Nope, pi is irrational.",
                        Toast.LENGTH_SHORT).show();
                score = 0;
            }
        });

        // onClick listener and method for the false button,
        // will display toast stating they got it right
        // and set the score to 100%
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Correct! Nice job!",
                        Toast.LENGTH_SHORT).show();
                score = 100;
            }
        });

        // when the finished button is clicked, we
        // declare an intent, pass the score as an "extra",
        // then open the ScoreActivity to display the score
        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

    }
}