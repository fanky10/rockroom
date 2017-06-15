package com.benguiman.rockroom.presenter;

import android.util.Log;

import com.benguiman.rockroom.manager.RoomManager;
import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.model.Room;
import com.benguiman.rockroom.view.SignInView;
import com.benguiman.rockroom.view.activity.SignInActivity;
import com.google.common.base.Optional;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 4/3/17.
 */

public class SignInPresenter {

    private SignInView view;
    private UserManager userManager;

    @Inject
    public SignInPresenter(UserManager userManager){
        this.userManager = userManager;
    }

    public void init(SignInView view){
        this.view = view;
    }

    public void handleSignInResult(boolean success) {
        if (success) {
            view.launchMainActivity();
        }
    }

    public void onStart() {
        if (userManager.isUserLoggedIn()) {
            view.launchMainActivity();
        }
    }
}
