package com.example.myapplication.vanilla.retrofit;

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

    @POST("/profile")
    Call<ApiResponse> putProfile(@Body ProfileReqBody body);

    @POST("/profile/{id}")
    Call<ApiResponse> updateProfile(@Path("id") String id, @Body ProfileReqBody body);

    @GET("/profile/{id}/hasboobs")
    Call<ApiResponse> hasBoobs(@Path("id") String id);
}
