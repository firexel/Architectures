package com.example.myapplication.viper.domain;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.myapplication.viper.model.Profile;

/**
 * Created by kirillf on 12/14/16.
 */

public class DomainProfile implements Profile {
    private final String name;
    private final String surname;
    private final Uri avatarUri;
    private final int age;

    public DomainProfile(@NonNull String name, @NonNull String surname, @Nullable Uri avatarUri, int age) {
        this.name = name;
        this.surname = surname;
        this.avatarUri = avatarUri;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Nullable
    @Override
    public Uri getAvatarUri() {
        return avatarUri;
    }

    @Override
    public int getAge() {
        return age;
    }
}
