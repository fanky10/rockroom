package com.benguiman.rockroom.manager;

import android.support.annotation.NonNull;
import android.util.Log;

import com.benguiman.rockroom.model.User;
import com.google.common.base.Optional;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author benjamin.massello on 4/11/17.
 */
@Singleton
public class UserManager implements FirebaseAuth.AuthStateListener {

    private final static String TAG = UserManager.class.getSimpleName();

    private final FirebaseAuth firebaseAuth;

    @Inject
    public UserManager() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        // TODO trigger log out
        Log.d(TAG, "onAuthStateChanged " + String.valueOf(firebaseAuth.getCurrentUser()));
    }

    public Optional<User> getUser() {
        Log.d(TAG, "getUser " + String.valueOf(firebaseAuth.getCurrentUser()));
        User user = null;
        FirebaseUser firebaseUser = getFirebaseUser();
        if (firebaseUser != null) {
            user = new User.Builder()
                    .name(firebaseUser.getDisplayName())
                    .email(firebaseUser.getEmail())
                    .photoUri(firebaseUser.getPhotoUrl())
                    .id(firebaseUser.getUid())
                    .build();
        }

        return Optional.fromNullable(user);
    }

    public void addAuthStateListener() {
        firebaseAuth.addAuthStateListener(this);
    }

    public void removeAuthStateListener() {
        firebaseAuth.removeAuthStateListener(this);
    }

    public boolean isUserLoggedIn() {
        return getFirebaseUser() != null;
    }

    private FirebaseUser getFirebaseUser(){
        //TODO this method is not returning a valid user
        return FirebaseAuth.getInstance().getCurrentUser();
    }
}
