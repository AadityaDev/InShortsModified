package com.aditya.inshorts.services;

import android.util.Log;

import com.aditya.inshorts.concurrency.ExecutorUtils;
import com.aditya.inshorts.constants.AppAPI;
import com.aditya.inshorts.constants.AppConstant;
import com.aditya.inshorts.network.RequestGenerator;
import com.aditya.inshorts.network.RequestHandler;
import com.aditya.inshorts.utils.StringUtils;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONArray;

import java.util.concurrent.Callable;

import okhttp3.Request;

public class TweetClipService {

    private final String TAG = this.getClass().getSimpleName();

    public ListenableFuture<JSONArray> getProducts() {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.PRODUCT_URL);
                Log.d(TAG, request.toString());
                String result = RequestHandler.makeRequestAndValidate(request);
                Log.d(TAG, result);
                JSONArray score = new JSONArray(result);
                try {
                    Log.d(TAG, score.toString());
                } catch (Exception exception) {
                    if ((exception != null) && (!StringUtils.isNotEmptyOrNull(exception.getMessage()))) {
                        Log.d(TAG, exception.getMessage());
                    } else {
                        Log.d(TAG, AppConstant.EXCEPTION.EXCEPTION);
                    }
                } finally {
                    return score;
                }
            }
        });
    }

}
