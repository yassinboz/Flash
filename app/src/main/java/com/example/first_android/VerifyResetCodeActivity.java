package com.example.first_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.first_android.databinding.ActivityVerifyResetCodeBinding;

public class VerifyResetCodeActivity extends AppCompatActivity {

    ActivityVerifyResetCodeBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyResetCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        String email = getIntent().getStringExtra("email");

        binding.verifyCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredCode = binding.resetCode.getText().toString();
                String newPassword = binding.newPassword.getText().toString();

                if (enteredCode.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(VerifyResetCodeActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    // Verify reset code and update password
                    if (databaseHelper.checkResetCode(email, enteredCode)) {
                        boolean update = databaseHelper.updatePassword(email, newPassword);
                        if (update) {
                            Toast.makeText(VerifyResetCodeActivity.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                            finish(); // Go back to login
                        } else {
                            Toast.makeText(VerifyResetCodeActivity.this, "Password update failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(VerifyResetCodeActivity.this, "Invalid reset code", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
