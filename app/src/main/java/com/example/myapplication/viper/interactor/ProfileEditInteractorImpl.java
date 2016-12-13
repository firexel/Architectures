package com.example.myapplication.viper.interactor;

import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.model.ProfileRepository;

/**
 * Created by kirillf on 12/14/16.
 */

public class ProfileEditInteractorImpl implements ProfileEditInteractor {
    private final ProfileRepository repository;

    public ProfileEditInteractorImpl(ProfileRepository repository) {
        this.repository = repository;
    }


    @Override
    public void saveProfile(int profileId, Profile profile, final OnProfileEdit callback) {
        repository.updateProfile(profileId, profile, new ProfileRepository.RepositoryCallback<Integer>() {
            @Override
            public void onComplete(Integer integer) {
                callback.onSuccess(integer);
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure();
            }
        });
    }
}
