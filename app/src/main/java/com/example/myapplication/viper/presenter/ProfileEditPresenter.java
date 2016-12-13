package com.example.myapplication.viper.presenter;

import android.net.Uri;

/**
 * Created by Alex on 13.12.2016.
 */

public interface ProfileEditPresenter {
    void onEditProfile(ViewModel profileModel);
    void destroy();

    interface View {
        void showProfile(ViewModel profileViewModel);
        void showError();
        void hideError();
        void showProgress();
        void hideProgress();
        void showInvalidCredentials();
    }

    class ViewModel {
        String mName;
        String mSurname;
        Uri mAvatar;
        int mAge;

        public ViewModel(String mName, String mSurname, Uri mAvatar, int mAge) {
            this.mName = mName;
            this.mSurname = mSurname;
            this.mAvatar = mAvatar;
            this.mAge = mAge;
        }

        public String getName() {
            return mName;
        }

        public String getSurname() {
            return mSurname;
        }

        public Uri getAvatar() {
            return mAvatar;
        }

        public int getAge() {
            return mAge;
        }
    }
}