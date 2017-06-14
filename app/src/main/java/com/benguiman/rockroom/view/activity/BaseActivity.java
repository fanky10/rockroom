package com.benguiman.rockroom.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.benguiman.rockroom.di.component.RockRoomComponentProvider;

/**
 * @author benjamin.massello on 4/11/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RockRoomComponentProvider) getApplication()).getRockRoomComponent().inject(this);
    }
}
