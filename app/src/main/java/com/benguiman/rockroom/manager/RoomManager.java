package com.benguiman.rockroom.manager;

import com.benguiman.rockroom.model.Room;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author benjamin.massello.
 */
@Singleton
public class RoomManager extends BaseManager {

    private static final String ROOMS = "rooms";
    private final UserManager userManager;

    public interface OnGetRoomListener {
        void onGetRoom(Room roomOptional);

        void onRoomNotFound();
    }

    public interface OnGetRoomListListener {
        void onGetRoomList(List<Room> roomList);
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
        final DatabaseReference reference = database
                .child(ROOMS)
                .child(id);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reference.removeEventListener(this);
                RoomDTO roomDTO = dataSnapshot.getValue(RoomDTO.class);
                if (roomDTO != null) {
                    listener.onGetRoom(transformIntoRoom(roomDTO));
                } else {
                    listener.onRoomNotFound();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                reference.removeEventListener(this);
                listener.onRoomNotFound();
            }
        });
    }

    public void getRoomList(final OnGetRoomListListener listener) {
        final DatabaseReference reference = database
                .child(ROOMS);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reference.removeEventListener(this);
                List<Room> roomList = new ArrayList<>();
                for (DataSnapshot roomSnapshot : dataSnapshot.getChildren()) {
                    RoomDTO roomDTO = roomSnapshot.getValue(RoomDTO.class);
                    if (roomDTO != null) {
                        roomList.add(transformIntoRoom(roomDTO));
                    }
                }
                listener.onGetRoomList(roomList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                reference.removeEventListener(this);
                listener.onGetRoomList(new ArrayList<Room>());
            }
        });

    }

    private Room transformIntoRoom(RoomDTO roomDTO) {
        return new Room.Builder()
                .id(roomDTO.id)
                .name(roomDTO.name)
                .address(roomDTO.address)
                .photoUrl(roomDTO.photoUrl)
                .ownerId(roomDTO.ownerId)
                .build();
    }

}
