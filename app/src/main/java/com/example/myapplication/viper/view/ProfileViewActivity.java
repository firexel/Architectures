package com.example.myapplication.viper.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mvp.Locator;
import com.example.myapplication.viper.presenter.PresenterFactory;
import com.example.myapplication.viper.presenter.ProfileViewPresenter;

/**
 * Created by Alex on 15.11.2016.
 */
public class ProfileViewActivity extends AppCompatActivity implements ProfileViewPresenter.View {

    private static final String EXTRA_PROFILE_ID = "profile_id";

    private View mSpinnerView;
    private View mErrorView;
    private TextView mNameText;
    private TextView mSurnameText;
    private ImageView mAvatarView;

    private ProfileViewPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        mSpinnerView = findViewById(R.id.spinner_view);
        mErrorView = findViewById(R.id.error_view);
        mNameText = (TextView) findViewById(R.id.name_text);
        mSurnameText = (TextView) findViewById(R.id.surname_text);
        mAvatarView = (ImageView) findViewById(R.id.avatar_img);
        findViewById(R.id.button_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onEditProfile();
            }
        });

        mPresenter = Locator.from(this)
                .locate(PresenterFactory.class)
                .createProfileViewPresenter(getIntent().getIntExtra(EXTRA_PROFILE_ID, 1), this);
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
