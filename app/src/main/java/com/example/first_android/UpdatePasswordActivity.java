package com.example.first_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.first_android.databinding.ActivityUpdatePasswordBinding;

public class UpdatePasswordActivity extends AppCompatActivity {

    ActivityUpdatePasswordBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdatePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        String email = getIntent().getStringExtra("email");

        binding.updatePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = binding.newPassword.getText().toString();

                if (newPassword.equals("")) {
                    Toast.makeText(UpdatePasswordActivity.this, "Password is required", Toast.LENGTH_SHORT).show();
                } else {
                    boolean update = databaseHelper.updatePassword(email, newPassword);

                    if (update) {
                        Toast.makeText(UpdatePasswordActivity.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                        finish(); // Go back to login
                    } else {
                        Toast.makeText(UpdatePasswordActivity.this, "Password update failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
