package com.example.myapplication.vanilla.legacy;

/**
 * Created by Alex on 15.11.2016.
 */
public abstract class FragmentAccessEvent<T> {
    public abstract void access() throws AccessibilityException;

    public T getFragmentOrThrow() {
        throw new RuntimeException("Not implemented");
    }

    public void onComplete(T fragment, Command command) {
        // do nothing
    }
}
