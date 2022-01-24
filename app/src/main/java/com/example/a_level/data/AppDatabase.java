package com.example.a_level.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.a_level.data.daos.CalendarDao;
import com.example.a_level.data.entities.ActionItem;

@Database(
        version = 1,
        entities = {ActionItem.class}
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CalendarDao calendarDao();
}