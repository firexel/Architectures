package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.mvp.Locator;
import com.example.myapplication.viper.model.ProfileRepositoryImpl;
import com.example.myapplication.viper.presenter.PresenterFactory;
import com.example.myapplication.viper.presenter.ProductionPresenterFactory;
import com.example.myapplication.viper.router.ActivityRouter;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Alex on 16.11.2016.
 */
public class MyApplication extends Application implements Locator.Host {
    private Locator mLocator;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mLocator = new Locator();
        mLocator.register(
                PresenterFactory.class,
                new ProductionPresenterFactory(new ActivityRouter(this), new ProfileRepositoryImpl())
        );
    }

    @Override
    public Locator getLocator() {
        return mLocator;
    }
}
