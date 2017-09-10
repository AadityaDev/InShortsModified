package com.aditya.inshorts.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private long id;
    private String name;
    private String email;
    private String handle;
    private String mobile;
    private String picture;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    protected User(Parcel in) {
        id=in.readLong();
        name=in.readString();
        email=in.readString();
        handle=in.readString();
        mobile=in.readString();
        picture=in.readString();
        token=in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(handle);
        dest.writeString(mobile);
        dest.writeString(picture);
        dest.writeString(token);
    }

}
