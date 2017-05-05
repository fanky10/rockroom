package com.benguiman.rockroom.model;

import com.google.firebase.auth.FirebaseUser;

/**
 * @author benjamin.massello on 4/11/17.
 */

public class User {
    FirebaseUser firebaseUser;

    public User(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

}
