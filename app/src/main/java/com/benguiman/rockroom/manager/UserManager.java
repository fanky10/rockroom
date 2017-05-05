package com.benguiman.rockroom.manager;

import android.support.annotation.NonNull;

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

    private final FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Inject
    public UserManager() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    public Optional<User> getUser() {
        if (firebaseUser != null) {
            return Optional.of(new User(firebaseUser));
        } else {
            return Optional.absent();
        }
    }

    public void addAuthStateListener() {
        firebaseAuth.addAuthStateListener(this);
    }

    public void removeAuthStateListener() {
        firebaseAuth.removeAuthStateListener(this);
    }

    public boolean isUserLoggedIn() {
        return firebaseUser != null;
    }
}
