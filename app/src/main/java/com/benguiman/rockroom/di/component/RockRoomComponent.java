package com.benguiman.rockroom.di.component;

import com.benguiman.rockroom.RockRoomActivityLifecycleCallbacks;
import com.benguiman.rockroom.di.module.AppModule;
import com.benguiman.rockroom.di.module.ManagerModule;
import com.benguiman.rockroom.view.activity.BaseActivity;
import com.benguiman.rockroom.view.activity.MainActivity;
import com.benguiman.rockroom.view.activity.SignInActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author benjamin.massello.
 */
@Singleton
@Component(modules = {AppModule.class, ManagerModule.class})
public interface RockRoomComponent {
    RockRoomActivityLifecycleCallbacks getRockRoomActivityLifecycleCallbacks();

    void inject(BaseActivity baseActivity);

    void inject(SignInActivity signInActivity);

    void inject(MainActivity mainActivity);
}
