package com.example.myapplication.viper.interactor;


import com.example.myapplication.viper.model.Profile;

/**
 * Created by kirillf on 12/14/16.
 */

public interface ProfileEditInteractor {

    void saveProfile(int profileId, Profile profile, OnProfileEdit callback);

    interface OnProfileEdit {
        void onSuccess(int id);
        void onFailure();
    }
}
