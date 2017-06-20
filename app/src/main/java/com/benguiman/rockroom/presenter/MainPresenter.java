package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.model.User;
import com.benguiman.rockroom.view.MainView;
import com.benguiman.rockroom.view.model.UserViewModel;
import com.google.common.base.Optional;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private final UserManager userManager;

    @Inject
    MainPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    protected void onViewInitialized() {
        Optional<User> userOptional = userManager.getUser();
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserViewModel userViewModel = new UserViewModel.Builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .photoUri(user.getPhotoUri())
                    .build();
            view.loadUserData(userViewModel);
        }
    }
}
