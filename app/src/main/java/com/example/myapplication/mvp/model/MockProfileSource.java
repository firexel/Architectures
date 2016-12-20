package com.example.myapplication.mvp.model;

import android.net.Uri;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Alex on 16.11.2016.
 */
public class MockProfileSource implements ProfileSource {

    @Override
    public Future<Profile> loadProfile(int profileId, final CompleteListener<Profile> completeListener) {
        final MockProfile profile = new MockProfile();
        FutureTask<Profile> task = new FutureTask<>(new Callable<Profile>() {
            @Override
            public Profile call() throws Exception {
                return profile;
            }
        });
        task.run();
        completeListener.onLoaded(profile);
        return task;
    }

    private static class MockProfile implements Profile {
        @Override
        public String getName() {
            return "Alex";
        }

        @Override
        public String getSurname() {
            return "Naumov";
        }

        @Override
        public Uri getAvatarUri() {
            return Uri.parse("https://habrastorage.org/getpro/habr/avatars/2cc/1d7/75b/2cc1d775bde34946eaaab89940e1e32e.png");
        }
    }
}
