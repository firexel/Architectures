package com.example.myapplication.viper.model.local;

import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.model.ProfileSource;

import java.util.concurrent.Future;

/**
 * Created by kirillf on 12/14/16.
 */

public class LocalProfileSource implements ProfileSource {

    @Override
    public Future<Profile> loadProfile(int profileId, CompleteListener<Profile> completeListener) {
        return null;
    }

    @Override
    public Future<Integer> updateProfile(int profileId, Profile profile, CompleteListener<Integer> completeListener) {
        return null;
    }

}
