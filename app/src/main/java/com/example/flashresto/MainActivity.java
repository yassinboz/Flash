package com.example.flashresto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flashresto.AppDataBase.AppDataBase;
import com.example.flashresto.entity.Menu;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDataBase appDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.plat);
        EditText editText2 = findViewById(R.id.description);
        EditText editText3 = findViewById(R.id.prix);
        Button ajouterButton = findViewById(R.id.Ajouter);
        Button afficherButton = findViewById(R.id.afficherButton);

        appDataBase = AppDataBase.getInstance(this);

        // Bouton pour ajouter un menu
        ajouterButton.setOnClickListener(v -> {
            String name = editText.getText().toString();
            String description = editText2.getText().toString();
            String priceText = editText3.getText().toString();

            if (name.isEmpty() || description.isEmpty() || priceText.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
//                int price = Integer.parseInt(priceText);
                Toast.makeText(this, "Menu added successfully", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid price", Toast.LENGTH_SHORT).show();
            }
        });

        // Bouton pour afficher le menu
        afficherButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AffichageMenu.class);
            startActivity(intent);
        });
    }
}
