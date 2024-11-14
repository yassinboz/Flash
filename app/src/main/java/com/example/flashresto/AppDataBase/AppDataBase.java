package com.example.flashresto.AppDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.flashresto.DAO.MenuDao;
import com.example.flashresto.entity.Menu;

@Database(entities = {Menu.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public static AppDataBase instance;

    public abstract MenuDao menuDao();

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "menu_db")
                    .addMigrations(MIGRATION_1_2) // Migration ajoutée ici
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    // Migration de la version 1 à la version 2 pour ajouter le champ rating
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE menu ADD COLUMN rating REAL NOT NULL DEFAULT 0");
        }
    };
}

