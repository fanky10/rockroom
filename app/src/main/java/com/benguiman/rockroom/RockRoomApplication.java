package com.benguiman.rockroom;

import android.app.Application;

import com.benguiman.rockroom.component.DaggerRockRoomComponent;
import com.benguiman.rockroom.component.RockRoomComponent;
import com.benguiman.rockroom.component.RockRoomComponentProvider;
import com.benguiman.rockroom.manager.UserManager;
import com.benguiman.rockroom.module.AppModule;
import com.benguiman.rockroom.module.ManagerModule;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 4/11/17.
 */

public class RockRoomApplication extends Application implements RockRoomComponentProvider{

    RockRoomComponent rockRoomComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        rockRoomComponent = DaggerRockRoomComponent.builder()
                                                   .appModule(new AppModule(this))
                                                   .managerModule(new ManagerModule())
                                                   .build();
        registerActivityLifecycleCallbacks(rockRoomComponent.getRockRoomActivityLifecycleCallbacks());
    }

    public RockRoomComponent getRockRoomComponent() {
        return rockRoomComponent;
    }
}
