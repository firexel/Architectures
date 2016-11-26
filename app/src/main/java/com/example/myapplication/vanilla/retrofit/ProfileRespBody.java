package com.example.myapplication.vanilla.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr.naumov on 23.11.2016.
 */
public class ProfileRespBody {

    public ProfileRespBody() {}

    @SerializedName("Id")
    private String mId;

    @SerializedName("Name")
    private String mName;

    @SerializedName("Surname")
    private String mSurname;

    @SerializedName("AvatarUri")
    private String mAvatarUri;

    @SerializedName("Age")
    private int mAge;

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public String getAvatarUri() {
        return mAvatarUri;
    }

    public int getAge() {
        return mAge;
    }


    public void setId(String id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public void setAvatarUri(String avatarUri) {
        mAvatarUri = avatarUri;
    }

    public void setAge(int age) {
        mAge = age;
    }
}

