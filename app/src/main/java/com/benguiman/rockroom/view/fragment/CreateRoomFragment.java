package com.benguiman.rockroom.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benguiman.rockroom.R;
import com.benguiman.rockroom.presenter.CreateRoomPresenter;
import com.benguiman.rockroom.view.CreateRoomView;

import butterknife.ButterKnife;

/**
 * @author benjamin.massello.
 */

public class CreateRoomFragment extends BaseFragment<CreateRoomPresenter> implements CreateRoomView {

    public static final String ROOM_ID = "room_id";

    public static CreateRoomFragment newInstance(String roomId) {
        Bundle bundle = new Bundle();
        bundle.putString(ROOM_ID, roomId);
        CreateRoomFragment createRoomFragment = new CreateRoomFragment();
        createRoomFragment.setArguments(bundle);
        return createRoomFragment;
    }

    @Override
    protected CreateRoomPresenter obtainPresenter() {
        return getRockRoomComponent().getCreateRoomPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_room, container, false);
        ButterKnife.bind(this, view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public String getRoomId() {
        return getArguments().getString(ROOM_ID);
    }
}
