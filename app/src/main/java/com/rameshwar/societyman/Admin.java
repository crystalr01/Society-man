package com.rameshwar.societyman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity {

    EditText usernameEditText, passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (isValid(username, password)) {

                    Toast.makeText(Admin.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Admin.this,AdminMain.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Admin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    usernameEditText.setError("Wrong Username");
                    passwordEditText.setError("Wrong password");
                }
            }
        });
    }

    private boolean isValid(String username, String password) {

        return "admin".equals(username) && "1234".equals(password);
    }
}
