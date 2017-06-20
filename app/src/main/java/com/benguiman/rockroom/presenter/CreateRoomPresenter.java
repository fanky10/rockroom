package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.RoomManager;
import com.benguiman.rockroom.model.Room;
import com.benguiman.rockroom.view.CreateRoomView;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */

public class CreateRoomPresenter extends BasePresenter<CreateRoomView> {

    private final RoomManager roomManager;

    @Inject
    CreateRoomPresenter(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    @Override
    protected void onViewInitialized() {
        roomManager.getRoom(view.getRoomId(), new RoomManager.OnGetRoomListener() {
            @Override
            public void onGetRoom(Room roomOptional) {

            }

            @Override
            public void onRoomNotFound() {

            }
        });
    }
}
