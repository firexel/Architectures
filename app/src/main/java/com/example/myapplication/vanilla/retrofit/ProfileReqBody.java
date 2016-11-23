package com.example.myapplication.vanilla.retrofit;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr.naumov on 22.11.2016.
 */

public class ProfileReqBody {
    @SerializedName("Name")
    private String mName;

    @SerializedName("Surname")
    private String mSurname;

    @SerializedName("AvatarUri")
    private Uri mAvatarUri;

    @SerializedName("Age")
    private int mAge;
}
