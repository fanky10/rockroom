package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.model.User;
import com.benguiman.rockroom.view.MainView;
import com.benguiman.rockroom.view.model.UserViewModel;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 6/6/17.
 */

public class MainPresenter {

    private final UserManager userManager;
    private MainView view;

    @Inject
    public MainPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    public void init(MainView view) {
        this.view = view;
    }

    public void loadUserData() {
        if (userManager.getUser().isPresent()) {
            User user = userManager.getUser().get();
            UserViewModel userViewModel = new UserViewModel.Builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .photoUri(user.getPhotoUri())
                    .build();
            view.loadUserData(userViewModel);
        }
    }

}
