package com.benguiman.rockroom.view;

import com.benguiman.rockroom.view.model.UserViewModel;

/**
 * @author benjamin.massello on 6/6/17.
 */

public interface MainView extends BaseView {
    void loadUserData(UserViewModel userViewModel);
}
