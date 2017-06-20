package com.benguiman.rockroom.view;

import com.benguiman.rockroom.view.model.RoomViewModel;

/**
 * @author benjamin.massello.
 */

public interface RoomDetailView extends BaseView {
    String getRoomId();

    void onGetRoom(RoomViewModel roomViewModel);

    void onRoomNotFound();
}
