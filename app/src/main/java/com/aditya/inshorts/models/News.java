package com.aditya.inshorts.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class News implements Parcelable{

    private long id;
    private String category;
    private String hostname;
    private String title;
    private Date timestamp;
    private String publisher;
    private String url;

    public News(){

    }

    public News(String category,String hostname,String title,Date timestamp,String publisher,String url){
        this.category=category;
        this.hostname=hostname;
        this.title=title;
        this.timestamp=timestamp;
        this.publisher=publisher;
        this.url=url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected News(Parcel in) {
        id = in.readLong();
        category = in.readString();
        hostname = in.readString();
        title = in.readString();
        publisher = in.readString();
        url = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(category);
        parcel.writeString(hostname);
        parcel.writeString(title);
        parcel.writeString(publisher);
        parcel.writeString(url);
    }
}
