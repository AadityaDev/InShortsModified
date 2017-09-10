package com.aditya.inshorts.network;

import android.os.StrictMode;

import com.aditya.inshorts.services.TweetClipService;

import net.jcip.annotations.GuardedBy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Factory {

    private static final Object LOCK = new Object();
    private static final int TIMEOUT_IN_SECONDS = 60;

    @GuardedBy("LOCK")
    private static OkHttpClient mOkHttpClient;
    @GuardedBy("LOCK")
    private static TweetClipService tweetClipService;

    public static OkHttpClient getOkHTTPClient() {
        synchronized (LOCK) {
            if (mOkHttpClient == null) {
                mOkHttpClient = new OkHttpClient.Builder()
                        .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .build();
            }
        }
        return mOkHttpClient;
    }

    public static TweetClipService getTweetClipService() {
        synchronized (LOCK) {
            if (tweetClipService == null) {
                tweetClipService = new TweetClipService();
            }
        }
        return tweetClipService;
    }

    public static void setUpThreadPolicy() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


}
