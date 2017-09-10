package com.aditya.inshorts.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aditya.inshorts.network.Factory;


public class BaseAppCompat extends AppCompatActivity {

    private final String TAG=this.getClass().getSimpleName();
    private static final String TWITTER_KEY = "mcslQcOpVyyFDEso4oUCPpytL";
    private static final String TWITTER_SECRET = "LxJdnnVrmGPSEFHAJJDxktaJBU6qraeH3nk80VZGFSPuzyxczy";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Factory.setUpThreadPolicy();
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public String getTAG() {
        return TAG;
    }

}
