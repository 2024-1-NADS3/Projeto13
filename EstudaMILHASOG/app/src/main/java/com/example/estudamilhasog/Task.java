package com.example.estudamilhasog;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.util.Date;

@Entity
public class Task {
    @NonNull
    @PrimaryKey
    public String name;

    public String userCreatorId;

    public String title;
    public Date date;

    public Task(String name, String userCreatorId, String title, Date date) {
        this.name = name;
        this.userCreatorId = userCreatorId;
        this.title = title;
        this.date = date;
    }
    public String toString(){
        return name;
    }
}