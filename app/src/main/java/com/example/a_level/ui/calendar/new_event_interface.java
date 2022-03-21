package com.example.a_level.ui.calendar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a_level.R;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.util.Calendar;

public class new_event_interface extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_interface_event);

        Button button = findViewById(R.id.new_event);

        button.setOnClickListener(v -> { //binding to find the button in the xml file, lambda function for onClickListener
            CalenderEvent calendarEvent = findViewById(R.id.calendar_event);  //finding the calendar in the xml
            EditText eventNameEdit = findViewById(R.id.set_event_name); //taking input from text input field
            String eventName = eventNameEdit.getText().toString(); //converting text input field to a string
            Event event = new Event(Calendar.getInstance().getTimeInMillis(), eventName); //compiling the event data
            calendarEvent.addEvent(event); //committing the event to the calendar
            finish();
        });

    }
}
