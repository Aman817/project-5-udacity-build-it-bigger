package com.kieranjohnmoore.jokelibrary;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.kieranjohnmoore.jokelibrary.databinding.ActivityJokeBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.util.Log;
import android.view.View;

public class JokeActivity extends AppCompatActivity {

    private static final String LOGTAG = JokeActivity.class.getSimpleName();

    public static final String JOKE = "JOKE_TO_DISPLAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent.hasExtra(JOKE)) {
            binding.jokeText.setText(intent.getStringExtra(JOKE));
        } else {
            Log.e(LOGTAG, "NO JOKE WAS PASSED IN");
        }
    }

}
