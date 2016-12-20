package com.example.myapplication.vanilla.retrofit;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aleksandr.naumov on 23.11.2016.
 */

public class ApiFactory {
    public static Api create(String apiUrl) {
        return new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createClient())
                .build()
                .create(Api.class);
    }

    @NonNull
    private static OkHttpClient createClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingIterceptor = new HttpLoggingInterceptor();
        loggingIterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        builder.networkInterceptors().add(loggingIterceptor);
        return builder.build();
    }
}
