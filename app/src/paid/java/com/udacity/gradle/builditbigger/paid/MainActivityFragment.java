package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.robertkiszelirk.jokecreator.ShowJokeActivity;
import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.JokeReceived;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment implements JokeReceived{

    ProgressBar progressBar = null;

    View root;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);

        progressBar = root.findViewById(R.id.tell_joke_progress_bar);
        progressBar.setVisibility(View.GONE);

        Button buttonTellJoke = root.findViewById(R.id.tell_joke_button);
        buttonTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                getJoke();
            }
        });

        return root;
    }

    private void getJoke() {

        new EndpointAsyncTask(this).execute(getContext());
    }

    @Override
    public void jokeText(String joke) {

        progressBar.setVisibility(View.GONE);
        final Intent intent = new Intent(root.getContext(), ShowJokeActivity.class);
        intent.putExtra(getString(R.string.intent_key_to_pass_joke),joke);
        startActivity(intent);

    }

}