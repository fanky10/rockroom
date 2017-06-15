package com.benguiman.rockroom.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.benguiman.rockroom.R;
import com.benguiman.rockroom.di.component.RockRoomComponentProvider;
import com.benguiman.rockroom.manager.GoogleSignInHelper;
import com.benguiman.rockroom.presenter.SignInPresenter;
import com.benguiman.rockroom.view.SignInView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends BaseActivity implements SignInView {

    @Inject
    SignInPresenter presenter;
    private GoogleSignInHelper googleSignInHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
    }

    private void init() {
        ((RockRoomComponentProvider) getApplication()).getRockRoomComponent().inject(this);
        ButterKnife.bind(this);
        presenter.init(this);
        googleSignInHelper = GoogleSignInHelper.newInstance(this);
    }

    @OnClick(R.id.sign_in_button)
    public void onSignInButtonClick() {
        googleSignInHelper.launchSignInIntent();
    }

    @Override
    public void launchMainActivity() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        googleSignInHelper.firebaseAuthWithGoogle(requestCode, data,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        presenter.handleSignInResult(task.isSuccessful());
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }
}
