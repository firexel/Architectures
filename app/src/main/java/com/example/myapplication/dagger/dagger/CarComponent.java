package com.example.myapplication.dagger.dagger;

import dagger.Component;

/**
 * Created by k.filimonov on 21/12/2016.
 */

@Component(modules = {EngineModule.class, GearboxModule.class})
public interface CarComponent {

    CarImpl car();
}
