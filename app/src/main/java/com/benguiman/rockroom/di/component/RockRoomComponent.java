package com.benguiman.rockroom.di.component;

import com.benguiman.rockroom.RockRoomActivityLifecycleCallbacks;
import com.benguiman.rockroom.di.module.AppModule;
import com.benguiman.rockroom.di.module.ManagerModule;
import com.benguiman.rockroom.presenter.CreateRoomPresenter;
import com.benguiman.rockroom.presenter.MainPresenter;
import com.benguiman.rockroom.presenter.RoomListPresenter;
import com.benguiman.rockroom.presenter.SignInPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author benjamin.massello.
 */
@Singleton
@Component(modules = {AppModule.class, ManagerModule.class})
public interface RockRoomComponent {
    RockRoomActivityLifecycleCallbacks getRockRoomActivityLifecycleCallbacks();

    MainPresenter getMainPresenter();

    SignInPresenter getSignInPresenter();

    RoomListPresenter getRoomListPresenter();

    CreateRoomPresenter getCreateRoomPresenter();
}
