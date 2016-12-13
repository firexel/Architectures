package com.example.myapplication.viper.presenter;

import com.example.myapplication.viper.model.ProfileSource;
import com.example.myapplication.viper.router.Router;

/**
 * Created by Alex on 16.11.2016.
 */
public class ProductionPresenterFactory implements PresenterFactory {

    private final ProfileSource mProfileSource;
    private final Router mRouter;

    public ProductionPresenterFactory(ProfileSource profileSource, Router router) {
        mProfileSource = profileSource;
        mRouter = router;
    }

    @Override
    public ProfileViewPresenter createProfileViewPresenter(int profileId, ProfileViewPresenter.View view) {
        return new ProfileViewPresenterImpl(view, mRouter, profileId, mProfileSource);
    }

    @Override
    public ProfileEditPresenter createProfileEditPresenter(int profileId, ProfileEditPresenter.View view) {
        return new MockProfileEditPresenter(view);
    }
}
