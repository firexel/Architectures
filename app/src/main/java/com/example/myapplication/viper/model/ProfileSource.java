package com.example.myapplication.viper.model;

import java.util.concurrent.Future;

/**
 * Created by Alex on 16.11.2016.
 */
public interface ProfileSource {
    Future<Profile> loadProfile(int profileId, CompleteListener<Profile> completeListener);

    Future<Integer> updateProfile(int profileId, Profile profile, CompleteListener<Integer> completeListener);

    interface CompleteListener<T> {
        void onLoaded(T item);

        void onError(Throwable e);
    }
}
