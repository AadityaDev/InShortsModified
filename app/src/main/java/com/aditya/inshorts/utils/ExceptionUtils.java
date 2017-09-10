package com.aditya.inshorts.utils;

import android.support.annotation.NonNull;
import android.util.Log;

public class ExceptionUtils {

    public static void exceptionMessage(@NonNull Exception exception, @NonNull String TAG, @NonNull String exceptionMessage) {
        if (StringUtils.isNotEmptyOrNull(exception.getMessage())) {
            Log.d(TAG, exception.getMessage());
        } else {
            Log.d(TAG, exceptionMessage);
        }
    }

}
