package com.example.myapplication.mvp.presenter;

import com.example.myapplication.mvp.model.ProfileSource;

/**
 * Created by Alex on 16.11.2016.
 */
public class ProductionPresenterFactory implements PresenterFactory {

    private final ProfileSource mProfileSource;

    public ProductionPresenterFactory(ProfileSource profileSource) {
        this.mProfileSource = profileSource;
    }

    @Override
    public ProfilePresenter createProfilePresenter(int profileId, ProfilePresenter.View view) {
        return new ProfilePresenterImpl(view, profileId, mProfileSource);
    }
}
