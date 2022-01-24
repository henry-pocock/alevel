package com.example.a_level.data.daos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.a_level.data.entities.ActionItem;

@Dao
public interface CalendarDao {
    @Query("SELECT * FROM ActionItem")
    List<ActionItem> getAll();

    @Query("SELECT * FROM ActionItem WHERE complete = 0")
    List<ActionItem> getNonComplete();

    @Query("SELECT * FROM ActionItem WHERE id IN (:ids)")
    List<ActionItem> loadAllByIds(int[] ids);

    @Insert
    void insertAll(ActionItem... actionItems);

    @Delete
    void delete(ActionItem actionItem);

    @Update
    void update(ActionItem actionItem);
}
