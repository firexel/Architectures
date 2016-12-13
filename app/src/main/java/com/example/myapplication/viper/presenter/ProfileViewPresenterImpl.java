package com.example.myapplication.viper.presenter;

import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.model.ProfileSource;
import com.example.myapplication.viper.router.Router;

import java.util.concurrent.Future;

/**
 * Created by Alex on 15.11.2016.
 */
public class ProfileViewPresenterImpl implements ProfileViewPresenter {

    private final View mView;
    private final Router mRouter;
    private final int mProfileId;
    private final ProfileSource mProfileSource;

    private Future<Profile> mLoadFuture;

    public ProfileViewPresenterImpl(View view, Router router, int profileId, ProfileSource source) {
        mView = view;
        mProfileId = profileId;
        mProfileSource = source;
        mRouter = router;
        if (mProfileId == -1) {
            throw new IllegalArgumentException();
        }
        loadProfile();
    }

    public void loadProfile() {
        mView.hideError();
        mView.showProgress();
        mLoadFuture = mProfileSource.loadProfile(mProfileId, new ProfileSource.CompleteListener<Profile>() {
            @Override
            public void onLoaded(Profile item) {
                mView.hideProgress();
                mView.showName(item.getName());
                mView.showSurname(item.getSurname());
                mView.showAvatar(item.getAvatarUri());
                mLoadFuture = null;
            }

            @Override
            public void onError(Throwable e) {
                mView.hideProgress();
                mView.showError();
                mLoadFuture = null;
            }
        });
    }

    @Override
    public void onEditProfile() {
        mRouter.showEditProfileScreen(mProfileId);
    }

    @Override
    public void destroy() {
        if (mLoadFuture != null) {
            mLoadFuture.cancel(false);
        }
    }
}
