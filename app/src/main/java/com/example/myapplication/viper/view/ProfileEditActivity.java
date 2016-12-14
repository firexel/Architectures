package com.example.myapplication.viper.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mvp.Locator;
import com.example.myapplication.viper.presenter.PresenterFactory;
import com.example.myapplication.viper.presenter.ProfileEditPresenter;

/**
 * Created by Alex on 13.12.2016.
 */

public class ProfileEditActivity extends AppCompatActivity implements ProfileEditPresenter.View {

    private static final String EXTRA_PROFILE_ID = "profile_id";

    private View mSpinnerView;
    private View mErrorView;
    private TextView mNameText;
    private TextView mSurnameText;
    private ImageView mAvatarView;

    private ProfileEditPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        mSpinnerView = findViewById(R.id.spinner_view);
        mErrorView = findViewById(R.id.error_view);
        mNameText = (TextView) findViewById(R.id.name_text);
        mSurnameText = (TextView) findViewById(R.id.surname_text);
        mAvatarView = (ImageView) findViewById(R.id.avatar_img);
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileEditPresenter.EditViewModel vm = new ProfileEditPresenter.EditViewModel(
                        mNameText.getText().toString(),
                        mSurnameText.getText().toString()
                );
                mPresenter.onEditProfile(vm);
            }
        });

        mPresenter = Locator.from(this)
                .locate(PresenterFactory.class)
                .createProfileEditPresenter(getIntent().getIntExtra(EXTRA_PROFILE_ID, 1), this);
    }

    @Override
    public void showProfile(ProfileEditPresenter.ViewModel vm) {
        mNameText.setText(vm.getName());
        mSurnameText.setText(vm.getSurname());
        mAvatarView.setImageURI(vm.getAvatar());
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

    @Override
    public void showInvalidProfile() {
        new AlertDialog.Builder(this)
                .setTitle("Invalid credentials")
                .setPositiveButton("Ok", null)
                .show();
    }
}
