package com.example.alevel;

import android.os.Bundle;
import android.widget.Button;

public class page3 extends android.app.Activity{
    Button backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        backToHome = findViewById(R.id.activity_fourth_button);
        backToHome.setOnClickListener(v -> finish());
    }
}
