package com.example.myapplication.vanilla.legacy;


import java.util.HashSet;
import java.util.Set;

public abstract class ResourceObserver {

    private final Set<String> mTypes;

    public ResourceObserver(String... types) {
        super();
        this.mTypes = new HashSet<>();
        for (String type : types) {
            mTypes.add(type);
        }
    }

    public Set<String> getObserverTypes() {
        return mTypes;
    }

    public void onChanged() {
        // empty
    }

    public void onInvalidated() {
        // empty
    }

    public void onCleanedUp(){
        //empty
    }

}