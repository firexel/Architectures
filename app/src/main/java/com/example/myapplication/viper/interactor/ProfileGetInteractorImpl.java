package com.example.myapplication.viper.interactor;

import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.model.ProfileRepository;

/**
 * Created by kirillf on 12/14/16.
 */

public class ProfileGetInteractorImpl implements ProfileGetInteractor {
    private final ProfileRepository profileRepository;

    public ProfileGetInteractorImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void getProfile(int id, final OnProfileGet getCallback) {
        profileRepository.getProfile(id, new ProfileRepository.RepositoryCallback<Profile>() {
            @Override
            public void onComplete(Profile profile) {
                getCallback.onSuccess(profile);
            }

            @Override
            public void onFailure(Throwable t) {
                getCallback.onFailure();
            }
        });
    }
}
