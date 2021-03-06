package com.benguiman.rockroom.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.benguiman.rockroom.di.component.RockRoomComponent;
import com.benguiman.rockroom.di.component.RockRoomComponentProvider;
import com.benguiman.rockroom.presenter.BasePresenter;
import com.benguiman.rockroom.view.BaseView;

/**
 * @author benjamin.massello on 4/11/17.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = obtainPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.init((BaseView) this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onViewPause();
    }

    protected RockRoomComponent getRockRoomComponent() {
        return ((RockRoomComponentProvider) getApplication()).getRockRoomComponent();
    }

    protected abstract T obtainPresenter();
}
