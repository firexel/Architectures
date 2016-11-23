package com.example.myapplication.vanilla.retrofit;

import android.support.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr.naumov on 22.11.2016.
 */
public class ApiResponse {

    @SerializedName("result")
    @Nullable
    private JsonObject result;

    @SerializedName("error")
    @Nullable
    private JsonObject error;

    @Nullable
    public JsonObject getResult() {
        return result;
    }

    @Nullable
    public JsonObject getError() {
        return error;
    }
}
