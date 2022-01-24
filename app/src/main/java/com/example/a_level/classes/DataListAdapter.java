package com.example.a_level.classes;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a_level.R;
import com.example.a_level.data.Database;
import com.example.a_level.data.entities.ActionItem;

import java.util.ArrayList;
import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataViewHolder> implements View.OnClickListener {
    private final List<ActionItem> actionItems;

    public DataListAdapter(List<ActionItem> actionItems) {
        this.actionItems = actionItems;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_item, parent, false);

        return new DataViewHolder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        ActionItem actionItem = actionItems.get(position);
        holder.dt.setText(actionItem.date.toString());
        holder.details.setText(actionItem.details);
        ((androidx.appcompat.widget.SwitchCompat)holder.complete).setChecked(actionItem.complete);

        holder.itemView.setTag(actionItem);
        holder.complete.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                actionItem.complete = !actionItem.complete;
                Database.update(view.getContext(), actionItem);
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return actionItems.size();
    }

    @Override
    public void onClick(View view) {
        System.out.println(view.getTag());
    }
}