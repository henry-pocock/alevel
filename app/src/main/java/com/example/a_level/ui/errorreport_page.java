package com.example.a_level.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.a_level.R;

import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class errorreport_page extends android.app.Activity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_errorreport);

        final EditText error_editText = (EditText) findViewById(R.id.editTextTextMultiLine);

        button = findViewById(R.id.submit_error);
        button.setOnClickListener(view ->{
            String error_output = error_editText.getText().toString();
            finish();
        });
    }
}
