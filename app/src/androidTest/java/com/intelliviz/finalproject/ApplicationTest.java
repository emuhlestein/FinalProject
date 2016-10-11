package com.intelliviz.finalproject;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.util.Pair;

import com.intelliviz.java.JokeGenerator;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> implements OnShowJokeListener {
    CountDownLatch mSignal = null;
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        mSignal.countDown();
    }

    public void testGetJokeTask() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask(this);
        task.execute(new Pair<Integer, Integer>(0, 1));
        mSignal.await();

    }

    @Override
    public void onShowJoke(String joke) {
        mSignal.countDown();
        JokeGenerator jgen = new JokeGenerator();
        String test = jgen.getJoke(0, 1);
        assertEquals(joke, test);
        Log.d("TAG", joke);
    }
}