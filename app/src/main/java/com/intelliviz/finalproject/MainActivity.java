package com.intelliviz.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;

import com.intelliviz.androidlib.ShowJokeActivity;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnGetJokeListener, OnShowJokeListener {

    private int mJokeIndex = 0;
    private static final int MAX_JOKE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment;
        fragment = MainActivityFragment.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_holder, fragment, "test");
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetJoke(int type) {
        new EndpointsAsyncTask(this).execute(new Pair<Integer, Integer>(mJokeIndex, type));
        mJokeIndex++;
        if(mJokeIndex == MAX_JOKE) {
            mJokeIndex = 0;
        }
    }

    @Override
    public void onShowJoke(String joke) {
        Intent intent = new Intent(this, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.EXTRA_JOKE, joke);
        startActivity(intent);
    }
}