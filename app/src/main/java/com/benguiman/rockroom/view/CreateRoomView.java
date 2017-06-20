package com.benguiman.rockroom.view;

import com.benguiman.rockroom.view.model.RoomViewModel;

/**
 * @author benjamin.massello.
 */

public interface CreateRoomView extends BaseView {
    void onSaveRoom(RoomViewModel roomViewModel);

    void onSaveRoomError();
}
