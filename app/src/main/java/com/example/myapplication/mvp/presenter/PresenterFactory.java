package com.example.myapplication.mvp.presenter;

/**
 * Created by Alex on 16.11.2016.
 */
public interface PresenterFactory {
    ProfilePresenter createProfilePresenter(int profileId, ProfilePresenter.View view);
}
