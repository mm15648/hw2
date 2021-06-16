package com.example.myapplication;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {listentity.class},version=1,exportSchema = false)
public abstract class listdatabase extends RoomDatabase{
    private static  listdatabase INSTANCE;
    static listdatabase getDatabase(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),listdatabase.class,"list_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract listdao getlistdao();
}
