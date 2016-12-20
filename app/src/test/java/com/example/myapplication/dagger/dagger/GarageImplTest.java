package com.example.myapplication.dagger.dagger;

import com.example.myapplication.dagger.Car;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by k.filimonov on 21/12/2016.
 */
public class GarageImplTest {
    private static final float EXPECTED_POWER = 268.8f;
    private static final float EXPECTED_MOCK_POWER = -100;

    private GarageImpl garage;

    private static CarComponent carComponent;

    @BeforeClass
    public static void setUpMockComponent() {
        carComponent = DaggerCarComponent.builder()
                .engineModule(new MockEngineModule())
                .gearboxModule(new MockGearboxModule())
                .build();
    }

    @Before
    public void setUpGarage() throws Exception {
        garage = new GarageImpl();
    }

    @Test
    public void getCarShouldReturnNonNull() throws Exception {
        Car car = garage.getCar();
        assertNotNull(car);
    }

    @Test
    public void getCarShouldReturnExpectedValue() throws Exception {
        Car car = garage.getCar();
        assertEquals("Unexpected power value", EXPECTED_POWER, car.getPowerOnWheels(), 0.1);
    }

    @Test
    public void getCarFromMockedComponentShouldReturnExpectedMockedResult() throws Exception {
        Car car = carComponent.car();
        assertEquals("Unexpected power value", EXPECTED_MOCK_POWER, car.getPowerOnWheels(), 0.1);
    }


}