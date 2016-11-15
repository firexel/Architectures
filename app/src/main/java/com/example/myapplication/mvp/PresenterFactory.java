package com.example.myapplication.mvp;

/**
 * Created by Alex on 16.11.2016.
 */
public interface PresenterFactory {
    ProfilePresenter createProfilePresenter(int profileId, ProfilePresenter.View view);
}
