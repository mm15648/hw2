package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

@Entity
public class listentity {
    @PrimaryKey(autoGenerate = true)
    public   int id;
    @ColumnInfo(name="G_NAME")
    public  String gname;
    @ColumnInfo(name="P_SIZE")
    public   String pSize;

    public listentity(String gname, String pSize) {
        this.gname = gname;
        this.pSize = pSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }
}
