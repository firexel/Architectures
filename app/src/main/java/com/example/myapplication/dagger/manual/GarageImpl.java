package com.example.myapplication.dagger.manual;

import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.Engine;
import com.example.myapplication.dagger.Garage;
import com.example.myapplication.dagger.Gearbox;
import com.example.myapplication.dagger.ManualGearbox;
import com.example.myapplication.dagger.ToyotaJz2Engine;

/**
 * Created by k.filimonov on 21/12/2016.
 */

public class GarageImpl implements Garage {

    @Override
    public Car getCar() {
        Gearbox gearbox = new ManualGearbox();
        Engine engine = new ToyotaJz2Engine();
        return new CarImpl(engine, gearbox);
    }

}
