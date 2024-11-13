package com.example.flashresto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.flashresto.AppDataBase.AppDataBase;
import com.example.flashresto.entity.Menu;

public class    MainActivity extends AppCompatActivity {
    private AppDataBase app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editText = findViewById(R.id.Plat);
        EditText editText2 = findViewById(R.id.description);
        EditText editText3 = findViewById(R.id.prix);

        Button Ajouter = findViewById(R.id.Ajouter);
        app = AppDataBase.getInstance(this);

        Ajouter.setOnClickListener(v -> {
            Menu menuf = new Menu();
            menuf.setPlat(editText.getText().toString());
            menuf.setDescription(editText2.getText().toString());

            String prixText = editText3.getText().toString();
            if (!prixText.isEmpty()) {
                try {
                    int prix = Integer.parseInt(prixText);
                    menuf.setPrix(prix);
                    app.menuDao().insertOne(menuf);
                    Toast.makeText(this, "Menu ajouté avec succès", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Veuillez entrer un prix valide", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Veuillez entrer un prix", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
