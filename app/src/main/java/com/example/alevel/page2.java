package com.example.alevel;

import  android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class page2 extends android.app.Activity {
    Button backButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        backButton = findViewById(R.id.activity_second_button);
        backButton.setOnClickListener(v -> finish());
    }

}


