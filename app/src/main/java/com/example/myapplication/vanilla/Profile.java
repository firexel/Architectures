package com.example.myapplication.vanilla;

import android.net.Uri;

/**
 * Created by Alex on 15.11.2016.
 */
public class Profile {
    public static final String CONTENT_TYPE = "content-type";

    private String mName;
    private String mSurname;
    private int mAge;
    private Uri mAvatarUri;

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public Uri getAvatarUri() {
        return mAvatarUri;
    }

    public void setAvatarUri(Uri mAvatarUri) {
        this.mAvatarUri = mAvatarUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (mAge != profile.mAge) return false;
        if (mName != null ? !mName.equals(profile.mName) : profile.mName != null) return false;
        if (mSurname != null ? !mSurname.equals(profile.mSurname) : profile.mSurname != null)
            return false;
        if (mAvatarUri != null ? !mAvatarUri.equals(profile.mAvatarUri) : profile.mAvatarUri != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mName != null ? mName.hashCode() : 0;
        result = 31 * result + (mSurname != null ? mSurname.hashCode() : 0);
        result = 31 * result + mAge;
        result = 31 * result + (mAvatarUri != null ? mAvatarUri.hashCode() : 0);
        return result;
    }
}
