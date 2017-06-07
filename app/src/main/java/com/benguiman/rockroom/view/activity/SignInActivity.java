package com.benguiman.rockroom.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.benguiman.rockroom.R;
import com.benguiman.rockroom.component.RockRoomComponentProvider;
import com.benguiman.rockroom.presenter.SignInPresenter;
import com.benguiman.rockroom.view.SignInView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends BaseActivity implements SignInView, GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 1;
    private static final String TAG = SignInActivity.class.getSimpleName();
    @Inject
    SignInPresenter presenter;
    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
        initializeGoogleApiClient();
    }

    private void init() {
        ((RockRoomComponentProvider) getApplication()).getRockRoomComponent().inject(this);
        ButterKnife.bind(this);
        presenter.init(this);
    }

    private void initializeGoogleApiClient() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }


    @OnClick(R.id.sign_in_button)
    public void onSignInButtonClick() {
        presenter.onSignInButtonClick();
    }

    @Override
    public void launchSignInIntent() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
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

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            firebaseAuthWithGoogle(result.getSignInAccount());
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, task -> presenter.handleSignInResult(task.isSuccessful()));
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }
}
