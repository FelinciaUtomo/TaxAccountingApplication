package id.ac.petra.taxaccountingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.ac.petra.taxaccountingapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (username.equals("")||password.equals(""))
                    Toast.makeText(LoginActivity.this, "All fields are mandatory",
                            Toast.LENGTH_SHORT).show();
                else {Boolean checkCredentails = databaseHelper.checkEmailPassword(username,password);

                    if (checkCredentails == true){
                        Toast.makeText(LoginActivity.this, "Login Successfully!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}