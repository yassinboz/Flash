package com.example.first_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.first_android.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.resetEmail.getText().toString();

                if (email.equals("")) {
                    Toast.makeText(ForgotPasswordActivity.this, "Email is required", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkEmail = databaseHelper.checkEmail(email);

                    if (checkEmail) {
                        // Here, you can send an email or display a password reset form
                        // For simplicity, we'll just display a message
                        Toast.makeText(ForgotPasswordActivity.this, "Password reset link sent", Toast.LENGTH_SHORT).show();

                        // Redirect user to a password update activity or return to login
                        Intent intent = new Intent(ForgotPasswordActivity.this, UpdatePasswordActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, "Email not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
