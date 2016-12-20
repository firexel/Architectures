package com.example.myapplication.dagger.dagger;

import com.example.myapplication.dagger.Engine;

/**
 * Created by k.filimonov on 21/12/2016.
 */

public class MockEngine implements Engine {
    @Override
    public float getOutputPower() {
        return -1;
    }
}
