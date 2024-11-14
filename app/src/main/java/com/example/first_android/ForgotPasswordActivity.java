package com.example.first_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.first_android.databinding.ActivityForgotPasswordBinding;
import java.util.Random;

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
                // Inside onClickListener for reset password button
                String email = binding.resetEmail.getText().toString();
                if (email.equals("")) {
                    Toast.makeText(ForgotPasswordActivity.this, "Email is required", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkEmail = databaseHelper.checkEmail(email);
                    if (checkEmail) {
                        // Generate a reset code
                        String resetCode = String.valueOf(new Random().nextInt(999999));

                        // Update reset code in database
                        databaseHelper.updateResetCode(email, resetCode);

                        // Send email with the reset code
                        EmailUtil.sendEmail(email, "Password Reset Code", "Your reset code is: " + resetCode);

                        Toast.makeText(ForgotPasswordActivity.this, "Reset code sent to your email", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(ForgotPasswordActivity.this, VerifyResetCodeActivity.class);
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
