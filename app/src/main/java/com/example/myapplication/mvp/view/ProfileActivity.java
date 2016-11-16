package com.example.myapplication.mvp.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mvp.Locator;
import com.example.myapplication.mvp.presenter.PresenterFactory;
import com.example.myapplication.mvp.presenter.ProfilePresenter;

/**
 * Created by Alex on 15.11.2016.
 */
public class ProfileActivity extends AppCompatActivity implements ProfilePresenter.View {

    private static final String EXTRA_PROFILE_ID = "profile_id";

    private View mSpinnerView;
    private View mErrorView;
    private TextView mNameText;
    private TextView mSurnameText;
    private ImageView mAvatarView;

    private ProfilePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mSpinnerView = findViewById(R.id.spinner_view);
        mErrorView = findViewById(R.id.error_view);
        mNameText = (TextView) findViewById(R.id.name_text);
        mSurnameText = (TextView) findViewById(R.id.surname_text);
        mAvatarView = (ImageView) findViewById(R.id.avatar_img);

        mPresenter = Locator.from(this)
                .locate(PresenterFactory.class)
                .createProfilePresenter(getIntent().getIntExtra(EXTRA_PROFILE_ID, -1), this);

        mPresenter.onLoadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        mPresenter = null;
    }

    @Override
    public void showName(String name) {
        mNameText.setText(name);
    }

    @Override
    public void showSurname(String surname) {
        mSurnameText.setText(surname);
    }

    @Override
    public void showAvatar(Uri avatar) {
        mAvatarView.setImageURI(avatar);
    }

    @Override
    public void showError() {
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        mErrorView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress() {
        mSpinnerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mSpinnerView.setVisibility(View.INVISIBLE);
    }
}
