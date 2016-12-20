package com.example.myapplication.dagger.nodi;

import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.Engine;
import com.example.myapplication.dagger.Gearbox;
import com.example.myapplication.dagger.ManualGearbox;
import com.example.myapplication.dagger.ToyotaJz2Engine;

/**
 * Created by aleksandr.naumov on 20.12.2016.
 */

public class CarImp implements Car {
    private final Engine mEngine = new ToyotaJz2Engine();
    private final Gearbox mGearbox = new ManualGearbox();

    @Override
    public float getPowerOnWheels() {
        return mEngine.getOutputPower() * mGearbox.getEfficiency();
    }
}
