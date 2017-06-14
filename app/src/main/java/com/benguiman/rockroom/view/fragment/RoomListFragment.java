package com.benguiman.rockroom.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benguiman.rockroom.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author benjamin.massello.
 */

public class RoomListFragment extends Fragment {

    @BindView(R.id.rv_room_list)
    RecyclerView roomListRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

}
