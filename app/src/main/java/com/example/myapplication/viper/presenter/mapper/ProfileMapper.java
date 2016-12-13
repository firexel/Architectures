package com.example.myapplication.viper.presenter.mapper;

import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.presenter.ProfileEditPresenter;

/**
 * Created by kirillf on 12/14/16.
 */

public interface ProfileMapper {

    Profile toProfile(ProfileEditPresenter.ViewModel profileViewModlel);
    ProfileEditPresenter.ViewModel toVViewModel(Profile profile);

}
