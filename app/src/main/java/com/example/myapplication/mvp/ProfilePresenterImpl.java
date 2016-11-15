package com.example.myapplication.mvp;

import java.util.concurrent.Future;

/**
 * Created by Alex on 15.11.2016.
 */
public class ProfilePresenterImpl implements ProfilePresenter {

    private final View mView;
    private final int mProfileId;
    private final ProfileSource mProfileSource;

    private Future<Profile> mLoadFuture;

    public ProfilePresenterImpl(View view, int profileId, ProfileSource source) {
        mView = view;
        mProfileId = profileId;
        mProfileSource = source;
        if (mProfileId == -1) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void loadProfile() {
        mView.hideError();
        mView.showProgress();
        mLoadFuture = mProfileSource.loadProfile(mProfileId, new ProfileSource.CompleteListener<Profile>() {
            @Override
            public void onLoaded(Profile item) {
                mView.hideProgress();
                mView.showName(item.getName());
                mView.showSurname(item.getSurename());
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
    public void destroy() {
        if (mLoadFuture != null) {
            mLoadFuture.cancel(false);
        }
    }
}
