package com.example.myapplication.vanilla.legacy;

/**
 * Created by Alex on 15.11.2016.
 */
public class Command<P, R> {
    public R getResult() {
        throw new RuntimeException();
    }


    public boolean isCancelled() {
        throw new RuntimeException();
    }
}
