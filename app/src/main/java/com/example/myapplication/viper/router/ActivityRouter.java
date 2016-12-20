package com.example.myapplication.viper.router;

import android.content.Context;
import android.content.Intent;

import com.example.myapplication.viper.view.ProfileEditActivity;
import com.example.myapplication.viper.view.ProfileViewActivity;

/**
 * Created by Alex on 13.12.2016.
 */

public class ActivityRouter implements Router {

    private final Context mContext;

    public ActivityRouter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showEditProfileScreen(int id) {
        Intent intent = new Intent(mContext, ProfileEditActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void showProfileScreen(int id) {
        Intent intent = new Intent(mContext, ProfileViewActivity.class);
        mContext.startActivity(intent);
    }


}
