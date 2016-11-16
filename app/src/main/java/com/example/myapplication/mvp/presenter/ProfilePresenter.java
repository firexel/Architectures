package com.example.myapplication.mvp.presenter;

import android.net.Uri;

/**
 * Created by Alex on 15.11.2016.
 */
public interface ProfilePresenter {
    void loadProfile();
    void destroy();

    interface View {
        void showName(String name);
        void showSurname(String surname);
        void showAvatar(Uri avatar);
        void showError();
        void hideError();
        void showProgress();
        void hideProgress();
    }
}
