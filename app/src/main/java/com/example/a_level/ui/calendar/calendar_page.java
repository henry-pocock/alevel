package com.example.a_level.ui.calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

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

import org.w3c.dom.Text;

public class calendar_page extends Fragment {

    private PageCalendarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        calendar_view_model calendarViewModel = new ViewModelProvider(this).get(calendar_view_model.class);

        binding = PageCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.eventButton.setOnClickListener(v -> {
            CalenderEvent calendarEvent = binding.calendarEvent;
            EditText eventNameEdit = binding.setEventName;
            String eventName = eventNameEdit.getText().toString();
            Event event = new Event(Calendar.getInstance().getTimeInMillis(), eventName);
            calendarEvent.addEvent(event);
        });


        binding.calendarEvent.initCalderItemClickCallback(new CalenderDayClickListener() {
            @Override
            public void onGetDay(DayContainerModel dayContainerModel) {
                TextView dayEvent = binding.daysEvents;
                dayEvent.setText("");

               if ( dayContainerModel.isHaveEvent()) {
                   dayEvent.setText(dayContainerModel.getEvent().getEventText());
               } else {
                   Log.d("tim", "No event");
               }


            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}