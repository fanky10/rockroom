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

public class RoomListPresenter {

    private final RoomManager roomManager;
    private final RoomViewModelFactory roomViewModelFactory;
    private RoomListView view;

    @Inject
    public RoomListPresenter(RoomManager roomManager, RoomViewModelFactory roomViewModelFactory) {
        this.roomManager = roomManager;
        this.roomViewModelFactory = roomViewModelFactory;
    }

    public void init(final RoomListView view) {
        this.view = view;
        roomManager.getRoomList(new RoomManager.OnGetRoomListListener() {
            @Override
            public void onGetRoomList(List<Room> roomList) {
                view.loadRoomList(roomViewModelFactory.create(roomList));
            }
        });
    }
}
