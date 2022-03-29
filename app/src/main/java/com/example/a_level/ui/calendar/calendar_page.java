package com.example.a_level.ui.calendar;

import static com.example.a_level.ui.calendar.new_event_interface.event_title;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a_level.databinding.PageCalendarBinding;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.util.Calendar;


public class calendar_page extends Fragment {
    private PageCalendarBinding binding;
    public static String eventName;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = PageCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button new_event_button = binding.eventButton;

        //this is effectively an onCLickListener set for each day on the calendar,
        //which will once clicked display the event set on the selected day
        binding.calendarEvent.initCalderItemClickCallback(dayContainerModel -> {
            if (dayContainerModel.isHaveEvent()) {
                eventName = dayContainerModel.getEvent().getEventText(); //sets the global variable eventName
            } else {
                Log.d("gemma!", "No event");
            }
        });

        new_event_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), new_event_interface.class));
            }
        });



        if (new_event_interface.check) { //if check is true meaning that the submit button has been pressed
            CalenderEvent calenderEvent = binding.calendarEvent; //finding the calendar in the xml
            Event event = new Event(Calendar.getInstance().getTimeInMillis(), event_title); //compiling the event data
            calenderEvent.addEvent(event); //committing the event to the calendar
        }

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}