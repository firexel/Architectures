package com.example.myapplication.dagger.dagger;

import com.example.myapplication.dagger.Engine;
import com.example.myapplication.dagger.ToyotaJz2Engine;

import dagger.Module;
import dagger.Provides;

/**
 * Created by k.filimonov on 21/12/2016.
 */

@Module
class EngineModule {

    @Provides
    Engine providesEngine() {
        return new ToyotaJz2Engine();
    }

}
