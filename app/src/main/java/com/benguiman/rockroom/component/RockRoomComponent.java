package com.benguiman.rockroom.component;

import com.benguiman.rockroom.module.AppModule;
import com.benguiman.rockroom.module.ManagerModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author benjamin.massello on 4/11/17.
 */
@Singleton
@Component(modules = {AppModule.class, ManagerModule.class})
public interface RockRoomComponent {

}
