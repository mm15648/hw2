package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface listdao {
    @Insert
    void insertlist(listentity... words);

    @Update
    void updatelist(listentity...words);

    @Delete
    void deletealllist(listentity...words);

    @Query("DELETE FROM listentity")
    void deleteallword();

    @Query("SELECT * FROM listentity ORDER BY id DESC")
    LiveData<List<listentity>> getallwordLive();
}
