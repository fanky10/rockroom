package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.RoomManager;
import com.benguiman.rockroom.model.Room;
import com.benguiman.rockroom.view.CreateRoomView;
import com.benguiman.rockroom.view.model.RoomViewModel;
import com.benguiman.rockroom.view.model.RoomViewModelFactory;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */

public class CreateRoomPresenter extends BasePresenter<CreateRoomView> {

    private final RoomManager roomManager;
    private final RoomViewModelFactory roomViewModelFactory;

    @Inject
    CreateRoomPresenter(RoomManager roomManager, RoomViewModelFactory roomViewModelFactory) {
        this.roomManager = roomManager;
        this.roomViewModelFactory = roomViewModelFactory;
    }

    public void saveRoom(RoomViewModel roomViewModel) {
        Room room = new Room.Builder()
                .name(roomViewModel.getName())
                .address(roomViewModel.getAddress())
                .build();
        roomManager.saveRoom(room, new RoomManager.OnSaveRoomListener() {
            @Override
            public void onSaveRoom(Room room) {

            }

            @Override
            public void onError() {

            }
        });
    }
}
