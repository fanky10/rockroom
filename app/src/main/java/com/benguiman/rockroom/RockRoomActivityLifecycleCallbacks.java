package com.benguiman.rockroom;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.benguiman.rockroom.manager.UserManager;

import javax.inject.Inject;

/**
 * @author benjamin.massello on 4/11/17.
 */
public class RockRoomActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    @Inject
    UserManager userManager;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        userManager.addAuthStateListener();
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {
        userManager.removeAuthStateListener();
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
