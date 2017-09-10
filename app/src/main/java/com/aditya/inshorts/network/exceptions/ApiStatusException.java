package com.aditya.inshorts.network.exceptions;

public class ApiStatusException extends HttpException {
    public ApiStatusException(String message) {
        super(message);
    }
}
