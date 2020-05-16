package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.lang.ref.WeakReference;


public class EndpointsAsyncTask extends AsyncTask<Integer, Void, String> {
    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;

    private WeakReference<JokeDownloadedListener> listener;

    EndpointsAsyncTask(JokeDownloadedListener listener) {
        this.listener = new WeakReference<>(listener);
    }

    @Override
    protected String doInBackground(Integer... numbers) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(new NetHttpTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            final String joke = myApiService.getJoke().execute().getData();
            Log.d(TAG, "Got Joke: " + joke);
            return joke;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        final JokeDownloadedListener app = listener.get();
        if (app != null) {
            app.jokeDownloaded(joke);
        }

        super.onPostExecute(joke);
    }
}