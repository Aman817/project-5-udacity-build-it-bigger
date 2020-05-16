package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest {

    @Test
    public void testDoInBackground() throws Exception {

        JokeReceived jokeReceived = new JokeReceived() {
            @Override
            public void jokeText(String string) {

            }
        };

        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(jokeReceived);
        endpointAsyncTask.execute(InstrumentationRegistry.getContext());
        String joke = endpointAsyncTask.get(5, TimeUnit.SECONDS);
        Assert.assertNotEquals(0,joke.length());
    }

}
