package com.example.myapplication.viper.presenter;

import com.example.myapplication.viper.interactor.ProfileEditInteractor;
import com.example.myapplication.viper.interactor.ProfileGetInteractor;
import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.presenter.mapper.ProfileMapper;
import com.example.myapplication.viper.presenter.mapper.ProfileMapperImpl;
import com.example.myapplication.viper.router.Router;

/**
 * Created by kirillf on 12/14/16.
 */

public class ProfileEditPresenterImpl implements ProfileEditPresenter {

    private final View view;
    private final Router router;
    private final ProfileEditInteractor editInteractor;
    private final ProfileGetInteractor getInteractor;
    private final int profileId;
    private final ProfileMapper mapper;

    public ProfileEditPresenterImpl(final View view, int profileId, Router router,
                                    ProfileEditInteractor editInteractor,
                                    ProfileGetInteractor getInteractor) {
        this.view = view;
        this.router = router;
        this.getInteractor = getInteractor;
        this.editInteractor = editInteractor;
        this.profileId = profileId;
        this.mapper = new ProfileMapperImpl();

        view.showProgress();
        getInteractor.getProfile(profileId, new ProfileGetInteractor.OnProfileGet() {
            @Override
            public void onSuccess(Profile profile) {
                view.hideProgress();
                ViewModel vm = mapper.toVViewModel(profile);
                view.showProfile(vm);
            }

            @Override
            public void onFailure() {
                view.hideProgress();
                view.showError();
            }
        });
    }


    @Override
    public void onEditProfile(ViewModel profileModel) {
        Profile profile = mapper.toProfile(profileModel);
        view.showProgress();
        editInteractor.saveProfile(profileId, profile, new ProfileEditInteractor.OnProfileEdit() {
            @Override
            public void onSuccess(int id) {
                view.hideProgress();
                router.showProfileScreen(id);
            }

            @Override
            public void onFailure() {
                view.hideProgress();
                view.showError();
            }
        });
    }

    @Override
    public void destroy() {

    }
}
