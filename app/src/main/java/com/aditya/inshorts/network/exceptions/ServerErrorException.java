package com.aditya.inshorts.network.exceptions;

import com.aditya.inshorts.constants.AppConstant;

public class ServerErrorException extends HttpException {

    public ServerErrorException() {
        super(AppConstant.MESSAGE_SERVER_ERROR);
    }
}
