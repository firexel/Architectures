package com.example.myapplication.dagger.dagger;

import com.example.myapplication.dagger.Car;
import com.example.myapplication.dagger.Garage;

/**
 * Created by k.filimonov on 21/12/2016.
 */

public class GarageImpl implements Garage {

    @Override
    public Car getCar() {
        return DaggerCarComponent.builder().build().car();
    }
}
