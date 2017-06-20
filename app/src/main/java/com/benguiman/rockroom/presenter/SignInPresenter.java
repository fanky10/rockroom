package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.view.SignInView;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 4/3/17.
 */

public class SignInPresenter extends BasePresenter<SignInView> {

    private UserManager userManager;

    @Inject
    SignInPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    public void handleSignInResult(boolean success) {
        if (success) {
            view.launchMainActivity();
        }
    }

    @Override
    protected void onViewInitialized() {
        super.onViewInitialized();
        if (userManager.isUserLoggedIn()) {
            view.launchMainActivity();
        }
    }
}
