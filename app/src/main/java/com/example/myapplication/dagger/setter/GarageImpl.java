package com.example.myapplication.dagger.setter;


import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.Garage;
import com.example.myapplication.dagger.ManualGearbox;
import com.example.myapplication.dagger.ToyotaJz2Engine;

/**
 * Created by k.filimonov on 21/12/2016.
 */

public class GarageImpl implements Garage {

    @Override
    public Car getCar() {
        CarImpl carImpl = new CarImpl();
        carImpl.setEngine(new ToyotaJz2Engine());
        carImpl.setGearbox(new ManualGearbox());
        return carImpl;
    }

}
