package com.aditya.inshorts.network.exceptions;

import com.aditya.inshorts.constants.AppConstant;

public class AccessDeniedException extends HttpException {
    public AccessDeniedException() {
        super(AppConstant.EXCEPTION.ACCESS_DENIED);
    }
}
