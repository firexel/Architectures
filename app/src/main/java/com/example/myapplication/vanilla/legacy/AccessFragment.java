package com.example.myapplication.vanilla.legacy;

import android.app.Activity;

/**
 * Created by Alex on 15.11.2016.
 */
public abstract class AccessFragment {
    public abstract void access(FragmentAccessEvent event);

    public DataManager getDataManager() {
        throw new RuntimeException();
    }

    public void showError() {
    }

    public Activity getActivity() {
        throw new RuntimeException();
    }
}
