package com.benguiman.rockroom;

import android.app.Application;

import com.benguiman.rockroom.component.DaggerRockRoomComponent;
import com.benguiman.rockroom.component.RockRoomComponent;
import com.benguiman.rockroom.module.AppModule;
import com.benguiman.rockroom.module.ManagerModule;

/**
 * @author benjamin.massello on 4/11/17.
 */

public class RockRoomApplication extends Application {

    RockRoomComponent rockRoomComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        rockRoomComponent = DaggerRockRoomComponent.builder()
                                                   .appModule(new AppModule(this))
                                                   .managerModule(new ManagerModule())
                                                   .build();
        registerActivityLifecycleCallbacks(new RockRoomActivityLifecycleCallbacks());
    }

    public RockRoomComponent getRockRoomComponent() {
        return rockRoomComponent;
    }
}
