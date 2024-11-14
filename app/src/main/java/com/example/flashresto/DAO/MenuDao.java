package com.example.flashresto.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.flashresto.entity.Menu;

import java.util.List;

@Dao

public interface MenuDao {
    @Insert
    void insertOne(Menu menu );
    @Delete
    void delete (Menu menu);
    @Query("Select * FROM  menu ")
    List<Menu> getall();
    // Mettre à jour un menu existant
    @Update
    void update(Menu menu);

    @Query("SELECT * FROM menu WHERE id = :id")
    Menu getMenuById(int id);
}
