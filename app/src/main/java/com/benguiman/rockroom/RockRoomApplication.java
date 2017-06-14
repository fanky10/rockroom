package com.benguiman.rockroom;

import android.app.Application;

import com.benguiman.rockroom.di.component.DaggerRockRoomComponent;
import com.benguiman.rockroom.di.component.RockRoomComponent;
import com.benguiman.rockroom.di.component.RockRoomComponentProvider;
import com.benguiman.rockroom.di.module.AppModule;
import com.benguiman.rockroom.di.module.ManagerModule;

/**
 * @author benjamin.massello.
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
