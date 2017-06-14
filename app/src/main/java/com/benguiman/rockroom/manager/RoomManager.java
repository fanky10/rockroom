package com.benguiman.rockroom.manager;

import com.benguiman.rockroom.model.Room;
import com.google.common.base.Optional;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */

public class RoomManager extends BaseManager {

    public static final String ROOMS = "rooms";
    private final UserManager userManager;

    public interface OnGetRoomListener {
        void onGetRoom(Optional<Room> roomOptional);
    }

    @Inject
    public RoomManager(UserManager userManager) {
        super();
        this.userManager = userManager;
    }

    public void saveRoom(Room room) {
        DatabaseReference reference = database
                .child(ROOMS)
                .push();

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.id = reference.getKey();

        roomDTO.name = room.getName();
        roomDTO.address = room.getAddress();
        roomDTO.photoUrl = room.getPhotoUrl();
        roomDTO.ownerId = room.getOwnerId();

        reference.setValue(roomDTO);
    }

    public void getRoom(String id, final OnGetRoomListener listener) {
        DatabaseReference reference = database
                .child(ROOMS)
                .child(id);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                RoomDTO roomDTO = dataSnapshot.getValue(RoomDTO.class);
                Room room = new Room.Builder()
                        .id(roomDTO.id)
                        .name(roomDTO.name)
                        .address(roomDTO.address)
                        .photoUrl(roomDTO.photoUrl)
                        .ownerId(roomDTO.ownerId)
                        .build();
                listener.onGetRoom(Optional.of(room));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onGetRoom(Optional.<Room> absent());
            }
        });
    }


}
