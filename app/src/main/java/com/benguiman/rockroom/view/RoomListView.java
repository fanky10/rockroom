package com.benguiman.rockroom.view;

import com.benguiman.rockroom.view.model.RoomViewModel;

import java.util.List;

/**
 * @author benjamin.massello.
 */

public interface RoomListView extends BaseView {
    void loadRoomList(List<RoomViewModel> roomList);
}
