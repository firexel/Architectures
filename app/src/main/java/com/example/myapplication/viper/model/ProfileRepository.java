package com.example.myapplication.viper.model;

/**
 * Created by kirillf on 12/14/16.
 */

public interface ProfileRepository {

    void getProfile(int id, RepositoryCallback<Profile> callback);
    void updateProfile(int id, Profile profile, RepositoryCallback<Integer> callback);

    interface RepositoryCallback<T> {
        void onComplete(T t);
        void onFailure(Throwable t);
    }
}
