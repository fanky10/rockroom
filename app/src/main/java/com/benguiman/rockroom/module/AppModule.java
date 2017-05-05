package com.benguiman.rockroom.module;

import com.benguiman.rockroom.RockRoomApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author benjamin.massello on 4/11/17.
 */
@Module
public class AppModule {
    RockRoomApplication application;

    public AppModule(RockRoomApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    RockRoomApplication provideRockRoomApplication() {
        return application;
    }

}
