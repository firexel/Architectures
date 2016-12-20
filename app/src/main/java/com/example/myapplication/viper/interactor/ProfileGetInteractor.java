package com.example.myapplication.viper.interactor;

import com.example.myapplication.viper.model.Profile;

/**
 * Created by kirillf on 12/14/16.
 */

public interface ProfileGetInteractor {

    void getProfile(int id, OnProfileGet getCallback);

    interface OnProfileGet {
        void onSuccess(Profile profile);
        void onFailure();
    }

}
