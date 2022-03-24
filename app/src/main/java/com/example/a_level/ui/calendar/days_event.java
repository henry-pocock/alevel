package com.example.a_level.ui.calendar;

import static com.example.a_level.ui.calendar.calendar_page.eventName;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a_level.databinding.EventDaysFragmentBinding;



public class days_event extends Fragment {
    private EventDaysFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = EventDaysFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        TextView dayEvent = binding.daysEvents;
        dayEvent.setText(eventName);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
