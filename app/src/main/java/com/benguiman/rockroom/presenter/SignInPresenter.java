package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.view.SignInView;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 4/3/17.
 */

public class SignInPresenter {

    private SignInView view;
    @Inject
    UserManager userManager;

    public static SignInPresenter fromView(SignInView view) {
        SignInPresenter signInPresenter = new SignInPresenter();
        signInPresenter.view = view;
        return signInPresenter;
    }

    public void onSignInButtonClick() {
        view.launchSignInIntent();
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
