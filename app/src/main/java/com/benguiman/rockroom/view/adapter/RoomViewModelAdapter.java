package com.benguiman.rockroom.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.benguiman.rockroom.R;
import com.benguiman.rockroom.view.model.RoomViewModel;

import java.util.List;

/**
 * @author benjamin.massello.
 */

public class RoomViewModelAdapter extends RecyclerView.Adapter<RoomViewModelAdapter.RoomViewHolder> {

    private List<RoomViewModel> list;
    private Context context;

    private RoomViewModelAdapter() {
    }

    public static RoomViewModelAdapter newInstance(List<RoomViewModel> roomViewModelList, Context context) {
        RoomViewModelAdapter adapter = new RoomViewModelAdapter();
        adapter.list = roomViewModelList;
        adapter.context = context;
        return adapter;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_room_view_model_adapter, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        holder.textViewRoomName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRoomName;

        public RoomViewHolder(View itemView) {
            super(itemView);
            this.textViewRoomName = (TextView) itemView.findViewById(R.id.tv_room_name);
        }
    }
}
