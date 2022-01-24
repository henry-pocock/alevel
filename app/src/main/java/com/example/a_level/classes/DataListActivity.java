package com.example.a_level.classes;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a_level.R;
import com.example.a_level.data.Database;
import com.example.a_level.data.entities.ActionItem;

public class DataListActivity extends Activity {

    private boolean showAll = false;
    private List<ActionItem> actionItems;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        System.out.println("Setup: " + showAll);
        fetchData(showAll);

        DataListAdapter dataListAdapter = new DataListAdapter(actionItems);
        RecyclerView recyclerView = findViewById(R.id.allUsersList);

        recyclerView.setLayoutManager(new LinearLayoutManager(DataListActivity.this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(dataListAdapter);

        findViewById(R.id.showAll).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    showAll = ((androidx.appcompat.widget.SwitchCompat) findViewById(R.id.showAll)).isChecked();
                    System.out.println("New: " + showAll);
                    fetchData(showAll);
                    System.out.println("New Size: " + actionItems.size());
                    recyclerView.swapAdapter(new DataListAdapter(actionItems), true);
                }
                return false;
            }
        });


        findViewById(R.id.addNewBtn).setOnClickListener(v -> addRow());
    }

    private void addRow() {
        EditText detailsField = findViewById(R.id.detailsField);
        String detailsString = detailsField.getText().toString();

        ActionItem newActionItem = new ActionItem();
        newActionItem.date = new Date();
        newActionItem.details = detailsString;
        Database.add(getApplicationContext(), newActionItem);

        detailsField.setText("");
        detailsField.setFocusable(false);
        recreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void fetchData(boolean showAll) {
        System.out.println("Show All: " + showAll);
        if (showAll) {
            new Thread(() -> actionItems = Database.instance(getApplicationContext()).calendarDao().getAll()).start();
            System.out.println("ALL");
        } else {
            new Thread(() -> actionItems = Database.instance(getApplicationContext()).calendarDao().getNonComplete()).start();
            System.out.println("None");
        }


        waitForData();
        actionItems.forEach(ai -> System.out.println("id: " + ai.id + " Complete: " + ai.complete));
    }

    private void waitForData() {
        int attempts = 500;
        while (actionItems == null && attempts > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts--;
        }

        if (actionItems == null) {
            actionItems = new ArrayList<>();
        }
    }
}