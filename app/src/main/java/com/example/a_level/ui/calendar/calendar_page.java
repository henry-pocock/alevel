package com.example.a_level.ui.calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a_level.databinding.PageCalendarBinding;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.listener.CalenderDayClickListener;
import com.skyhope.eventcalenderlibrary.model.DayContainerModel;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.util.Calendar;
import android.widget.Button;

public class calendar_page extends Fragment {

    private PageCalendarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        calendar_view_model calendarViewModel = new ViewModelProvider(this).get(calendar_view_model.class);

        binding = PageCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = binding.eventButton;
        button.setOnClickListener(v -> {
            CalenderEvent calendarEvent = binding.calendarEvent;
            Event event = new Event(Calendar.getInstance().getTimeInMillis(), "Test");
            calendarEvent.addEvent(event);
        });

        CalenderEvent calenderEvent = binding.calendarEvent;
        calenderEvent.initCalderItemClickCallback(dayContainerModel -> Log.d("Test", dayContainerModel.getDate()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}