package com.benguiman.rockroom.presenter;

import com.benguiman.rockroom.manager.RoomManager;
import com.benguiman.rockroom.model.Room;
import com.benguiman.rockroom.view.RoomListView;
import com.benguiman.rockroom.view.model.RoomViewModelFactory;

import java.util.List;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */

public class RoomListPresenter extends BasePresenter<RoomListView> {

    private final RoomManager roomManager;
    private final RoomViewModelFactory roomViewModelFactory;

    @Inject
    RoomListPresenter(RoomManager roomManager, RoomViewModelFactory roomViewModelFactory) {
        this.roomManager = roomManager;
        this.roomViewModelFactory = roomViewModelFactory;
    }

    @Override
    public void onViewInitialized() {
        roomManager.getRoomList(new RoomManager.OnGetRoomListListener() {
            @Override
            public void onGetRoomList(List<Room> roomList) {
                view.loadRoomList(roomViewModelFactory.create(roomList));
            }
        });
    }
}
