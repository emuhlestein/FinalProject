package com.intelliviz.finalproject;

import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.intelliviz.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by edm on 9/26/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Integer, Integer>, Void, String> {
    private static MyApi mMyApiService = null;
    private OnShowJokeListener mListener;

    public EndpointsAsyncTask(OnShowJokeListener listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(Pair<Integer, Integer>... params) {
        if(mMyApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.114:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
                    // end options for devappserver

            mMyApiService = builder.build();
        }

        Integer index = params[0].first;
        Integer type = params[0].second;

        try {
            return mMyApiService.getJoke(index, type).execute().getData();
        } catch(IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(mListener != null) {
            mListener.onShowJoke(result);
        }
    }
}
