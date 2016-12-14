package com.example.myapplication.viper.presenter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Alex on 13.12.2016.
 */

public interface ProfileEditPresenter {
    void onEditProfile(EditViewModel profileModel);

    void destroy();

    interface View {
        void showProfile(ViewModel profileViewModel);
        void showError();
        void hideError();
        void showProgress();
        void hideProgress();
        void showInvalidProfile();
    }

    class ViewModel {
        private final String mName;
        private final String mSurname;
        private final Uri mAvatar;
        private final int mAge;

        public ViewModel(@NonNull String mName, @NonNull String mSurname, @Nullable Uri mAvatar, int mAge) {
            this.mName = mName;
            this.mSurname = mSurname;
            this.mAvatar = mAvatar;
            this.mAge = mAge;
        }

        @NonNull
        public String getName() {
            return mName;
        }

        @NonNull
        public String getSurname() {
            return mSurname;
        }

        @Nullable
        public Uri getAvatar() {
            return mAvatar;
        }

        public int getAge() {
            return mAge;
        }
    }

    class EditViewModel {
        private final String mName;
        private final String mSurname;

        public EditViewModel(String name, String surname) {
            mName = name;
            mSurname = surname;
        }

        public String getName() {
            return mName;
        }

        public String getSurname() {
            return mSurname;
        }
    }
}
