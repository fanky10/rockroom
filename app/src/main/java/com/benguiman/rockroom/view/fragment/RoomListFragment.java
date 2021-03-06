package com.benguiman.rockroom.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benguiman.rockroom.R;
import com.benguiman.rockroom.presenter.RoomListPresenter;
import com.benguiman.rockroom.view.RoomListView;
import com.benguiman.rockroom.view.adapter.RoomViewModelAdapter;
import com.benguiman.rockroom.view.model.RoomViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author benjamin.massello.
 */

public class RoomListFragment extends BaseFragment<RoomListPresenter> implements RoomListView {

    @BindView(R.id.rv_room_list)
    RecyclerView roomListRecyclerView;

    public static RoomListFragment newInstance() {
        return new RoomListFragment();
    }

    @Override
    protected RoomListPresenter obtainPresenter() {
        return getRockRoomComponent().getRoomListPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_list, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void loadRoomList(List<RoomViewModel> roomList) {
        roomListRecyclerView.setHasFixedSize(true);
        roomListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        roomListRecyclerView.setAdapter(RoomViewModelAdapter.newInstance(roomList, getContext()));
    }
}
