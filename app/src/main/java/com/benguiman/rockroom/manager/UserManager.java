package com.benguiman.rockroom.manager;

import android.support.annotation.NonNull;

import com.benguiman.rockroom.model.User;
import com.google.common.base.Optional;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author benjamin.massello.
 */
@Singleton
public class UserManager extends BaseManager implements FirebaseAuth.AuthStateListener {

    @Inject
    public UserManager() {
        super();
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        // TODO trigger log out
    }

    public Optional<User> getUser() {
        User user = null;
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
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
        return firebaseAuth.getCurrentUser() != null;
    }
}
