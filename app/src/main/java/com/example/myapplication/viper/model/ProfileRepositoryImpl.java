package com.example.myapplication.viper.model;

/**
 * Created by kirillf on 12/14/16.
 */

public class ProfileRepositoryImpl implements ProfileRepository {
    private final ProfileSource local;
    private final ProfileSource remote;

    public ProfileRepositoryImpl(ProfileSource local, ProfileSource remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public void getProfile(int id, final RepositoryCallback<Profile> callback) {
        local.loadProfile(id, new ProfileSource.CompleteListener<Profile>() {
            @Override
            public void onLoaded(Profile item) {
                if (item != null) {
                    callback.onComplete(item);
                }
            }

            @Override
            public void onError(Throwable e) {
                callback.onFailure(e);
            }
        });

        // TODO: getFromRemote
    }

    @Override
    public void updateProfile(final int id, Profile profile, final RepositoryCallback<Integer> callback) {
        local.updateProfile(id, profile, new ProfileSource.CompleteListener<Integer>() {
            @Override
            public void onLoaded(Integer item) {
                callback.onComplete(item);
            }

            @Override
            public void onError(Throwable e) {
                callback.onFailure(e);
            }
        });

        //TODO: updateRemote
    }
}
