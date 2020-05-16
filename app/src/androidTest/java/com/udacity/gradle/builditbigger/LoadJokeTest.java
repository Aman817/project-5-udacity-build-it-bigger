package com.udacity.gradle.builditbigger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class LoadJokeTest {

    @Mock
    JokeDownloadedListener mockListener;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ensureGetReturnsAValidJoke() {
        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(mockListener);
        asyncTask.execute();

        // Wait for the async task to complete
        Espresso.onIdle();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mockListener).jokeDownloaded(captor.capture());

        final String result = captor.getValue();

        Assert.assertNotNull("Returned value was null", result);
        Assert.assertNotEquals("Returned value was empty", "", result);
    }
}
