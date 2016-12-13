package com.example.myapplication.viper.presenter;

/**
 * Created by Alex on 16.11.2016.
 */
public interface PresenterFactory {
    ProfileViewPresenter createProfileViewPresenter(int profileId, ProfileViewPresenter.View view);
    ProfileEditPresenter createProfileEditPresenter(int profileId, ProfileEditPresenter.View view);
}
