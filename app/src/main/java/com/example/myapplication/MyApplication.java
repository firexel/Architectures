package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.mvp.Locator;
import com.example.myapplication.mvp.MockProfileSource;
import com.example.myapplication.mvp.ProductionPresenterFactory;
import com.example.myapplication.mvp.PresenterFactory;

/**
 * Created by Alex on 16.11.2016.
 */
public class MyApplication extends Application implements Locator.Host {
    private Locator mLocator;

    @Override
    public void onCreate() {
        super.onCreate();
        mLocator = new Locator();
        mLocator.register(
                PresenterFactory.class,
                new ProductionPresenterFactory(new MockProfileSource())
        );
    }

    @Override
    public Locator getLocator() {
        return mLocator;
    }
}
