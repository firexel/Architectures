package com.example.myapplication.dagger.dagger;

import com.example.myapplication.dagger.Engine;

/**
 * Created by k.filimonov on 21/12/2016.
 */

public class MockEngineModule extends EngineModule {

    @Override
    Engine providesEngine() {
        return new MockEngine();
    }
}
