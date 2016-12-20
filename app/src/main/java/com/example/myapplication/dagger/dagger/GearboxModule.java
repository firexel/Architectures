package com.example.myapplication.dagger.dagger;

import com.example.myapplication.dagger.Gearbox;
import com.example.myapplication.dagger.ManualGearbox;

import dagger.Module;
import dagger.Provides;

/**
 * Created by k.filimonov on 21/12/2016.
 */

@Module
class GearboxModule {

    @Provides
    Gearbox providesGearbox() {
        return new ManualGearbox();
    }
}
