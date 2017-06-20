package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.view.BaseView;

/**
 * @author benjamin.massello.
 */

public abstract class BasePresenter<T extends BaseView> {

    protected T view;

    public final void init(BaseView view) {
        this.view = (T) view;
        onViewInitialized();
    }

    protected void onViewInitialized() {
        // Do nothing
    }

    public void onViewPause() {
        // Do nothing
    }
}
