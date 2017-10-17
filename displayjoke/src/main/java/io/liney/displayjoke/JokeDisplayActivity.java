package io.liney.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    TextView mJokeTextView;
    private final String JOKE_DATA_LABEL = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        mJokeTextView = findViewById(R.id.joke_text_view);
        Intent intent = getIntent();
        if (intent.hasExtra(JOKE_DATA_LABEL)) {
            mJokeTextView.setText(intent.getStringExtra(JOKE_DATA_LABEL));
        } else {
            mJokeTextView.setText(R.string.empty_joke_intent);
        }
    }
}
