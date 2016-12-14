package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.mvp.Locator;
import com.example.myapplication.viper.model.MockProfileSource;
import com.example.myapplication.viper.model.ProfileRepository;
import com.example.myapplication.viper.model.ProfileRepositoryImpl;
import com.example.myapplication.viper.model.ProfileSource;
import com.example.myapplication.viper.model.local.LocalProfileSource;
import com.example.myapplication.viper.model.network.NetworkProfileSource;
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
        ProfileSource local = new LocalProfileSource();
        ProfileSource remote = new NetworkProfileSource();
        ProfileRepository repository = new ProfileRepositoryImpl(local, remote);
        mLocator.register(
                PresenterFactory.class,
                new ProductionPresenterFactory(new MockProfileSource(), new ActivityRouter(this), repository)
        );
    }

    @Override
    public Locator getLocator() {
        return mLocator;
    }
}
