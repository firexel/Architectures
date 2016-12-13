package com.example.myapplication.viper.model.network;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.vanilla.retrofit.ApiFactory;
import com.example.myapplication.vanilla.retrofit.ApiResponse;
import com.example.myapplication.vanilla.retrofit.ProfileRespBody;
import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.model.ProfileSource;
import com.google.gson.Gson;

import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aleksandr.naumov on 23.11.2016.
 */
public class NetworkProfileSource implements ProfileSource {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public Future<Profile> loadProfile(int profileId, final CompleteListener<Profile> completeListener) {
        Call<ApiResponse> call = ApiFactory.create("http://google.com").getProfile(String.valueOf(profileId));
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, final Response<ApiResponse> response) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ApiResponse apiResponse = response.body();
                        if (response.isSuccessful() && apiResponse.getResult() != null) {
                            completeListener.onLoaded(mapToProfile(apiResponse));
                        } else {
                            completeListener.onError(new RuntimeException("Invalid response"));
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<ApiResponse> call, final Throwable t) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        completeListener.onError(t);
                    }
                });
            }
        });
        return null;
    }

    private Profile mapToProfile(ApiResponse body) {
        final ProfileRespBody resp = new Gson().fromJson(body.getResult(), ProfileRespBody.class);
        return new Profile() {
            @Override
            public String getName() {
                return resp.getName();
            }

            @Override
            public String getSurname() {
                return resp.getSurname();
            }

            @Override
            public Uri getAvatarUri() {
                return Uri.parse(resp.getAvatarUri());
            }
        };
    }
}
