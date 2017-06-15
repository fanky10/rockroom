package com.benguiman.rockroom.view.model;

import com.benguiman.rockroom.model.Room;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author benjamin.massello.
 */
@Singleton
public class RoomViewModelFactory {

    @Inject
    public RoomViewModelFactory() {

    }

    public RoomViewModel create(Room room) {
        return new RoomViewModel.Builder()
                .id(room.getId())
                .name(room.getName())
                .address(room.getAddress())
                .photoUrl(room.getPhotoUrl())
                .ownerId(room.getOwnerId())
                .build();
    }

    public List<RoomViewModel> create(List<Room> roomList) {
        List<RoomViewModel> roomViewModelList = new ArrayList<>();
        for (Room room : roomList) {
            roomViewModelList.add(create(room));
        }
        return roomViewModelList;
    }
}
