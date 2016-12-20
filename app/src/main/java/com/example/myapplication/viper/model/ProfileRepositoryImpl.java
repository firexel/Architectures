package com.example.myapplication.viper.model;

import android.net.Uri;
import android.text.TextUtils;

import com.example.myapplication.viper.domain.DomainProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirillf on 12/14/16.
 */

public class ProfileRepositoryImpl implements ProfileRepository {

    private final Map<Integer, Profile> mProfiles = new HashMap<>();

    public ProfileRepositoryImpl() {
        mProfiles.put(1, new DomainProfile(
                "Alex", "Naumov",
                Uri.parse("https://habrastorage.org/getpro/habr/avatars/2cc/1d7/75b/2cc1d775bde34946eaaab89940e1e32e.png"),
                25
        ));
    }

    @Override
    public void getProfile(int id, final RepositoryCallback<Profile> callback) {
        Profile profile = mProfiles.get(id);
        if (profile != null) {
            callback.onComplete(profile);
        } else {
            callback.onFailure(new NullPointerException().fillInStackTrace());
        }
    }

    @Override
    public void updateProfile(final int id, Profile profile, final RepositoryCallback<Integer> callback) {
        if (profile.getAge() < 0
                || TextUtils.isEmpty(profile.getName())
                || TextUtils.isEmpty(profile.getSurname())) {
            callback.onFailure(new IllegalArgumentException());
        } else {
            mProfiles.put(id, profile);
            callback.onComplete(id);
        }
    }
}
