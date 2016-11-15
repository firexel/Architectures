package com.example.myapplication.mvp;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class Locator {
    private final Map<Class<?>, Locatable<?>> mLocatedMap = new HashMap<>();

    public static Locator from(Context context) {
        if (context instanceof Host) {
            return ((Host) context).getLocator();
        } else if (context.getApplicationContext() instanceof Host) {
            return ((Host) context.getApplicationContext()).getLocator();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T locate(Class<T> clazz) {
        Locatable<T> locatable = (Locatable<T>) mLocatedMap.get(clazz);
        if (locatable != null) {
            try {
                return locatable.locate();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        throw new IllegalStateException();
    }

    public <T, I extends T> void register(Class<T> clazz, I impl) {
        mLocatedMap.put(clazz, new EagerLocatable<>(impl));
    }

    public <T, I extends T> void registerLazy(Class<T> clazz, LazyInitialisable<I> lazyInitializer) {
        mLocatedMap.put(clazz, new LazyLocatable<>(lazyInitializer));
    }

    public interface Host {
        Locator getLocator();
    }

    interface Locatable<T> {
        T locate() throws Exception;
    }

    public interface LazyInitialisable<T> {
        T initialize() throws Exception;
    }

    private static class EagerLocatable<T> implements Locatable<T> {
        private final T instance;

        private EagerLocatable(T instance) {
            this.instance = instance;
        }

        @Override
        public T locate() {
            if (instance != null) {
                return instance;
            }
            throw new IllegalStateException();
        }
    }

    private static class LazyLocatable<T> implements Locatable<T> {
        private final LazyInitialisable<T> initializable;
        private T instance;

        private LazyLocatable(LazyInitialisable<T> initializable) {
            this.initializable = initializable;
        }

        @Override
        public T locate() throws Exception {
            synchronized (this) {
                if (instance == null) {
                    instance = initializable.initialize();
                    if (instance == null) {
                        throw new IllegalStateException();
                    }
                }
                return instance;
            }
        }
    }
}
