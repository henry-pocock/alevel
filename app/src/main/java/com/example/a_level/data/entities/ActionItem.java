package com.example.a_level.data.entities;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.example.a_level.classes.Converter;


@Entity
public class ActionItem {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dt")
    @TypeConverters(Converter.class)
    public Date date;

    @ColumnInfo(name = "details")
    public String details;

    @ColumnInfo(name = "complete", defaultValue = "false")
    public boolean complete;
}

