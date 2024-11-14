package com.example.flashresto;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashresto.AppDataBase.AppDataBase;
import com.example.flashresto.entity.Menu;
import java.util.List;

public class AffichageMenu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppDataBase appDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_menu);

        appDataBase = AppDataBase.getInstance(this);
        List<Menu> menuList = appDataBase.menuDao().getall();
        Log.d("AffichageMenu", "Nombre de menus récupérés : " + menuList.size());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MenuAdapter(menuList, this));
    }
}
