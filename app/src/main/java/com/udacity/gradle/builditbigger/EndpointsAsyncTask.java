package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import io.liney.builditbigger.backend.myApi.MyApi;
import io.liney.displayjoke.JokeDisplayActivity;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, Void>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, Void>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-183011.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;

        try {
            return myApiService.joke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(context, JokeDisplayActivity.class);
        myIntent.putExtra("joke", result);
        context.startActivity(myIntent);
    }
}
