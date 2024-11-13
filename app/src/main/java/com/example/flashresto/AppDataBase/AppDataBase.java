package com.example.flashresto.AppDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.flashresto.DAO.MenuDao;
import com.example.flashresto.entity.Menu;

@Database(entities = {Menu.class}, version = 1, exportSchema = false)

public abstract class AppDataBase extends RoomDatabase {
    public static AppDataBase instance ;
    public abstract MenuDao menuDao();

    public static  AppDataBase getInstance( Context context) {
        if (instance==null){
            instance = Room.databaseBuilder(context .getApplicationContext(),AppDataBase.class,"menu_db").allowMainThreadQueries().build();
        }
        return instance;
    }
}
