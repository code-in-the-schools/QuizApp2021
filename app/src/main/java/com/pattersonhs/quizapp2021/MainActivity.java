package com.pattersonhs.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Code complete through Unit 1 Lesson 7 Quiz App Begins.

    // declaring the UI element variables
    TextView questionTextView;
    Button trueButton;
    Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflating the UI elements
        questionTextView = (TextView) findViewById(R.id.question_text);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);

        // onClick listener and method for the true button,
        // will display toast stating they got it wrong
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Nope, pi is irrational.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // onClick listener and method for the false button,
        // will display toast stating they got it right
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Correct! Nice job!",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}