package com.example.alevel;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;


public class Main extends AppCompatActivity {
    Button switchToSecondActivity;
    Button switchToThirdActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToSecondActivity = findViewById(R.id.activity_first_button);
        switchToSecondActivity.setOnClickListener(v -> {
            switchActivities1();
        });
        switchToThirdActivity = findViewById(R.id.activity_third_button);
        switchToThirdActivity.setOnClickListener(v -> {
            switchActivities2();
        });

    }


    private void switchActivities1(){
        Intent switchActivitiesIntent = new Intent(this, page2.class);
        startActivity(switchActivitiesIntent);
    }

    private void switchActivities2(){
        Intent switchActivitiesIntent = new Intent(this, page3.class);
        startActivity(switchActivitiesIntent);
    }

}

