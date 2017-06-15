package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.view.SignInView;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 4/3/17.
 */

public class SignInPresenter {

    private SignInView view;
    private UserManager userManager;

    @Inject
    SignInPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    public void init(SignInView view) {
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
