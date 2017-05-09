package com.benguiman.rockroom.component;

import com.benguiman.rockroom.RockRoomActivityLifecycleCallbacks;
import com.benguiman.rockroom.module.AppModule;
import com.benguiman.rockroom.module.ManagerModule;
import com.benguiman.rockroom.view.activity.BaseActivity;
import com.benguiman.rockroom.view.activity.SignInActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author benjamin.massello on 4/11/17.
 */
@Singleton
@Component(modules = {AppModule.class, ManagerModule.class})
public interface RockRoomComponent {
    RockRoomActivityLifecycleCallbacks getRockRoomActivityLifecycleCallbacks();

    void inject(BaseActivity baseActivity);
    void inject(SignInActivity signInActivity);
}
