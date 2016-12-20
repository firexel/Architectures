package com.example.myapplication.dagger.manual;

import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.Engine;
import com.example.myapplication.dagger.Gearbox;

/**
 * Created by aleksandr.naumov on 20.12.2016.
 */

public class CarImpl implements Car {
    private final Engine mEngine;
    private final Gearbox mGearbox;

    public CarImpl(Engine engine, Gearbox gearbox) {
        mEngine = engine;
        mGearbox = gearbox;
    }

    @Override
    public float getPowerOnWheels() {
        return mEngine.getOutputPower() * mGearbox.getEfficiency();
    }
}
