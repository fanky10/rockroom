package com.benguiman.rockroom.manager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @author benjamin.massello.
 */

abstract class BaseManager {

    protected final FirebaseAuth firebaseAuth;
    protected final DatabaseReference database;

    BaseManager() {
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
    }
}
