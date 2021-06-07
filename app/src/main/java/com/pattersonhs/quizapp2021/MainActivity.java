package com.pattersonhs.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Code complete through Unit 2 Lesson 2 Quiz App with OOP.

    // declaring the UI element variables
    TextView questionTextView;
    Button trueButton;
    Button falseButton;
    Button nextButton;
    Button viewHintButton;
    // declaring a score variable and a message string
    int score;
    String toastMessage;
    // declaring variables for our question objects, the array, and counter
    Question q1, q2, q3, q4, q5, currentQ;
    Question[] questions;
    int currentQindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflating the UI elements
        questionTextView = (TextView) findViewById(R.id.question_text);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        viewHintButton = (Button) findViewById(R.id.view_hint_button);

        // initializing variables for score and Questions
        score = 0;
        currentQindex = 0;
        q1 = new Question("Pi is equal to 3",
                false,
                "Pi is approximately 3.14159");
        q2 = new Question("Pi = C / d",
                true,
                "What is the definition of pi?");
        q3 = new Question("Pi is transcendental",
                true,
                "A transcendental number is not the solution to any algebraic equation " +
                        "with integer coefficients");
        q4 = new Question("Pi is rational",
                false,
                "A rational number is the ratio of two integers");
        q5 = new Question("Pi is the best number!",
                true,
                "You know this in your heart to be true!");
        questions = new Question[] {q1,q2,q3,q4,q5};
        currentQ = questions[currentQindex];

        // onClick listener and method for the false button,
        // will display toast and update score based on right/wrong answer
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        // onClick listener and method for the false button,
        // will display toast and update score based on right/wrong answer
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        // when the view hint button is pressed, open a new activity with
        // a hint shown; added hint as an attribute in the Question class also
        viewHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewHintActivity.class);
                intent.putExtra("hint", currentQ.getHint());
                startActivity(intent);
            }
        });

        // when the next button is clicked, if we're at the end of the array,
        // we declare an intent, pass the score as an "extra",
        // then open the ScoreActivity to display the score;
        // otherwise we advance to the next question, including
        // advancing the index counter, advancing the currentQ object, and
        // displaying the correct question text on screen
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQindex>=questions.length-1) {
                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
                else {
                    currentQindex++;
                    currentQ = questions[currentQindex];
                    questionTextView.setText(currentQ.getQuestionText());
                }
            }
        });

    }

    // helper method for checking correct answer, updating score, and displaying toast
    private void checkAnswer(boolean buttonPressed) {
        if (currentQ.getQuestionCorrectAnswer()==buttonPressed) {
            // correct answer matches the button they pressed
            toastMessage = "Correct! Nice job!";
            score++;
        }
        else {
            // correct answer does not match which button they pressed
            toastMessage = "Nope, that's wrong.";
        }
        Toast.makeText(MainActivity.this,
                toastMessage, Toast.LENGTH_SHORT).show();
    }
}