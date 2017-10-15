package io.liney.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        mJokeTextView = findViewById(R.id.joke_text_view);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");
        mJokeTextView.setText(joke);
    }
}
