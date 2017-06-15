package com.benguiman.rockroom.view;

import com.benguiman.rockroom.view.model.RoomViewModel;

import java.util.List;

/**
 * @author benjamin.massello.
 */

public interface RoomListView {
    void loadRoomList(List<RoomViewModel> roomList);
}
