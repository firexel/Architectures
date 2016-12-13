package com.example.myapplication.viper.presenter;

import android.net.Uri;

/**
 * Created by Alex on 13.12.2016.
 */

public class MockProfileEditPresenter implements ProfileEditPresenter {

    private final ProfileEditPresenter.View mView;

    public MockProfileEditPresenter(View mView) {
        this.mView = mView;
        mView.hideError();
        mView.hideProgress();
        mView.showProfile(newMockProfile());
    }

    private ViewModel newMockProfile() {
        return new ViewModel(
                "Test name", "Test surname",
                Uri.parse("https://habrastorage.org/getpro/habr/avatars/2cc/1d7/75b/2cc1d775bde34946eaaab89940e1e32e.png"),
                18
        );
    }

    @Override
    public void onEditProfile(ViewModel profileModel) {
        mView.showInvalidCredentials();
    }

    @Override
    public void destroy() {

    }
}
