package com.example.myapplication.viper.presenter;

import com.example.myapplication.viper.interactor.ProfileGetInteractor;
import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.router.Router;

/**
 * Created by Alex on 15.11.2016.
 */
public class ProfileViewPresenterImpl implements ProfileViewPresenter {

    private final View mView;
    private final Router mRouter;
    private final int mProfileId;
    private final ProfileGetInteractor mProfileGetInteractor;

    public ProfileViewPresenterImpl(View view, Router router, ProfileGetInteractor source, int profileId) {
        mView = view;
        mProfileId = profileId;
        mProfileGetInteractor = source;
        mRouter = router;
        if (mProfileId == -1) {
            throw new IllegalArgumentException();
        }
        loadProfile();
    }

    public void loadProfile() {
        mView.hideError();
        mView.showProgress();
        mProfileGetInteractor.getProfile(mProfileId, new ProfileGetInteractor.OnProfileGet() {
            @Override
            public void onSuccess(Profile item) {
                mView.hideProgress();
                mView.showName(item.getName());
                mView.showSurname(item.getSurname());
                mView.showAvatar(item.getAvatarUri());
            }

            @Override
            public void onFailure() {
                mView.hideProgress();
                mView.showError();
            }
        });
    }

    @Override
    public void onEditProfile() {
        mRouter.showEditProfileScreen(mProfileId);
    }

    @Override
    public void destroy() {
    }
}
