package com.benguiman.rockroom.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.benguiman.rockroom.R;
import com.benguiman.rockroom.presenter.CreateRoomPresenter;
import com.benguiman.rockroom.view.CreateRoomView;
import com.benguiman.rockroom.view.model.RoomViewModel;

import butterknife.ButterKnife;

/**
 * @author benjamin.massello.
 */

public class CreateRoomFragment extends BaseFragment<CreateRoomPresenter> implements CreateRoomView {

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
    public void onSaveRoom(RoomViewModel roomViewModel) {
        Toast.makeText(getContext(), R.string.room_saved, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveRoomError() {
        Toast.makeText(getContext(), R.string.error_saving_the_room, Toast.LENGTH_SHORT).show();
    }
}
