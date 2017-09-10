package com.aditya.inshorts.models;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable{

    private long id;
    private String title;
    private String subTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public News(){

    }

    public News(String title,String subTitle){
        this.title=title;
        this.subTitle=subTitle;
    }

    protected News(Parcel in) {
        id = in.readLong();
        title = in.readString();
        subTitle = in.readString();
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
        parcel.writeString(title);
        parcel.writeString(subTitle);
    }
}
