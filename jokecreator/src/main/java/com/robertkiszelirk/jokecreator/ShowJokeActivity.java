package com.robertkiszelirk.jokecreator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        TextView textview = findViewById(R.id.joke_text_view);

        //Retrieve the joke from the Intent Extras
        String jokeResult = null;
        Intent intent = getIntent();

        if(intent != null) {
            jokeResult = intent.getStringExtra(getString(R.string.intent_key_to_pass_joke));

            if (TextUtils.isEmpty(jokeResult)) {
                textview.setText(R.string.no_passed_joke);
            } else {
                textview.setText(jokeResult);
            }
        }else{
            textview.setText(R.string.no_passed_joke_from_server);
        }

    }
}
