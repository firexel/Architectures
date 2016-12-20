package com.example.myapplication.dagger.setter;

import android.support.annotation.NonNull;

import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.Engine;
import com.example.myapplication.dagger.Gearbox;

/**
 * Created by k.filimonov on 21/12/2016.
 */

public class CarImpl implements Car {
    private Engine engine;
    private Gearbox gearbox;

    @Override
    public float getPowerOnWheels() {
        if (engine != null && gearbox != null) {
            return engine.getOutputPower() * gearbox.getEfficiency();
        }
        throw new IllegalStateException("fucking fuck");
    }

    public void setEngine(@NonNull Engine engine) {
        this.engine = engine;
    }

    public void setGearbox(@NonNull Gearbox gearbox) {
        this.gearbox = gearbox;
    }
}
