package com.example.myapplication.vanilla.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by aleksandr.naumov on 22.11.2016.
 */

public interface Api {
    @GET("/profile/{id}")
    Call<ApiResponse> getProfile(@Path("id") String id);

    @POST("/profile/{id}")
    Call<ApiResponse> putProfile(@Path("id") String id, @Body ProfileBody body);

    @GET("/profile/{id}/avatar")
    Call<ResponseBody> getAvatar(@Path("id") String id);

    @GET("/profile/{id}/hasboobs")
    Call<ApiResponse> hasBoobs(@Path("id") String id);
}
