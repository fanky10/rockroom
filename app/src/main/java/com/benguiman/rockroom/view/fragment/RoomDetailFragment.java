package com.benguiman.rockroom.view.fragment;

import android.os.Bundle;

import com.benguiman.rockroom.presenter.RoomDetailPresenter;
import com.benguiman.rockroom.view.RoomDetailView;
import com.benguiman.rockroom.view.model.RoomViewModel;

/**
 * @author benjamin.massello.
 */

public class RoomDetailFragment extends BaseFragment<RoomDetailPresenter> implements RoomDetailView {

    public static final String ROOM_ID = "room_id";

    public static CreateRoomFragment newInstance(String roomId) {
        Bundle bundle = new Bundle();
        bundle.putString(ROOM_ID, roomId);
        CreateRoomFragment createRoomFragment = new CreateRoomFragment();
        createRoomFragment.setArguments(bundle);
        return createRoomFragment;
    }

    @Override
    protected RoomDetailPresenter obtainPresenter() {
        return getRockRoomComponent().getRoomDetailPresenter();
    }

    @Override
    public String getRoomId() {
        return getArguments().getString(ROOM_ID);
    }

    @Override
    public void onGetRoom(RoomViewModel roomViewModel) {

    }

    @Override
    public void onRoomNotFound() {

    }
}
