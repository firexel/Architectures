package com.example.myapplication.vanilla;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.vanilla.legacy.AccessFragment;
import com.example.myapplication.vanilla.legacy.AccessibilityException;
import com.example.myapplication.vanilla.legacy.BaseAccessActivity;
import com.example.myapplication.vanilla.legacy.Command;
import com.example.myapplication.vanilla.legacy.CommandStatus;
import com.example.myapplication.vanilla.legacy.FragmentAccessEvent;
import com.example.myapplication.vanilla.legacy.ResourceObserver;

public class ProfileActivity extends BaseAccessActivity {

    private static final String EXTRA_PROFILE_ID = "profile_id";

    private final ResourceObserver mObserver = new ResourceObserver(Profile.CONTENT_TYPE) {
        @Override
        public void onChanged() {
            getAccessFragment().access(new LoadProfileEvent(mProfileId));
        }

        @Override
        public void onInvalidated() {
            getAccessFragment().access(new LoadProfileEvent(mProfileId));
        }
    };

    private int mProfileId;
    private View mSpinnerView;
    private View mErrorView;
    private TextView mNameText;
    private TextView mSurnameText;
    private ImageView mAvatarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mSpinnerView = findViewById(R.id.spinner_view);
        mErrorView = findViewById(R.id.error_view);
        mNameText = (TextView) findViewById(R.id.name_text);
        mSurnameText = (TextView) findViewById(R.id.surname_text);
        mAvatarView = (ImageView) findViewById(R.id.avatar_img);

        mProfileId = getIntent().getIntExtra(EXTRA_PROFILE_ID, -1);
        if (mProfileId == -1) {
            throw new IllegalArgumentException();
        }
        getAccessFragment().getDataManager().registerObserver(mObserver);
        getAccessFragment().access(new LoadProfileEvent(mProfileId));
    }

    @Override
    protected void onDestroy() {
        getAccessFragment().getDataManager().unregisterObserver(mObserver);
        super.onDestroy();
    }

    private void showProfile(Profile profile) {
        showProgress(false);
        mNameText.setText(profile.getName());
        mSurnameText.setText(profile.getSurname());
        mAvatarView.setImageURI(profile.getAvatarUri());
    }

    private void showProgress(boolean show) {
        if (show) {
            mSpinnerView.setVisibility(View.VISIBLE);
            mNameText.setVisibility(View.INVISIBLE);
            mSurnameText.setVisibility(View.INVISIBLE);
            mAvatarView.setVisibility(View.INVISIBLE);
        } else {
            mSpinnerView.setVisibility(View.INVISIBLE);
            mNameText.setVisibility(View.VISIBLE);
            mSurnameText.setVisibility(View.VISIBLE);
            mAvatarView.setVisibility(View.VISIBLE);
        }
    }

    private void showError() {
        mErrorView.setVisibility(View.VISIBLE);
    }

    private static class LoadProfileEvent extends FragmentAccessEvent<AccessFragment> {
        private final int mId;

        public LoadProfileEvent(int profileId) {
            mId = profileId;
        }

        @Override
        public void access() throws AccessibilityException {
            Profile profile = getFragmentOrThrow().getDataManager().getProfileById(mId, this);
            if (profile != null) {
                ((ProfileActivity) getFragmentOrThrow().getActivity()).showProfile(profile);
            } else {
                ((ProfileActivity) getFragmentOrThrow().getActivity()).showProgress(true);
            }
        }

        @Override
        public void onComplete(AccessFragment fragment, Command command) {
            super.onComplete(fragment, command);
            if (!command.isCancelled() && !(command.getResult() instanceof CommandStatus.OK)) {
                ((ProfileActivity) fragment.getActivity()).showError();
            }
        }
    }
}
