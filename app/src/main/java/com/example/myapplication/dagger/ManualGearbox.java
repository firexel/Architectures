package com.example.myapplication.dagger;

/**
 * Created by aleksandr.naumov on 20.12.2016.
 */

public class ManualGearbox implements Gearbox {
    @Override
    public float getEfficiency() {
        return 0.96f; // very efficient
    }
}
