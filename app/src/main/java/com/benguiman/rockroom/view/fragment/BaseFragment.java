package com.benguiman.rockroom.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.benguiman.rockroom.di.component.RockRoomComponent;
import com.benguiman.rockroom.di.component.RockRoomComponentProvider;
import com.benguiman.rockroom.presenter.BasePresenter;
import com.benguiman.rockroom.view.BaseView;

/**
 * @author benjamin.massello.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

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
        return ((RockRoomComponentProvider) getActivity().getApplication()).getRockRoomComponent();
    }

    protected abstract T obtainPresenter();

}
