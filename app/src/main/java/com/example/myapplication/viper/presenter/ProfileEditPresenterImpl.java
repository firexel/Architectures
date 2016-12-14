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
    private final int profileId;
    private final ProfileMapper mapper;

    private Profile mLoadedProfile;

    public ProfileEditPresenterImpl(final View view, Router router, ProfileEditInteractor editInteractor, ProfileGetInteractor getInteractor, int profileId) {
        this.view = view;
        this.router = router;
        this.editInteractor = editInteractor;
        this.profileId = profileId;
        this.mapper = new ProfileMapperImpl();

        view.showProgress();
        getInteractor.getProfile(profileId, new ProfileGetInteractor.OnProfileGet() {
            @Override
            public void onSuccess(Profile profile) {
                mLoadedProfile = profile;
                view.hideProgress();
                ViewModel vm = mapper.toViewModel(profile);
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
    public void onEditProfile(EditViewModel profileDiff) {
        ViewModel viewModel = new ViewModel(
                profileDiff.getName(),
                profileDiff.getSurname(),
                mLoadedProfile.getAvatarUri(),
                mLoadedProfile.getAge()
        );
        Profile profile = mapper.toProfile(viewModel);
        view.showProgress();
        view.hideError();
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

            @Override
            public void onInvalidProfile() {
                view.hideProgress();
                view.showInvalidProfile();
            }
        });
    }

    @Override
    public void destroy() {

    }
}
