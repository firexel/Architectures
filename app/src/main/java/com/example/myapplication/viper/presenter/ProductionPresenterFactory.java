package com.example.myapplication.viper.presenter;

import com.example.myapplication.viper.interactor.ProfileEditInteractor;
import com.example.myapplication.viper.interactor.ProfileEditInteractorImpl;
import com.example.myapplication.viper.interactor.ProfileGetInteractor;
import com.example.myapplication.viper.interactor.ProfileGetInteractorImpl;
import com.example.myapplication.viper.model.ProfileRepository;
import com.example.myapplication.viper.router.Router;

/**
 * Created by Alex on 16.11.2016.
 */
public class ProductionPresenterFactory implements PresenterFactory {

    private final Router mRouter;
    private final ProfileRepository mProfileRepository;

    public ProductionPresenterFactory(Router router, ProfileRepository profileRepository) {
        mRouter = router;
        mProfileRepository = profileRepository;
    }

    @Override
    public ProfileViewPresenter createProfileViewPresenter(int profileId, ProfileViewPresenter.View view) {
        ProfileGetInteractor getInteractor = new ProfileGetInteractorImpl(mProfileRepository);
        return new ProfileViewPresenterImpl(view, mRouter, getInteractor, profileId);
    }

    @Override
    public ProfileEditPresenter createProfileEditPresenter(int profileId, ProfileEditPresenter.View view) {
        ProfileEditInteractor interactor = new ProfileEditInteractorImpl(mProfileRepository);
        ProfileGetInteractor getInteractor = new ProfileGetInteractorImpl(mProfileRepository);
        return new ProfileEditPresenterImpl(view, mRouter, interactor, getInteractor, profileId);
    }
}
