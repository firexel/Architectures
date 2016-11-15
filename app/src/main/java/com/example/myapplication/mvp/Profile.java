package com.example.myapplication.mvp;

import android.net.Uri;

/**
 * Created by Alex on 16.11.2016.
 */
public interface Profile {
    String getName();
    String getSurename();
    Uri getAvatarUri();
}
