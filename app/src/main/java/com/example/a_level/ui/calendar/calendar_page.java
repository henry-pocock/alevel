package com.example.a_level.ui.calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a_level.Main;
import com.example.a_level.databinding.PageCalendarBinding;

import com.example.a_level.ui.errorreport_page;
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

        //calls the calendar view model, not in use at this point

        binding = PageCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = binding.eventButton;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), new_event_interface.class));
            }
        });




        //sets the page view

        //this is effectively an onCLickListener set for each day on the calendar,
        //which will once clicked display the event set on the selected day
        binding.calendarEvent.initCalderItemClickCallback(dayContainerModel -> {
            TextView dayEvent = binding.daysEvents;
            dayEvent.setText(""); //sets the text field as the event

           if ( dayContainerModel.isHaveEvent()) {
               dayEvent.setText(dayContainerModel.getEvent().getEventText()); //checks if there is an event
           } else {
               Log.d("tim", "No event"); //system response for event check
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