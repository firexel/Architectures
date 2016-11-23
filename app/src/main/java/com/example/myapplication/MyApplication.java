package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.mvp.Locator;
import com.example.myapplication.mvp.model.MockProfileSource;
import com.example.myapplication.mvp.model.network.NetworkProfileSource;
import com.example.myapplication.mvp.presenter.ProductionPresenterFactory;
import com.example.myapplication.mvp.presenter.PresenterFactory;

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
                new ProductionPresenterFactory(new NetworkProfileSource())
        );
    }

    @Override
    public Locator getLocator() {
        return mLocator;
    }
}
