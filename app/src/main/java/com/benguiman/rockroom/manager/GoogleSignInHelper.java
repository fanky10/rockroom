package com.benguiman.rockroom.manager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.benguiman.rockroom.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

/**
 * Handles the Google account sign in flow using Firebase.
 *
 * @author benjamin.massello.
 */
public class GoogleSignInHelper implements GoogleApiClient.OnConnectionFailedListener {
    private static final int RC_SIGN_IN = 1;

    private final FragmentActivity activity;
    private GoogleApiClient googleApiClient;

    public static GoogleSignInHelper newInstance(FragmentActivity activity) {
        return new GoogleSignInHelper(activity);
    }

    private GoogleSignInHelper(FragmentActivity activity) {
        this.activity = activity;
        initializeGoogleApiClient();
    }

    private void initializeGoogleApiClient() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(activity)
                .enableAutoManage(activity /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    public void launchSignInIntent() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void firebaseAuthWithGoogle(int requestCode, Intent data, OnCompleteListener<AuthResult> task) {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            if(signInAccount != null) {
                AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                FirebaseAuth.getInstance().signInWithCredential(credential)
                            .addOnCompleteListener(activity, task);
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
