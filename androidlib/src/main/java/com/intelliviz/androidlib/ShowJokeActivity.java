package com.intelliviz.androidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);
        TextView jokeView = (TextView) findViewById(R.id.showJokeTextView);
        Intent intent = getIntent();
        String jokeText = intent.getStringExtra(EXTRA_JOKE);
        jokeView.setText(jokeText);
    }
}
