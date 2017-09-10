package com.aditya.inshorts.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.aditya.inshorts.network.Factory;

public class BaseFragment extends Fragment {

    private static final String TWITTER_KEY = "mcslQcOpVyyFDEso4oUCPpytL";
    private static final String TWITTER_SECRET = "LxJdnnVrmGPSEFHAJJDxktaJBU6qraeH3nk80VZGFSPuzyxczy";
    private final String TAG=this.getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Factory.setUpThreadPolicy();
        super.onCreate(savedInstanceState);
    }

    public String getTAG() {
        return TAG;
    }

}
