package com.pattersonhs.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewHintActivity extends AppCompatActivity {

    TextView hintTV;
    Button backBTN;
    String hintText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hint);

        // get the hint that was passed to this activity upon creation
        Intent incomingIntent = getIntent();
        hintText = incomingIntent.getStringExtra("hint");

        // inflate UI
        hintTV = (TextView) findViewById(R.id.hint_TV);
        backBTN = (Button) findViewById(R.id.back_from_hint_BTN);

        // show the hint using the hint Text View
        hintTV.setText(hintText);

        // when the click the "Back to Question" button, this activity
        // will finish and they return back to the main activity
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}