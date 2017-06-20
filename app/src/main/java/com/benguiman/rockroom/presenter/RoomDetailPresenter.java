package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.RoomManager;
import com.benguiman.rockroom.model.Room;
import com.benguiman.rockroom.view.RoomDetailView;
import com.benguiman.rockroom.view.model.RoomViewModelFactory;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */

public class RoomDetailPresenter extends BasePresenter<RoomDetailView> {

    private final RoomManager roomManager;
    private final RoomViewModelFactory roomViewModelFactory;

    @Inject
    RoomDetailPresenter(RoomManager roomManager, RoomViewModelFactory roomViewModelFactory) {
        this.roomManager = roomManager;
        this.roomViewModelFactory = roomViewModelFactory;
    }

    @Override
    protected void onViewInitialized() {
        roomManager.getRoom(view.getRoomId(), new RoomManager.OnGetRoomListener() {
            @Override
            public void onGetRoom(Room room) {
                view.onGetRoom(roomViewModelFactory.create(room));
            }

            @Override
            public void onRoomNotFound() {
                view.onRoomNotFound();
            }
        });

    }
}
