package com.example.myapplication.viper.presenter.mapper;

import com.example.myapplication.viper.domain.DomainProfile;
import com.example.myapplication.viper.model.Profile;
import com.example.myapplication.viper.presenter.ProfileEditPresenter;

/**
 * Created by kirillf on 12/14/16.
 */

public class ProfileMapperImpl implements ProfileMapper {
    @Override
    public Profile toProfile(ProfileEditPresenter.ViewModel profileViewModlel) {
        return new DomainProfile(profileViewModlel.getName(),
                profileViewModlel.getSurname(),
                profileViewModlel.getAvatar(),
                profileViewModlel.getAge());
    }

    @Override
    public ProfileEditPresenter.ViewModel toVViewModel(Profile profile) {
        return new ProfileEditPresenter.ViewModel(profile.getName(),
                profile.getSurname(),
                profile.getAvatarUri(),
                profile.getAge());
    }
}
