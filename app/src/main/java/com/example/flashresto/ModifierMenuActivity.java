package com.example.flashresto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flashresto.AppDataBase.AppDataBase;
import com.example.flashresto.entity.Menu;

public class ModifierMenuActivity extends AppCompatActivity {
    private EditText editTextPlat, editTextDescription, editTextPrix;
    private AppDataBase appDataBase;
    private int menuId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_menu);

        editTextPlat = findViewById(R.id.editTextPlat);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextPrix = findViewById(R.id.editTextPrix);
        Button saveButton = findViewById(R.id.saveButton);

        appDataBase = AppDataBase.getInstance(this);
        menuId = getIntent().getIntExtra("menuId", -1);

        Menu menu = appDataBase.menuDao().getMenuById(menuId);
        if (menu != null) {
            editTextPlat.setText(menu.getPlat());
            editTextDescription.setText(menu.getDescription());
            editTextPrix.setText(String.valueOf(menu.getPrix()));
        }

        saveButton.setOnClickListener(v -> {
            String newName = editTextPlat.getText().toString();
            String newDescription = editTextDescription.getText().toString();
            String newPriceText = editTextPrix.getText().toString();

            if (newName.isEmpty() || newDescription.isEmpty() || newPriceText.isEmpty()) {
                Toast.makeText(this, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int newPrice = Integer.parseInt(newPriceText);
                menu.setPlat(newName);
                menu.setDescription(newDescription);
                menu.setPrix(newPrice);
                appDataBase.menuDao().update(menu);
                Toast.makeText(this, "Menu modifié avec succès", Toast.LENGTH_SHORT).show();
                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Veuillez entrer un prix valide", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
