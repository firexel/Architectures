package com.example.myapplication.vanilla.legacy;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Alex on 15.11.2016.
 */
public abstract class BaseAccessActivity extends AppCompatActivity {
    protected AccessFragment getAccessFragment() {
        throw new RuntimeException("Not implemented");
    }
}
