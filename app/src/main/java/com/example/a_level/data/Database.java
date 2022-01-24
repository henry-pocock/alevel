package com.example.a_level.data;

import android.content.Context;

import java.util.Date;

import androidx.room.Room;
import com.example.a_level.data.entities.ActionItem;

public class Database {
    public static AppDatabase instance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "henry-db").build();
    }

    public static void update(Context context, ActionItem actionItem) {
        System.out.println("Ready to save"  + actionItem.complete);
        new Thread(() -> {
            instance(context).calendarDao().update(actionItem);
        }).start();
    }

    public static void add(Context context, ActionItem actionItem) {
        new Thread(() -> {
            instance(context).calendarDao().insertAll(actionItem);
        }).start();
    }
}