package com.benguiman.rockroom.manager;

import android.support.annotation.Nullable;

import com.benguiman.rockroom.model.Room;
import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
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
    private final TransformIntoRoomDTOFunction toRoomDTO;
    private final TransformIntoRoomFunction toRoom;

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
        toRoomDTO = new TransformIntoRoomDTOFunction();
        toRoom = new TransformIntoRoomFunction();
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
                RoomDTO roomDTO = toRoomDTO.apply(dataSnapshot);
                if (roomDTO != null) {
                    listener.onGetRoom(toRoom.apply(roomDTO));
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
                listener.onGetRoomList(FluentIterable
                        .from(dataSnapshot.getChildren())
                        .transform(toRoomDTO)
                        .filter(Predicates.<RoomDTO> notNull())
                        .transform(toRoom)
                        .toList());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                reference.removeEventListener(this);
                listener.onGetRoomList(new ArrayList<Room>());
            }
        });

    }

    private static class TransformIntoRoomDTOFunction implements Function<DataSnapshot, RoomDTO> {
        @Nullable
        @Override
        public RoomDTO apply(DataSnapshot roomSnapshot) {
            return roomSnapshot.getValue(RoomDTO.class);
        }
    }

    private static class TransformIntoRoomFunction implements Function<RoomDTO, Room> {
        @Override
        public Room apply(RoomDTO roomDTO) {
            return new Room.Builder()
                    .id(roomDTO.id)
                    .name(roomDTO.name)
                    .address(roomDTO.address)
                    .photoUrl(roomDTO.photoUrl)
                    .ownerId(roomDTO.ownerId)
                    .build();
        }
    }
}
