package com.example.myapplication.vanilla.retrofit;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr.naumov on 22.11.2016.
 */

public class ProfileBody {
    @SerializedName("name")
    private String mName;

    @SerializedName("surname")
    private String mSurname;

    @SerializedName("avatarUri")
    private Uri mAvatarUri;

    @SerializedName("age")
    private int mAge;
}
