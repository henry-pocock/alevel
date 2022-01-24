package com.example.a_level.classes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a_level.R;

public class DataViewHolder extends RecyclerView.ViewHolder {
    public TextView dt, details, complete;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        dt = itemView.findViewById(R.id.dt);
        details = itemView.findViewById(R.id.details);
        complete = itemView.findViewById(R.id.completeSwitch);
    }
}
