package com.example.a_level.ui.calendar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a_level.R;


public class new_event_interface extends AppCompatActivity {
    public static String event_title;
    public static boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_interface_event);

        Button button = findViewById(R.id.new_event);

        EditText editText = findViewById(R.id.set_event_name);

        button.setOnClickListener(view -> {
            event_title = editText.getText().toString();//taking input from text input field
            check = true; // converting text input field to a string
            finish();
        });

    }

}
