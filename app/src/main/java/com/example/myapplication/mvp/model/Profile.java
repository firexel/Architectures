package com.example.myapplication.mvp.model;

import android.net.Uri;

/**
 * Created by Alex on 16.11.2016.
 */
public interface Profile {
    String getName();

    String getSurname();

    Uri getAvatarUri();
}
