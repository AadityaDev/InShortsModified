package com.aditya.inshorts.constants;

import java.io.Serializable;

public enum API implements Serializable {

    BASE(""),
    HOME(""),
    TWITTES_LIST("https://api.twitter.com/1.1/search/tweets.json"),
    HASHTAGS("https://api.twitter.com/1.1/trends/place.json?id=");

    private String url;

    API(String url){
        this.url=url;
    }

    public String getURL(){
        return BASE.getURL()+url;
    }

}
