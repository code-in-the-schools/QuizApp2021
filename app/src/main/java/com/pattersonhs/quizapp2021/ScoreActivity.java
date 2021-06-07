package com.pattersonhs.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    // declaring variables
    TextView scoreTV;
    Button sendScoreBTN;
    int score;
    String emailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // retrieving the "int extra" (i.e. score) we put into the intent
        // when we started this activity
        Intent incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", 0);

        // inflating UI elements and initializing variables
        scoreTV = (TextView) findViewById(R.id.score_TV);
        sendScoreBTN = (Button) findViewById(R.id.send_score_BTN);
        emailMessage = "Your score is: " + score + ".";

        //concatenating the string score with the numerical score
        scoreTV.setText("Score: " + score);

        // implicit intent to send email
        // each student should use their own email address,
        // or possibly theirs plus the teacher's email
        sendScoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] addresses = new String[] {"yates.code@gmail.com"};
                String subject = "new score on quiz app";
                String body = "Hello!\n" + emailMessage;
                composeEmail(addresses, subject, body);
            }
        });

    }

    // helper method to compose and send email, adapted from
    // https://developer.android.com/guide/components/intents-common
    private void composeEmail(String[] addresses, String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }
}